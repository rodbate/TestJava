import java.util.concurrent.*;


public class TestExecutors {

    public static void main(String[] args) throws Exception{

        ExecutorService service = Executors.newFixedThreadPool(4);

        String results = service.submit(new Callable<String>() {

            @Override
            public String call() throws Exception {
                return "the method call is invoked............current thread: "+Thread.currentThread().getName();
            }

        }).get();

        System.out.println(results);

        System.out.println("logicOrCharacter result: "+logicOrCharacter(1,2));
        System.out.println("logicAndCharacter result: "+logicAndCharacter(1,2));

    }



    public static int logicOrCharacter(int a,int b){
        return a | b;
    }

    public static int logicAndCharacter(int a,int b) {
        return a & b;
    }
}
