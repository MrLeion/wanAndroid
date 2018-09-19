package tzl.com.java.ThreadPool.buyTicket;

/**
 * author: tangzenglei
 * created on: 2018/9/19 下午9:25
 * description:
 */
public class TestBuyTicket {
    
     public static void main(String[] args){

         for (int i = 0; i < 4; i++) {


             new BuyTicket().start();
         }

      }
}
