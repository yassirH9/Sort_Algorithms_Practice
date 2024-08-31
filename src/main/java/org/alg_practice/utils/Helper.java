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
}
