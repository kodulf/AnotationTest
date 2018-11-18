package simpletest;

@Description(desc = "I am Class annotation", auth = "workder")
public class Worker implements People {


    //annotation 必须添加Target设置ElementType.FIELD
    @Description(desc = "I am field anntation", auth ="  workder")
    public String field;



    @Description(desc = "I am method anntation",auth = "worker")
    @Override
    public void work() {
        //局部变量的注解, 必须添加target的设置 ElementType.LOCAL_VARIABLE
        @Description(desc = "I am local_variable annotation",auth = "kodulf")
        int local_variable;
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
