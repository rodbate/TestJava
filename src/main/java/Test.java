import java.lang.management.ManagementFactory;
import java.util.List;

public class Test {


    private static int m;


    public static void main(String[] args) {

        List<String> list = ManagementFactory.getRuntimeMXBean().getInputArguments();

        list.forEach(System.out::print);


        //Runtime.getRuntime().exec();
    }

    public static void t(){

        //int i = this.m;         ERROR


    }

}
