package garbage_collection;

import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * VM args :
 *
 * -verbose:gc
 * -Xms20M   初始堆内存为20M
 * -Xmx20M   堆内存最大为20M      ------> 堆内存为20M
 * -Xmn10M   新生代内存为10M      ------> 老年代为(ParOldGen)10M
 * -XX:SurvivorRatio=8
 * -XX:MaxTenuringThreshold=1
 * -XX:+PrintGCDetails
 * -XX:+PrintTenuringDistribution
 */

public class TestTenuringThreshold {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {

        byte[] allocation1,allocation2,allocation3,allocation4;

        allocation1 = new byte[ _1MB / 4];

        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];

        /*List<String> list = ManagementFactory.getRuntimeMXBean().getInputArguments();

        list.forEach(System.out::print);*/



    }
}
