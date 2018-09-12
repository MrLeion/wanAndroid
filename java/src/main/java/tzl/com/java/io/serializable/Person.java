package tzl.com.java.io.serializable;

import java.io.Serializable;

/**
 * author: tangzenglei
 * created on: 2018/9/11 上午10:08
 * description:
 */
public class Person implements Serializable {
    /**
     * 序列化ID
     */
    private static final long serialVersionUID = -6303582245555761331L;



    private transient int age;
    private String name;
    private String sex;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}
