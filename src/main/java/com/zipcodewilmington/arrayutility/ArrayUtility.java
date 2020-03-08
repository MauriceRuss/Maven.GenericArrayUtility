package com.zipcodewilmington.arrayutility;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    private T[] array;

    public ArrayUtility(T[] array) {
        this.array = array;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T value){
        int numberOfDuplicates=0;
        T[] both = ArrayUtils.addAll(array, arrayToMerge);
        for ( int i = 0 ; i < both.length ; i++) {
            if (both[i].equals(value)) {
                numberOfDuplicates++;
            }
        }
        return numberOfDuplicates;
    }

    public Integer getNumberOfOccurrences(T value){
        return null;
    }

    public T getMostCommonFromMerge(T[] array){
        return null;
    }

    public T[] removeValue(T value){
        return ArrayUtils.removeAllOccurences(array,value);
    }

}
