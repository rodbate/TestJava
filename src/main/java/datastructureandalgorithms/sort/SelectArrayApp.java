package datastructureandalgorithms.sort;

import java.util.Random;

/**
 * Created by rod bate on 2016/1/13.
 */
public class SelectArrayApp {

    public static void main(String[] args) {

        SelectArray array = new SelectArray(10000);
        /*array.insert(21).insert(11).insert(1).insert(34);

        System.out.println(array.display());
        System.out.println(array.sort().display());*/


        for (int i = 0; i < 10000; i++) {
            array.insert(new Random().nextInt(10000));
        }
        long start = System.currentTimeMillis();
        array.sort();
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "ms");
    }
}
