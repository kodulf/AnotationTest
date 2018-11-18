package simpletest;

public class SingleInstanceDemoEhanshi {

    private static SingleInstanceDemoEhanshi singleInstanceDemoEhanshi = new SingleInstanceDemoEhanshi();

    /**
     * 饿汉式
     * @return
     */
    public static SingleInstanceDemoEhanshi getSingleInstanceDemoEhanshi() {
        return singleInstanceDemoEhanshi;
    }
}
