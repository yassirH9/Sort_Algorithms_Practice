package org.alg_practice.algorithms;


import org.alg_practice.utils.Helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Sort {
    /*NOTES
    * there's no reason to keep the return in this method because the value required it's a list,
    * so it shares a pointer no a copy of the structure, which means that all the changes made to the list
    * will affect directly the original list.
    * Anyway, keep the return sentence it isn't a bad practice.
    * */
    /*
    * Complexity: O(N^2)
    * Advantage: simple to understand and code, work well with small datasets.
    * Disadvantage: time complexity of O(N^2), does not work well with large datasets, does not preserve the
    * relative order of equal keys witch means it is not stable.
    */
    public List<Integer> SelectionSort(List<Integer> inRandomArr){
        //save the size of the list to operate the indexes of itself
        int size = inRandomArr.size();

        for(int i = 0; i<size; i++){

            int minIndex = i;

            for(int a = i+1; a < size; a++){
                if(inRandomArr.get(a)<inRandomArr.get(minIndex)){
                    minIndex = a;
                }
            }
            if(!(minIndex == i)){
                //-> uncomment the next, if you wanna se the procedure took sorting the list in the terminal.
                //System.out.println("swap: current index ["+inRandomArr.get(i)+"] by minor found in index ["+inRandomArr.get(minIndex)+"]");
                int temp = inRandomArr.get(minIndex);
                inRandomArr.set(minIndex, inRandomArr.get(i));
                inRandomArr.set(i,temp);
            }
        }
        return inRandomArr;
    }
    /*
     * Complexity: O(N^2)
     * Advantage: easy to understand and implement, it doesn't require any memory space to swap, it's a stable sort alg
     * Disadvantage: the complexity makes it a bad sort alg for big datasets, also it need to compare all the values
     * this can course a lack of efficiency in certain cases.
     */
    public List<Integer> BubbleSort(List<Integer> inRandomArr){
        int size = inRandomArr.size();
        for(int i=0; i< size-1; i++){
            for(int a=0;a<size-1;a++){
                if(inRandomArr.get(a)>inRandomArr.get(a+1)){
                    //-> uncomment the next, if you wanna se the procedure took sorting the list in the terminal.
                    //System.out.println("swap "+inRandomArr.get(a)+" for "+inRandomArr.get(a+1));
                    //System.out.println(inRandomArr);
                    int temp = inRandomArr.get(a+1);
                    inRandomArr.set(a+1, inRandomArr.get(a));
                    inRandomArr.set(a,temp);
                }
            }
        }

        return inRandomArr;
    }
    /*
     * Complexity: O(N^2)
     * Advantage:
     * Disadvantage:
     */
    public List<Integer> InsertionSort(List<Integer> inRandomArr){
        int size = inRandomArr.size();
        for(int i=0; i<size;i++){
            int key = inRandomArr.get(i); //value to sort
            int val2 = i-1; //value to guide the sort process


            while(val2>= 0 && inRandomArr.get(val2)>key){
                inRandomArr.set(val2+1, inRandomArr.get(val2));
                val2 = val2-1;
            }

            inRandomArr.set(val2+1, key);
            //-> uncomment the next, if you wanna se the procedure took sorting the list in the terminal.
            //System.out.println("key: "+key+" to position: "+(val2+1));
            //System.out.println(inRandomArr);
        }
        return inRandomArr;
    }
    /*
     * Recurrence relation:        | O(1)           if n = 1
     *              T(n) =|
     *                    | 2T (n/2) + O(n)      if n > 1
     *-> T(n) represent the total time taken by the algorithm to sort an array of n size
     *-> 2T(n/2) represent the time taken by the algorithm to recursively sort the two halves of the array
     * since each half has n/2 elements the algorithm have two recursive calls with input size as (n/2)
     *-> O(n) represent the time taken to merge the two sorted halves
     *
     * Complexity: O(n log n)
     * Advantage:
     * Disadvantage:
     */
    public List<Integer> MergeSort(List<Integer> inRandomArr){
        if (inRandomArr.size() <= 1){
            return inRandomArr;
        }

        int mid = inRandomArr.size()/2;
        List<Integer> leftPart = new ArrayList<>(inRandomArr.subList(0,mid));
        List<Integer> rightPart = new ArrayList<>(inRandomArr.subList(mid,inRandomArr.size()));

        //recursively apply merge sort on each part
        MergeSort(leftPart);
        MergeSort(rightPart);

        //merge both halves into the list back
        inRandomArr = Helper.mergeList(inRandomArr,rightPart,leftPart);

        return inRandomArr;
    }
    /*
     * Recurrence relation:
     * Complexity: Best case O(N*logN) | average O(N*logN) | worse O(N^2)
     * Auxiliar space: O(1)
     * Advantage:
     * Disadvantage:
     */
    public List<Integer> QuickSort(List<Integer> inRandomArr, int low, int high){
        if(low<high){
            //find the pivot using the partition method
            int pivotindex = Helper.quickSortPartition(inRandomArr, low, high);

            //recursively sort the elements before and after the partition
            QuickSort(inRandomArr, low, pivotindex-1);
            QuickSort(inRandomArr, pivotindex+1,high);
        }
        return inRandomArr;
    }
    /*
     * Recurrence relation:
     * Complexity:O(log(n))
     * Auxiliar space:O(n)
     * Advantage:
     * Disadvantage:
     *
     * visual explain:
     * For an array [4, 10, 3, 5, 1]:
     * Build Max Heap → [10, 5, 3, 4, 1]
     * Swap 10 with 1 → [1, 5, 3, 4, 10] and heapify → [5, 4, 3, 1, 10]
     * Swap 5 with 1 → [1, 4, 3, 5, 10] and heapify → [4, 1, 3, 5, 10]
     * Repeat until sorted → [1, 3, 4, 5, 10]
     */
    public List<Integer> HeapSort(List<Integer> inRandomArr){
        int listSize = inRandomArr.size();

        //Step 1 build a max heap, this arranges the array into a heaop structure.
        for(int i = listSize / 2-1; i>=0; i--){
            Helper.heapify(inRandomArr,listSize,i);
        }
        //Step 2 extract elemments from the heap one by one
        for(int i = listSize-1; i>0; i--){
            //move the root(current largest element) to the end.
            Collections.swap(inRandomArr,0,i);
            //call heapify on the reduced heap to maintain heap structure
            Helper.heapify(inRandomArr,i,0);
        }
        return inRandomArr;
    }
    /*
     * Recurrence relation:
     * Complexity:
     * Auxiliar space:
     * Advantage:
     * Disadvantage:
     *
     * visual explain:
     *
     */
    public List<Integer> CountingSort(List<Integer> inRandomArr){
        // step 1) find the max value in the input list
        int maxVal = Collections.max(inRandomArr);
        /* step 2) create a count array with size (max+1)
        *  it will be used to store the frequency of each value in the input list
        */
        int[] countArr = new int[maxVal+1];
        /* step 3) count the occurrences of each element in the input list
        * and store it in the count array (countArr)
        * */
        for(int inRanArrVal: inRandomArr){
            countArr[inRanArrVal]++;
        }
        /* step 4) modify the count array (countArr) by adding the previous counts
        * this gives the actual position of elements in the sorted list
        * */
        for(int i = 1; i<countArr.length;i++){
            countArr[i] += countArr[i-1];
        }
        //step 5 create an output list to store the sorted elements
        List<Integer> outputList = new ArrayList<>(Collections.nCopies(inRandomArr.size(),0));
        /*step 6 build the output list by placing the elemments at the correct position
        * according to the count array (countArr) starting from the end to maintain stability
        */
        for(int i = inRandomArr.size()-1; i>=0; i--){
            int numTemp = inRandomArr.get(i);
            outputList.set(countArr[numTemp]-1, numTemp);
            countArr[numTemp]--;
        }
        /* step 7 and last one copy the sorted output list back into the oritinal list
        *
        * */
        for(int i =0;i<inRandomArr.size();i++){
            inRandomArr.set(i,outputList.get(i));
        }
        return inRandomArr;
    }
}
