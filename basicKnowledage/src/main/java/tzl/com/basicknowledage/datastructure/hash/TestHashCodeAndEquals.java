package tzl.com.basicknowledage.datastructure.hash;

import java.util.HashSet;
import java.util.Iterator;

/**
 * author: tangzenglei
 * created on: 2018/9/12 下午5:22
 * description: 两对象相等是 hashcode() 和 equals() 无必然的联系
 * hashcode 和 对象内存地址 是对应的
 */
public class TestHashCodeAndEquals {





     public static void main(String[] args){

         Person person = new Person(1);
         Person person1 = new Person(3);
         System.out.println("person == person?==========="+person.equals(person1));

         System.out.println(person.hashCode());
         System.out.println(person1.hashCode());


         //以下以 String 为例
         //两个不同的 String 对象
         String s1 = new String("aaa");
         String s2 = new String("aaa");
         System.out.println(s1 == s2);
         System.out.println(s1.equals(s2));
         System.out.println(s1.hashCode());
         System.out.println(s2.hashCode());

         //常量池对象
         String s3 = "aaa";
         String s4 =  "aaa";
         System.out.println(s3 == s4);
         System.out.println(s3.equals(s4));
         System.out.println(s3.hashCode());
         System.out.println(s4.hashCode());



         HashSet<String> hashSet = new HashSet<>();
         hashSet.add(s1);
         hashSet.add(s2);
         hashSet.add(s3);
         hashSet.add(s4);
         Iterator<String> iterator = hashSet.iterator();
         while (iterator.hasNext()) {
             System.out.println(iterator.next());
         }
     }
}


class Person{


    int age ;

    public Person(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}