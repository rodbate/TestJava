package datastructureandalgorithms.array;

/**
 * Created by rodbate on 2016/1/13.
 */
public class OrderArrayApp {

    public static void main(String[] args) {

        /*OrderArray array = new OrderArray(5);

        *//*array.insert(1);
        array.insert(11);
        System.out.println(array.insert(21));
        array.insert(18);
        array.insert(51);*//*

        array.insertByBinary(122);
        array.insertByBinary(911);
        array.insertByBinary(121);
        array.insertByBinary(211);
        array.insertByBinary(13);
        System.out.println(array.display());

        System.out.println(array.find(121));

        array.delete(121);
        System.out.println(array.display());*/

        OrderArray a1 = new OrderArray(3);
        OrderArray a2 = new OrderArray(5);

        a1.insertByBinary(12);
        a1.insertByBinary(2);
        a1.insertByBinary(121);

        a2.insertByBinary(11);
        a2.insertByBinary(1);
        a2.insertByBinary(311);
        a2.insertByBinary(121);
        a2.insertByBinary(111);

        System.out.println(OrderArray.merge(a1,a2).display());




    }
}
