package datastructureandalgorithms.sort;

import java.util.Random;

/**
 * Created by rod bate on 2016/1/15.
 */
public class InsertSortApp {

    public static void main(String[] args) {

        InsertSortArray array = new InsertSortArray(5);
        array.insert(11).insert(2).insert(12).insert(1).insert(5);
        System.out.println(array.median());

        System.out.println(array.display());
        System.out.println(array.sort().display());

        /*for (int i = 0; i < 10000; i++) {
            array.insert(new Random().nextInt(10000));
        }
        long start = System.currentTimeMillis();
        array.sort();
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "ms");*/

    }
}
