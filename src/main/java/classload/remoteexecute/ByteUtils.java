package classload.remoteexecute;


public class ByteUtils {

    public static int bytes2Int(byte[] bytes, int start, int length){

        int sum = 0;
        int end = start + length;

        for (int i = start; i < end; i++) {
            int n = ((int)bytes[i]) & 0xff;
            n <<= (--length) * 8;
            sum = sum + n;
        }

        return sum;
    }


    public static byte[] int2Bytes(int value, int length){

        byte[] b = new byte[length];

        for (int i = 0; i < length; i++) {
            b[length - i - 1] = (byte)((value >> 8 * i) & 0xff);
        }

        return b;
    }

    public static String bytes2String(byte[] bytes, int start, int length){

        return new String(bytes, start, length);
    }

    public static byte[] string2Bytes(String str){
        return str.getBytes();
    }


    public static byte[] bytesReplace(byte[] src, int offset, int len, byte[] replace){
        byte[] newBytes = new byte[src.length + replace.length - len];

        System.arraycopy(src, 0, newBytes, 0, offset);
        System.arraycopy(replace, 0, newBytes, offset, replace.length);
        System.arraycopy(src, offset + len, newBytes, offset + replace.length, src.length - offset - len);

        return newBytes;
    }

}
