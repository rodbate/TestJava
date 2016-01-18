package datastructureandalgorithms.array;


/**
 * Created by rod bate on 2016/1/12.
 */

public class HighArray {

    private int[] array;

    private int nElems;

    public HighArray(int size){
        array = new int[size];
        nElems = 0;
    }

    public int size(){
        return nElems;
    }
    public boolean insert(int value){
        if (nElems < array.length) {
            array[nElems++] = value;
            return true;
        }
        return false;
    }

    public boolean find(int searchKey){
        for (int i = 0; i < nElems; i++) {
            if (array[i] == searchKey) {
                return true;
            }
        }
        return false;
    }

    public boolean delete(int targetVal){
        int i;
        for (i = 0; i < nElems; i++) {
            if (array[i] == targetVal){
                break;
            }
        }
        if (i == nElems) {
            return false;
        } else {
            while(i < nElems - 1) {
                array[i] = array[i + 1];
                i++;
            }
            --nElems;
            return true;
        }

    }

    //get the max element in the specific array
    public int getMax(){

        if (nElems == 0) {
            return -1;
        }
        int max = array[0];
        for (int i = 1; i < nElems; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    //remove the max element in the specified array
    public int removeMax(){
        int max = getMax();
        if (max == -1) {
            return -1;
        }

        if (delete(max)) {
            return max;
        } else {
            return -1;
        }
    }

    public HighArray noDup(){
        int current;
        for (int i = 0; i < nElems; i++) {
            current = array[i];
            for (int j = i + 1; j < nElems; j++) {
                if (current == array[j]) {
                    array[j] = -1;
                }
            }
        }
        while(find(-1)) {
            delete(-1);
        }
        return this;
    }


    public String display(){
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < nElems; i++) {
            if (i + 1 == nElems) {
                sb.append(array[i]);
            } else {
                sb.append(array[i] + ", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
