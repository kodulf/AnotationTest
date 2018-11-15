package simpletest;

@Description(desc = "I am Class annotation", auth = "workder")
public class Worker implements People {


    @Description(desc = "I am field anntation", auth ="  workder")
    public String field;



    @Description(desc = "I am method anntation",auth = "worker")
    @Override
    public void work() {

    }

    @Override
    public void sleep() {

    }




    @Deprecated
    @Override

    public void eat() {

    }

    /*
    没有这个接口的话，override的会报错的
    @Override
    public void hello(){

    }
    */
}
