package tzl.com.basicknowledage.search;

/**
 * author: tangzenglei
 * created on: 2018/11/12 上午10:58
 * description:
 */
public class SolutionTest {


     public static void main(String[] args) {
//         int[] results = new Solution().intersection(new int[]{1}, new int[]{1});
         int[] results = new Solution().intersect(new int[]{1}, new int[]{1});
         for (int i = 0; i < results.length; i++) {
             System.out.println(results[i]);
         }

         System.out.println(new Solution().containsDuplicate(new int[]{1,2,3,1}));



        //函数式接口 lamda+java.util.function+stream+method reference+optional 简化代码
         MyLamadaInterface aBlockOfCode = (s)-> System.out.println(s);
     }


    @FunctionalInterface
    interface MyLamadaInterface {
        void doSth(String s);
    }
}