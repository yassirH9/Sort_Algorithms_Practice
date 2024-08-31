package org.alg_practice;

import org.alg_practice.algorithms.Sort;
import org.alg_practice.utils.Helper;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Helper helper = new Helper();
        //Generate Random values list
        List<Integer> randomArr = helper.genArr(10);
        System.out.println(randomArr);
        //Sorting
        Sort sort = new Sort();
        List<Integer> sortedArr = sort.SelectionSort(randomArr);
        System.out.println(sortedArr);

    }
}