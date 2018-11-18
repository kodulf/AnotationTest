package simpletest;

public class SingleInstanceDemo {

    private static SingleInstanceDemo singleInstanceDemo;

    /**
     * 懒汉式，一定要用同步的synchronized的方法modified
     * @return
     */
    public static synchronized SingleInstanceDemo getSingleInstanceDemo() {
        if(singleInstanceDemo == null){
            singleInstanceDemo = new SingleInstanceDemo();
        }
        return singleInstanceDemo;
    }
}
