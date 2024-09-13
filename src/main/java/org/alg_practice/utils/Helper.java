package org.alg_practice.utils;
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

    //helper to merge two list into one
    public static List<Integer> mergeList(List<Integer>originalList, List<Integer> leftPart, List<Integer> rightPart){
        int i=0, j=0, k=0;

        //loop through both lists merge them and sorting it in order
        while (i < leftPart.size() && j < rightPart.size()){
            if(leftPart.get(i) <= rightPart.get(j)){
                originalList.set(k++,leftPart.get(i++));
            }else{
                originalList.set(k++,rightPart.get(j++));
            }
        }
        while(i < leftPart.size()){
            originalList.set(k++, leftPart.get(i++));
//            System.out.println(leftPart.get(i++

        }
        while(k < rightPart.size()){
            originalList.set(k++, rightPart.get(j++));
//            System.out.println(rightPart.get(i++));

        }
        return originalList;
    }
}
