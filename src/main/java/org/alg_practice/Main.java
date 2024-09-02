package org.alg_practice;

import org.alg_practice.algorithms.Sort;
import org.alg_practice.utils.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Helper helper = new Helper();
        //Generate Random values list
        List<Integer> randomArr = helper.genArr(5);
        System.out.println(randomArr);


        //SORT CODE
        Sort sort = new Sort();

        //take the current time of the system to count execution time after sort
        long startSortTime = System.nanoTime();
        List<Integer> sortedArr = new ArrayList<>(); //list to place the new values sorted

        //-> uncomment below to sort by selection
        //sortedArr = sort.SelectionSort(randomArr);

        //-> uncomment below to sort by bubble
        //sortedArr = sort.BubbleSort(randomArr);

        //-> uncomment below to sort by insertion
        sortedArr = sort.InsertionSort(randomArr);
        long endSortTime = System.nanoTime();
        System.out.println(sortedArr);
        System.out.println("\033[0;32m"+"Sort process last: "+(endSortTime-startSortTime)+" ns | "+((endSortTime-startSortTime)/1_000_000)+" ms" +"\033[0m");

    }
}