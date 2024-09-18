package org.alg_practice.utils;

import java.util.*;

public class Helper {
    /*
     * PORPOISE: Generate a list with random numbers between 0-100
     * USED IN: Main
     * VARS: [size: used to set the method a max size of the list you want to it to return]
     * */
    public static List<Integer>  genArr(int size){
        List<Integer>RandomArr = new ArrayList<>();
        Random random = new Random();
        size--;
        for(int i=0; i<=size;i++){
            RandomArr.add(random.nextInt(100));
        }
        return RandomArr;
    }
    /*
    * PORPOISE: merge two lists into one sorting the elements inside beforehand merge it
    * USED IN: merge sort method in class Sort
    * */
    public static List<Integer> mergeList(List<Integer>originalList, List<Integer> leftPart, List<Integer> rightPart){
        int i=0, j=0, k=0;

        //loop through both lists merge them and sorting it in order
        while (i < leftPart.size() && j < rightPart.size()){
            //if the element in the left list is smaller it's added to the merged list
            if(leftPart.get(i) <= rightPart.get(j)){
                originalList.set(k++,leftPart.get(i++));
            }else{ //otherwise it added from the right list
                originalList.set(k++,rightPart.get(j++));
            }
        }
        // copying the remaining elements from the left list.
        while(i < leftPart.size()){
            originalList.set(k++, leftPart.get(i++));}
        while(j < rightPart.size()){
            originalList.set(k++, rightPart.get(j++));
        }
        return originalList;
    }
    /*
     * PORPOISE: method used to divide the list from the pivot above and under
     * USED IN: quick sort method in class Sort
     * */
    public static int quickSortPartition(List<Integer> listIn, int low, int high){
        int pivot = listIn.get(high);//pivot element
        int minorVal_index = low-1; //index of the smaller element

        for(int i = low; i< high; i++){
            if(listIn.get(i) <= pivot){
                minorVal_index++;

                //swap the element in minorVal_index and i
                swap(listIn, minorVal_index,i);
            }
        }

        //place the pivot element at the correct position
        swap(listIn,minorVal_index+1,high);

        return minorVal_index+1;
    }
    /*
     * PORPOISE: this method swap elements inside a list using both indexes of the elements and a reference of the list
     * USED IN: quick sort method in class Sort
     * */
    public static void swap (List<Integer> listIn, int i, int minorVal_index){
        int temp = listIn.get(minorVal_index);
        listIn.set(minorVal_index, listIn.get(i));
        listIn.set(i,temp);
    }
    /*
     * PORPOISE:this function maintains the max-heap properly in the heap-sort algorithm
     * USED IN:heap sort method in class Sort
     * NOTE: heapSize used to pass the size of the heap (or sub-heap) rootElement used to pass the index of the current element in the heap
     * */
    public static void heapify(List<Integer> listIn, int heapSize, int rootElement){
        int largest = rootElement;//initialize largest as the root.
        int leftTree = 2 * rootElement + 1;//left child index.
        int rightTree = 2 * rootElement + 2;//right child index.

        //if left child is larger than root
        if(leftTree < heapSize && listIn.get(leftTree)>listIn.get(largest)){
            largest = leftTree;
        }
        //uf right child is larger than the current largest
        if(rightTree < heapSize && listIn.get(rightTree)>listIn.get(largest)){
            largest = rightTree;
        }
        //if the larges is not the root, swap abd continue heapifying
        if(largest != rootElement){
            Collections.swap(listIn, rootElement, largest);

            //recursively heapify the affected subtree
            heapify(listIn,heapSize,largest);
        }

    }
}
