package annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class UseCaseTracker {

    public static void main(String[] args){

        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,2,3,4);

        getUseCaseTracker(list,Testable.class);

    }

    /**
     * 获取usecase 使用的情况
     * @param list 是使用的number的表
     * @param testClass 测试testClass
     */
    public static void getUseCaseTracker(List<Integer> list, Class testClass){
        for(Method method: testClass.getDeclaredMethods()){
            UseCase annotation = method.getAnnotation(UseCase.class);
            if(annotation==null){
                continue;
            }
            System.out.println("TestCase contain id "+annotation.id()+" "+annotation.description());
            //千万要注意下面，如果是直接用annotation.id()它会把它当作index
            list.remove(new Integer(annotation.id()));//这里如果写list.remove(annotation.id())会报错Exception in thread "main" java.lang.UnsupportedOperationException
        }

        for (Integer i: list){
            System.out.println("TestCase not contain id :"+i);
        }

    }
}
