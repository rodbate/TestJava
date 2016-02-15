package datastructureandalgorithms.shellsort;

/**
 * Created by rod bate on 2016/2/1.
 */
public class ShellSort {
    
    private int[] value;
    private int nElems;
    
    public ShellSort(int size){
        value = new int[size];
        nElems = 0;
    }
    
    public ShellSort insert(int key) {
        value[nElems++] = key;
        return this;
    }
    
    public ShellSort shellSort(){
        int inner, outer, temp;
        int h = 1;
        while (h < nElems/3) {
            h = h * 3 + 1;
        }
        
        while (h > 0) {
            for (outer = h; outer < nElems; outer++) {
                temp = value[outer];
                inner = outer;
                while (inner > h - 1 && value[inner - h] >= temp) {
                    value[inner] = value[inner - h];
                    inner -= h;
                }
                value[inner] = temp;
            }
            h = (h - 1)/3;
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

class ShellSortApp {

    public static void main(String[] args) {

        ShellSort array = new ShellSort(5);
        array.insert(23).insert(1).insert(3).insert(10).insert(5);
        System.out.println(array.display());
        array.shellSort();
        System.out.println(array.display());
    }
}