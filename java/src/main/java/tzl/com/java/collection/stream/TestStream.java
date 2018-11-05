package tzl.com.java.collection.stream;

import android.annotation.SuppressLint;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * author: tangzenglei
 * created on: 2018/11/5 下午5:00
 * description:https://www.ibm.com/developerworks/cn/java/j-lo-java8streamapi/index.html
 *
 *
 * Intermediate：
 map (mapToInt, flatMap 等)、 filter、 distinct、 sorted、 peek、 limit、 skip、 parallel、 sequential、 unordered

 Terminal：
 forEach、 forEachOrdered、 toArray、 reduce、 collect、 min、 max、 count、 anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 iterator

 Short-circuiting：
 anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 limit
 */
@SuppressLint("NewApi")
public class TestStream {


     public static void main(String[] args){


         
         

      /**
       * ================================================================================================
       *    ==============================================转换大写字母=========================================
       * ================================================================================================
       */
         ArrayList<String> wordList = new ArrayList<>();
         wordList.add("hello");
         wordList.add("t");
         wordList.add("z");
         wordList.add("l");


         List<String> upperCases = wordList.stream()
                 .map(String::toUpperCase)
                 .collect(Collectors.toList());

         for (String string:upperCases ){
             System.out.println(string);
         }



         /**
          * ================================================================================================
          *    ==============================================转换大写字母=========================================
          * ================================================================================================
          */













     }

}
