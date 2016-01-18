package datastructureandalgorithms.array;

/**
 * Created by rod bate on 2016/1/13.
 */
public class OrderArray {

    private int[] array;
    private int nElems;

    public OrderArray(int size){
        array = new int[size];
        nElems = 0;
    }

    public int size(){
        return nElems;
    }

    public int get(int index) {
        if (index > nElems - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return array[index];
    }

    //binary search   return : array index
    public int find(int searchKey){

        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;
        while(true){
            curIn = (lowerBound + upperBound)/2;
            if (array[curIn] == searchKey) {
                return curIn;
            } else if (lowerBound > upperBound) {
                return 0;
            } else {
                if (array[curIn] > searchKey) {
                   upperBound = curIn - 1;
                } else {
                    lowerBound = curIn + 1;
                }
            }
        }
    }

    public boolean insert(int key){
        if (nElems >= array.length) {
            return false;
        }
        int i;
        for (i = 0; i < nElems; i++) {
            if (key <= array[i]){
                break;
            }
        }

        if (i == nElems) {
            array[nElems++] = key;
        } else {
            int j = nElems;
            while(j > i) {
                array[j] = array[j - 1];
                j--;
            }
            array[i] = key;
            nElems++;
        }
        return true;
    }

    public boolean insertByBinary(int key){
        if (nElems >= array.length) {
            return false;
        }

        if (nElems == 0){
            array[nElems++] = key;
            return true;
        }

        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;
        while (true) {
            curIn = (lowerBound + upperBound)/2;
            if (lowerBound > upperBound) {
                break;
            }
            if (array[curIn] <= key) {
                lowerBound = curIn + 1;
                if (curIn < nElems - 1 && array[curIn + 1] >= key) {
                    curIn++;
                    break;
                }
                if (lowerBound >= nElems) {
                    curIn++;
                    break;
                }
            } else {
                upperBound = curIn - 1;
                if (curIn >= 1 && key >= array[curIn - 1]) {
                    break;
                }
                if (upperBound >= nElems) break;
            }
        }

        int j = nElems;
        while (j > curIn) {
            array[j] = array[j - 1];
            j--;
        }
        array[curIn] = key;
        nElems++;
        return true;
    }

    public boolean delete(int key){
        int index = find(key);
        if (index == 0) {
            return false;
        } else {
            while(index < nElems - 1){
                array[index] = array[index + 1];
                index++;
            }
            nElems--;
            return true;
        }
    }

    public String display(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < nElems; i++) {
            if (i == nElems - 1) {
                sb.append(array[i]);
            } else {
                sb.append(array[i] + " ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static OrderArray merge(OrderArray src1, OrderArray src2){
        int size1 = src1.size();
        int size2 = src2.size();
        OrderArray target = new OrderArray(size1 + size2);

        for (int i = 0; i < size1; i++) {
            target.insertByBinary(src1.get(i));
        }

        for (int i = 0; i < size2; i++) {
            target.insertByBinary(src2.get(i));
        }

        return target;
    }

}
