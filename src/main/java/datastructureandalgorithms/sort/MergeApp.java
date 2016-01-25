package datastructureandalgorithms.sort;

/**
 * Created by rod bate on 2016/1/21.
 */
public class MergeApp {

    public static void merge(int arrayA[], int sizeA, int arrayB[], int sizeB, int[] arrayC){
        int aDex = 0, bDex = 0, cDex = 0;
        while (aDex < sizeA && bDex < sizeB) {
            if (arrayA[aDex] < arrayB[bDex]) {
                arrayC[cDex++] = arrayA[aDex++];
            } else {
                arrayC[cDex++] = arrayB[bDex++];
            }
        }
        while (aDex < sizeA) {
            arrayC[cDex++] = arrayA[aDex++];
        }
        while (bDex < sizeB) {
            arrayC[cDex++] = arrayB[bDex++];
        }
    }


    public static void main(String[] args) {

        int[] a = {1,2,3,4};
        int[] b = {1,2,3,5,7,8};
        int[] c = new int[a.length + b.length];

        MergeApp.merge(a, a.length, b, b.length, c);

        for (int a1 : c) {
            System.out.print(a1 + " ");
        }

    }
}
