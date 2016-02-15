package datastructureandalgorithms.quicksort;

/**
 * Created by rod bate on 2016/2/1.
 */
public class PartitionArray {

    private int[] value;
    private int nElems;

    public PartitionArray(int size){
        value = new int[size];
        nElems = 0;
    }

    public PartitionArray insert(int key){
        value[nElems++] = key;
        return this;
    }

    public PartitionArray part(int left, int right, int pivot){
        int leftPtr = left - 1;
        int rightPtr = right + 1;
        int temp;
        while (true) {
            while (leftPtr < right && value[++leftPtr] < pivot) ;
            while (rightPtr > left && value[--rightPtr] > pivot) ;
            if (leftPtr >= rightPtr) {
                break;
            } else {
                temp = value[leftPtr];
                value[leftPtr] = value[rightPtr];
                value[rightPtr] = temp;
            }
        }
        return this;
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

class PartitionArrayApp{

    public static void main(String[] args) {

        PartitionArray array = new PartitionArray(7);
        array.insert(11).insert(10).insert(2).insert(1).insert(6).insert(3).insert(23);
        System.out.println(array.display());
        System.out.println(array.part(0, 6, 5).display());
    }
}