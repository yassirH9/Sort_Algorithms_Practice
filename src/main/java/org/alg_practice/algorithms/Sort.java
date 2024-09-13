package org.alg_practice.algorithms;


import org.alg_practice.utils.Helper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Sort {
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
}
