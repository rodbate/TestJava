package datastructureandalgorithms.recursive;

import datastructureandalgorithms.sort.BubbleArray;

import java.util.Random;

/**
 * Created by rod bate on 2016/2/1.
 */
public class MergeArray {

    private int[] value;
    private int nElems;

    public MergeArray(int size) {
        value = new int[size];
        nElems = 0;
    }

    public MergeArray insert(int v) {
        value[nElems++] = v;
        return this;
    }

    public MergeArray mergeSort(){
        int[] workSpace = new int[nElems];
        recMergeSort(workSpace, 0, nElems - 1);
        return this;
    }

    private void recMergeSort(int[] workSpace, int lowerBound, int upperBound) {
        if (lowerBound == upperBound) {
            return;
        } else {
            int mid = (lowerBound + upperBound)/2;
            recMergeSort(workSpace, lowerBound, mid);
            recMergeSort(workSpace, mid + 1, upperBound);
            merge(workSpace, lowerBound, mid + 1, upperBound);
        }
    }

    private void merge(int[] workSpace, int lowPtr, int highPtr, int upperBound) {
        int j = 0;
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1;

        while(lowPtr <= mid && highPtr <= upperBound){
            if (value[lowPtr] < value[highPtr]) {
                workSpace[j++] = value[lowPtr++];
            } else {
                workSpace[j++] = value[highPtr++];
            }
        }

        while (lowPtr <= mid){
            workSpace[j++] = value[lowPtr++];
        }

        while (highPtr <= upperBound) {
            workSpace[j++] = value[highPtr++];
        }

        System.arraycopy(workSpace, 0, value, lowerBound, n);
    }

    public String display(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < nElems; i++) {
            sb = i == nElems -1 ? sb.append(value[i]) : sb.append(value[i] + ",");
        }
        sb.append("]");
        return sb.toString();
    }
}

class MergeArrayApp {

    public static void main(String[] args) {

        /*MergeArray array = new MergeArray(5);
        array.insert(23).insert(1).insert(12).insert(3).insert(5);
        System.out.println(array.display());
        System.out.println(array.mergeSort().display());*/

        MergeArray array = new MergeArray(10000);

        for (int i = 0; i < 10000; i++) {
            array.insert(new Random().nextInt(10000));
        }
        long start = System.currentTimeMillis();
        array.mergeSort();
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "ms");
    }
}
