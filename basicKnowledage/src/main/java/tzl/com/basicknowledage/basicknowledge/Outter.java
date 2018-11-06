package tzl.com.basicknowledage.basicknowledge;

/**
 * author: tangzenglei
 * created on: 2018/10/9 下午1:48
 * description:
 * 内部类可访问外部类任何成员(静态和非静态)
 *
 * 注：内部类理解为一个普通的成员，
 *
 *    case1          非静态内部类      静态内部类静态方法               静态内部类静态方法
 * 静态成员             直接访问            直接访问                          直接访问
 * 非静态成员           直接访问          new Outter().非静态成员       new Outter().非静态成员
 *
 *
 *
 *     case2            非静态内部类成员                 静态内部类成员
 * 静态成员函数     new Outter().new Inner().**           new Outter.Inner().**
 * 非静态成员函数   new  Outter.this.Innner().**       new Outter.Inner().**
 *
 *
 *
 *  case3 :  匿名内部类访问局部变量 加上 final
 *
 *
 *
 *
 */
public class Outter {

    private int i_private = 1;


    private static int j_private = 2;


    public class Inner {



        private int getI_private() {
            return Outter.this.i_private;
        }



        public  int getJ_private() {
            return  j_private;
        }




    }



    public static class StaticInner {


        private static int  getI_private_static() {
            return new Outter().i_private;
        }


        private int getJ_private() {
            return j_private;
        }




    }




     public static void main(String[] args){
         StaticInner staticInner = new Outter.StaticInner();
         Inner inner = new Outter().new Inner();//!!!

     }








}
