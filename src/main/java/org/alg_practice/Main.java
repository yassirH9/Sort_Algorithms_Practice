package org.alg_practice;

import org.alg_practice.algorithms.Sort;
import org.alg_practice.utils.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Generate Random values list
        //List<Integer> randomArr = Helper.genIntegerList(5);
        //System.out.println(randomArr);


        //SORT CODE
        Sort sort = new Sort();

        //take the current time of the system to count execution time after sort
        long startSortTime = System.nanoTime();
        List<Integer> sortedArr = new ArrayList<>(); //list to place the new values sorted

        //-> uncomment below to sort by selectionsort
        //sortedArr = sort.SelectionSort(randomArr);

        //-> uncomment below to sort by bubblesort
        //sortedArr = sort.BubbleSort(randomArr);

        //-> uncomment below to sort by insertionsort
        //sortedArr = sort.InsertionSort(randomArr);

        //-> uncomment below to sort by Mergesort
        //sortedArr = sort.MergeSort(randomArr);

        //-> uncomment below to sort by quicksort
        //sortedArr = sort.QuickSort(randomArr, 0, randomArr.size()-1);

        //-> uncomment below to sort by heapsort
        //sortedArr = sort.HeapSort(randomArr);

        //-> uncomment below to sort by countingsort
        //sortedArr = sort.CountingSort(randomArr);

        //-> uncomment below to sort by radixsort
        //sortedArr = sort.RadixSort(randomArr);

        //-> uncomment below to sort by bucketsort
        List<Double> randomArr = Helper.genDoubleList(5);
        System.out.println(randomArr);




        long endSortTime = System.nanoTime();
        System.out.println(sortedArr);
        System.out.println("\033[0;32m"+"Sort process last: "+(endSortTime-startSortTime)+" ns | "+((endSortTime-startSortTime)/1_000_000)+" ms" +"\033[0m");

    }
}