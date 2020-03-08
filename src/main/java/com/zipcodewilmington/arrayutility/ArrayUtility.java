package com.zipcodewilmington.arrayutility;

import org.apache.commons.lang3.ArrayUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    private final T[] array;

    public ArrayUtility(T[] array) {
        this.array = array;
    }

    private Integer countNumberOfOccurrences(T[] array, T value) {
        int numberOfDuplicates=0;
        for ( int i = 0 ; i < array.length ; i++) {
            if (array[i].equals(value)) {
                numberOfDuplicates++;
            }
        }
        return numberOfDuplicates;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T value){
        return countNumberOfOccurrences(ArrayUtils.addAll(array, arrayToMerge),value);
    }

    public Integer getNumberOfOccurrences(T value){
        return countNumberOfOccurrences(array,value);
    }

    public T getMostCommonFromMerge(T[] arrayToMerge){
        /**
         *Creating HasMap form merger array.
         * use the value of hashmap to count the number of occurances
         * compare number of occurrances for highest
         * return key with the highest value
         */
        HashMap<T, Integer> common = new HashMap<>();
        T[] both = ArrayUtils.addAll(array, arrayToMerge);
        for(int i = 0; i < both.length; i ++){
            if(common.containsKey(both[i])){
                Integer count = common.get(both[i]);
                count++;
                common.put(both[i],count);
            }else{
                common.put(both[i], 1);
            }
        }
        T mostOcVal = null;
        Integer highestNumOfOcc = 0;
        for(Map.Entry<T, Integer> entry : common.entrySet()){
            if(entry.getValue() >= highestNumOfOcc){
                mostOcVal = entry.getKey();
                highestNumOfOcc = entry.getValue();

            }
        }

        return mostOcVal;
    }

    public T[] removeValue(T value){
        return ArrayUtils.removeAllOccurences(array,value);
    }

}
