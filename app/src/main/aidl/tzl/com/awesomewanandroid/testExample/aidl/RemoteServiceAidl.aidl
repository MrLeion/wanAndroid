// RemoteService.aidl
package tzl.com.awesomewanandroid.testExample.aidl;

// Declare any non-default types here with import statements
import tzl.com.awesomewanandroid.testExample.aidl.Person;


interface RemoteServiceAidl {

   /**
     * 除了基本数据类型，其他类型的参数都需要标上方向类型：in(输入), out(输出), inout(输入输出)
     */
    void addPerson(in Person person);

    List<Person> getPersonList();

}
