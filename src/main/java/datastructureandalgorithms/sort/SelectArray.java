package datastructureandalgorithms.sort;

/**
 * Created by rod bate on 2016/1/13.
 */
public class SelectArray {

    private int[] value;
    private int nElems;

    public SelectArray(int size){
        value = new int[size];
        nElems = 0;
    }

    public SelectArray insert(int key){
        if (nElems > value.length - 1) throw new ArrayIndexOutOfBoundsException();
        value[nElems++] = key;
        return this;
    }

    public SelectArray sort(){
        int min, j, tmp;
        for (int i = 0; i < nElems - 1; i++) {
            min = i;
            for (j = i + 1; j < nElems; j++) {
                if (value[j] < value[min]) {
                    min = j;
                }
            }
            tmp = value[i];
            value[i] = value[min];
            value[min] = tmp;
        }
        return this;
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
