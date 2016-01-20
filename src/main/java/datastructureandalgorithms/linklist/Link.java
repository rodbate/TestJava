package datastructureandalgorithms.linklist;

/**
 * Created by rod bate on 2016/1/20.
 */
public class Link {

    /**
     * 准备阶段时，为类变量(被static修饰的)在方法区分配内存并且初始化
     * 而实例变量是在对象实例化(也就是<init>方法被调用)时在java堆中分配内存
     */

    private int iData;
    private double dData;
    private Link next;

    public Link(int i, double d){
        iData = i;
        dData = d;
    }

    public void display(){
        System.out.print("{" + iData + ", " + dData + "}  ");
    }

    public int getIData() {
        return iData;
    }

    public void setIData(int iData) {
        this.iData = iData;
    }

    public double getDData() {
        return dData;
    }

    public void setDData(double dData) {
        this.dData = dData;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }
}
