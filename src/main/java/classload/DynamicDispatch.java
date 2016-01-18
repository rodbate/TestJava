package classload;


public class DynamicDispatch {


    static class A {
        public void say(){
            System.out.println("A.......");
        }
    }

    static class B extends A{
        /*@Override
        public void say() {
            System.out.println("B........");;
        }*/
    }

    static class C extends A{
        @Override
        public void say() {
            System.out.println("C........");;
        }
    }

    public static void main(String[] args) {

        //A static type B actual type
        // dynamic dispatch =====> override
        // static dispatch =====> overload

        A b = new B();
        A c = new C();

        b.say();
        c.say();



    }
}
