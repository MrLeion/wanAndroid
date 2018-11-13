package tzl.com.basicknowledage.version;

/**
 * author: tangzenglei
 * created on: 2018/11/12 上午11:54
 * description:
 */
public class JavaVersion {


    private static final String javaVersion;

    static {
        javaVersion = System.getProperty("java.version");
        System.out.println("javaVersion=" + javaVersion);
    }




    public static String getJavaVersion() {
        return javaVersion;
    }

    public static boolean isJava8() {
        return javaVersion.contains("1.8.");
    }





}
