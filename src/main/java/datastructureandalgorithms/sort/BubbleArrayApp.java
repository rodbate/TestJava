package datastructureandalgorithms.sort;

import java.util.Random;

/**
 * Created by rod bate on 2016/1/13.
 */
public class BubbleArrayApp {

    public static void main(String[] args) {

        /*BubbleArray array = new BubbleArray(5);
        array.insert(1).insert(11).insert(2).insert(4).insert(19);

        System.out.println(array.display());
        System.out.println(array.sort().display());*/

        BubbleArray array = new BubbleArray(10000);

        for (int i = 0; i < 10000; i++) {
            array.insert(new Random().nextInt(10000));
        }
        long start = System.currentTimeMillis();
        //array.sort();
        array.enhancedSort();
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "ms");


    }
}
