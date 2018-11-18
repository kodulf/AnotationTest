package simpletest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解可以是在
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * 宝宝输入的，呵呵
 *
 *
 *
 *
 *
 */

/**
 * 注意FIELD是注解类变量和实例变量的，而LOCAL_VARIABLE是注解的局部变量的，这个就涉及到Field和Variable的区别了
 * 先说一下 field 和 variable 之间的区别：
 *
 * class variables and instance variables are fields while local variables and parameter variables are not. All fields are variables.
 *
 * 成员变量（field）是指类的数据成员，而方法内部的局部变量（local variable）、参数变量（parameter variable）不能称作 field。field 属于 variable，也就是说 variable 的范围更大。
 */

@Target({ElementType.FIELD,ElementType.TYPE,ElementType.METHOD,ElementType.LOCAL_VARIABLE})
//@Target({ElementType.LOCAL_VARIABLE,ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/**
 * 注解：描述，包括描述，作者，和年龄
 */
public @interface Description {
    String desc();
    String auth();
    int age() default 18;
}
