package datastructureandalgorithms.array;

import java.util.Arrays;

/**
 * Created by rod bate on 2016/1/12.
 */
public class HighArrayApp {


    public static void main(String[] args) {

        HighArray highArray = new HighArray(5);



        highArray.insert(1);
        highArray.insert(1);
        highArray.insert(31);
        highArray.insert(31);
        //highArray.insert(31);
        int size = highArray.size();
        System.out.println(highArray.display());
        System.out.println(highArray.noDup().display());

        /*int[] newArray = new int[size];
        for (int i = 0; i < size; i++) {
            newArray[i] = highArray.removeMax();
        }
        for (int i = 0; i < newArray.length; i++) {
            System.out.println(newArray[i]);
        }*/

        //System.out.println(highArray.getMax());
        /*System.out.println(highArray.removeMax());
        System.out.println(highArray.display());

        System.out.println(highArray.find(32));
        highArray.insert(222);

        System.out.println(highArray.display());

        highArray.delete(1);

        System.out.println(highArray.display());*/

    }
}
