package demo1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by bob on 2017/5/23.
 *
 * @author bob   <bobyang_coder@163.com>
 * @since 2017/5/23
 */
public class Demo1Main {

    public static void main(String[] args) {
        Person person = new Person();
        //获取类上的注解
        Annotation[] annotations = person.getClass().getDeclaredAnnotations();//获取类上标记的注解
        for (Annotation annotation : annotations) {
            if (annotation.annotationType() == VersionInfo.class) {
                System.out.println(annotation.toString());
            }
        }
        Method[] methods = person.getClass().getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("=====" + method.isAnnotationPresent(VersionInfo.class));
        }
    }
}
