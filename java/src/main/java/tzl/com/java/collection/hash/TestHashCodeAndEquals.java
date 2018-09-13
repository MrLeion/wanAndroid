package tzl.com.java.collection.hash;

/**
 * author: tangzenglei
 * created on: 2018/9/12 下午5:22
 * description:
 */
public class TestHashCodeAndEquals {





     public static void main(String[] args){


         Person person = new Person(1);
         Person person1 = new Person(2);
         System.out.println("person == person?==========="+person.equals(person1));

         System.out.println(person.hashCode());
         System.out.println(person1.hashCode());


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