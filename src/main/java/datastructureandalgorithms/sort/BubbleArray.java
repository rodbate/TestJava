package datastructureandalgorithms.sort;

/**
 * Created by rod bate on 2016/1/13.
 */
public class BubbleArray {

    private int[] value;
    private int nElems;

    public BubbleArray(int size){
        value = new int[size];
        nElems = 0;
    }

    public BubbleArray insert(int key){
        if (nElems > value.length - 1) throw new ArrayIndexOutOfBoundsException();
        value[nElems++] = key;
        return this;
    }

    public BubbleArray enhancedSort(){
        int flag = 0;
        for (int out = nElems - 1; out > 1; out--) {

            for (int in = flag; in < out; in++) {
                int tmp;
                if (value[in] > value[in + 1]) {
                    tmp = value[in + 1];
                    value[in + 1] = value[in];
                    value[in] = tmp;
                }
            }

            for (int i = out - 1; i > flag; i--) {
                int tmp;
                if (value[i - 1] > value[i]) {
                    tmp = value[i - 1];
                    value[i - 1] = value[i];
                    value[i] = tmp;
                }
            }
            flag++;
        }
        return this;
    }

    public BubbleArray sort(){
        for (int out = nElems - 1; out > 1 ; out--) {
            int temp;
            for (int in = 0; in < out; in++) {
                if (value[in] > value[in + 1]) {
                    temp = value[in + 1];
                    value[in + 1] = value[in];
                    value[in] = temp;
                }
            }
        }
        return this;
    }

    // sort by odd and even
    public BubbleArray oddEvenSort(){
        boolean sorted = false;
        int temp;
        while(!sorted){
            sorted = true;

            //odd
            for (int i = 1; i < nElems; i+=2) {
                if (i < nElems - 1 && value[i] > value[i +1]) {
                    temp = value[i + 1];
                    value[i + 1] = value[i];
                    value[i] = temp;
                    sorted = false;
                }
            }

            //even
            for (int i = 0; i < nElems; i+=2) {
                if (i < nElems - 1 && value[i] > value[i +1]) {
                    temp = value[i + 1];
                    value[i + 1] = value[i];
                    value[i] = temp;
                    sorted = false;
                }
            }
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
