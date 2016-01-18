package datastructureandalgorithms.sort;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rod bate on 2016/1/15.
 */

public class InsertSortArray {

    private int[] value;
    private int nElems;

    public InsertSortArray(int size){
        value = new int[size];
        nElems = 0;
    }


    public InsertSortArray insert(int key){
        if (nElems > value.length - 1) throw new ArrayIndexOutOfBoundsException();
        value[nElems++] = key;
        return this;
    }

    public InsertSortArray sort(){
        int temp, j;
        for (int i = 1; i < nElems; i++) {
            temp = value[i];
            j = i;
            while(j > 0 && value[j - 1] >= temp){
                value[j] = value[j - 1];
                j--;
            }
            value[j] = temp;
        }
        return this;
    }

    public Map<Integer, Integer> median(){
        Map<Integer, Integer> map = new HashMap<>();
        this.sort();
        if (nElems % 2 == 0) {
            map.put(nElems/2 - 1, value[nElems/2 - 1]);
            map.put(nElems/2, value[nElems/2]);
        } else {
            map.put(nElems/2, value[nElems/2]);
        }
        return map;
    }


    public String display(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < nElems; i++) {
            if (i == nElems - 1) {
                sb.append(value[i]);
            } else {
                sb.append(value[i] + " ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
