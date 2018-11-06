package tzl.com.basicknowledage.basicknowledge;

/**
 * author: tangzenglei
 * created on: 2018/10/11 下午9:08
 * description: jvm 加载类成员的顺序
 */
public class ClassLoaderSequence {

    public static int k = 0;
    public static ClassLoaderSequence t1 = new ClassLoaderSequence("t1");
    public static ClassLoaderSequence t2 = new ClassLoaderSequence("t2");
    public static int i = print("i");
    public static int n = 99;
    public int j = print("j");

    {
        print("构造块");
    }
    static {
        print("静态块");
    }

    public ClassLoaderSequence(String str) {
        System.out.println((++k) + ":" + str + "   i=" + i + "    n=" + n);
        ++i;
        ++n;
    }

    public static int print(String str) {
        System.out.println((++k) + ":" + str + "   i=" + i + "    n=" + n);
        ++n;
        return ++i;
    }

    public static void main(String args[]) {
        ClassLoaderSequence t = new ClassLoaderSequence("init");
    }

}
