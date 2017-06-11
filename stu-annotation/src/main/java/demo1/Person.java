package demo1;

/**
 * Created by bob on 2017/5/23.
 *
 * @author bob   <bobyang_coder@163.com>
 * @since 2017/5/23
 */
@VersionInfo(auther = "yhb", version = "1.0.1", desc = "bob make")
public class Person {

    private String name;

    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
