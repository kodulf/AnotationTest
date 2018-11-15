package simpletest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {

    @SuppressWarnings("deprecation")
    public static  void main(String[] args){
        testDeprecated();

        //通过反射来得到注解里面的内容，包括类的注解和方法的注解
        useReflectToGetClassMethodFiledAnnotation();
    }

    private static void useReflectToGetClassMethodFiledAnnotation(){
        try {
            Class<?> cl = Class.forName("simpletest.Worker");

            if(cl!=null){
                Description annotation = cl.getAnnotation(Description.class);
                if(annotation!=null){
                    System.out.println("auth:"+annotation.auth()+" age:"+annotation.age()+" desc:"+annotation.desc());
                }

                getMethodAnnotation(cl, annotation);

                getFieldAnnotations(cl, annotation);

            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取
     * @param cl
     * @param annotation
     */
    private static void getFieldAnnotations(Class<?> cl, Description annotation) {
        Field[] declaredFields = cl.getDeclaredFields();
        for (Field field: declaredFields){
            Description fieldAnnotation = field.getAnnotation(Description.class);
            if(fieldAnnotation!=null){
                System.out.println("Field annotation: "+"auth:"+annotation.auth()+" age:"+annotation.age()+" desc:"+annotation.desc());
            }
        }
    }

    private static void getMethodAnnotation(Class<?> cl, Description annotation) {
        Method[] declaredMethods = cl.getDeclaredMethods();
        for (Method method: declaredMethods){
            Description methodAnnotation = method.getAnnotation(Description.class);
            if(methodAnnotation!=null){
                System.out.println("Method annotation: "+"auth:"+annotation.auth()+" age:"+annotation.age()+" desc:"+annotation.desc());
            }
        }
    }

    /**
     * 测试原有的过期的注解
     */
    @SuppressWarnings("deprecated")
    private static void testDeprecated() {
        Worker work  = new Worker();
        work.eat();
    }
}
