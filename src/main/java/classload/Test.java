package classload;


import classload.remoteexecute.ByteUtils;

import java.util.Arrays;
import java.util.List;

public class Test {
    //public static final Class<Byte>     TYPE = (Class<Byte>) Class.getPrimitiveClass("byte");

    public static void main(String[] args) {

        //System.out.println(SubClass.value);
        //System.out.println(SubClass.constant);
        //System.out.println(C.str);

        /*byte b = -127;
        int n = ((int) b) & 0xff;
        System.out.println(b & 0xff);
        System.out.println(((int)b) & 0xff);
        System.out.println(n<<8);*/

        /*byte[] b = {5, 2, 3, 4};
        int i = ByteUtils.bytes2Int(b,0,2);
        System.out.println(i);
        byte[] bytes = ByteUtils.int2Byte(i, 2);
        //System.out.println(Arrays.asList(ByteUtils.int2Byte(i,1)));
        for (int i1 = 0; i1 < bytes.length; i1++) {
            System.out.println(bytes[i1]);
        }*/

        //System.out.println(Integer.TYPE);



        Integer a = 1;
        Integer b = 1;
        Integer c = 2;
        Long d = 3L;

        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(d == (a + b));
        System.out.println(d.equals(a + b));


        /*while(false){
            System.out.println(1);
        }*/
    }


   /* public static String method(List<String> list) {
        return null;
    };*/

    public static int method(List<Integer> list) {
        return 1;
    }

    //List<Integer> list = Arrays.asList(1);
}
