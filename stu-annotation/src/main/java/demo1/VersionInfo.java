package demo1;

import java.lang.annotation.*;

/**
 * 版本信息注解
 *
 * @author bob   <bobyang_coder@163.com>
 * @since 2017/5/23
 */
@Target(ElementType.TYPE)//该注解用于声明作用目标范围
@Retention(RetentionPolicy.RUNTIME)//VM将在运行期也保留注释，因此可以通过反射机制读取注解的信息
@Documented//将此注解包含在javadoc中
@Inherited//允许子类继承父类中的注解
public @interface VersionInfo {

    String auther() default "bob";

    String version() default "1.0.0";

    String desc() default "no description";

}
