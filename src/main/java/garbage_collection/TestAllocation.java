package garbage_collection;

/**
 * VM args :
 *
 * -verbose:gc
 * -Xms20M   堆内存最小为20M
 * -Xmx20M   堆内存最大为20M      ------> 堆内存为20M
 * -Xmn10M   新生代内存为10M      ------> 老年代为(ParOldGen)10M
 * -XX:SurvivorRatio=8      eden大小与survivor比为8:1  新生代组成：Eden(8M) survivor(1M) survivor(1M)
 * -XX:+PrintGCDetails
 * -XX:PretenureSizeThreshold=51200
 *
 * 运行结果：
 *
 * Heap
     PSYoungGen      total 9216K, used 7784K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
     eden space 8192K, 95% used [0x00000000ff600000,0x00000000ffd9a1b0,0x00000000ffe00000)
     from space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
     to   space 1024K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x00000000fff00000)
     ParOldGen       total 10240K, used 4096K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
     object space 10240K, 40% used [0x00000000fec00000,0x00000000ff000010,0x00000000ff600000)
     Metaspace       used 3005K, capacity 4494K, committed 4864K, reserved 1056768K
     class space    used 328K, capacity 386K, committed 512K, reserved 1048576K

 */

public class TestAllocation {

    private static final  int _1MB = 1024 * 1024;

    public static void main(String[] args) {

        /*byte[] allocation1 = new byte[2 * _1MB];
        byte[] allocation2 = new byte[2 * _1MB];
        byte[] allocation3 = new byte[2 * _1MB];
        byte[] allocation4 = new byte[4 * _1MB];*/

        byte[] allocation1,allocation2,allocation3,allocation4;

        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[_1MB];

    }
}
