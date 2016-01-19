package datastructureandalgorithms.sort;

import java.util.Random;

/**
 * Created by rod bate on 2016/1/15.
 */
public class InsertSortApp {

    public static void main(String[] args) {

        InsertSortArray array = new InsertSortArray(7);
        array.insert(2).insert(2).insert(12).insert(12).insert(12).insert(13).insert(14);
        System.out.println(array.median());

        System.out.println(array.display());
        System.out.println(array.enhancedSort().display());
        System.out.println(array.getCompTimes());
        System.out.println(array.getDupTimes());
        array.noDuplication();
        System.out.println(array.display());

        /*for (int i = 0; i < 10000; i++) {
            array.insert(new Random().nextInt(10000));
        }
        long start = System.currentTimeMillis();
        array.sort();
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "ms");*/

    }
}
