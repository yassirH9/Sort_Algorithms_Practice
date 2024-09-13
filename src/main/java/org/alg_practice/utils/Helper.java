package org.alg_practice.utils;
import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class Helper {
    public List<Integer>  genArr(int size){
        List<Integer>RandomArr = new ArrayList<>();
        Random random = new Random();
        size--;
        for(int i=0; i<=size;i++){
            RandomArr.add(random.nextInt(100));
        }
        return RandomArr;
    }
    //helper to merge two lists into one, sorting it
    //used in merge sort
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
}
