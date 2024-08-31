package org.alg_practice.algorithms;


import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Sort {
    public List<Integer> SelectionSort(List<Integer> inRandomArr){
        int size = inRandomArr.size();

        for(int i = 0; i<size; i++){

            int minIndex = i;

            for(int a = i+1; a < size; a++){
                if(inRandomArr.get(a)<inRandomArr.get(minIndex)){
                    minIndex = a;
                }
            }
            if(!(minIndex == i)){
                System.out.println("swap: current index ["+inRandomArr.get(i)+"] by minor found in index ["+inRandomArr.get(minIndex)+"]");
                int temp = inRandomArr.get(minIndex);
                inRandomArr.set(minIndex, inRandomArr.get(i));
                inRandomArr.set(i,temp);
            }
        }
        return inRandomArr;
    }


}
