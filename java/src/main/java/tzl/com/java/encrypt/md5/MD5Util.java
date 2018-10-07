package tzl.com.java.encrypt.md5;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MD5Util {
    public static String md5(String data) {
        try {
            StringBuffer buf = new StringBuffer();
            for (byte b : MessageDigest.getInstance("MD5").digest(data.getBytes("utf8")))
                buf.append(String.format("%02x", b & 0xff));
            return buf.toString();
        } catch (Exception e) {
            return null;
        }
    }


    /**
     * Title: 加密解密算法 执行一次加密，两次解密
     * Description: TestDemo
     * @author lu
     * @date 2016年6月23日 下午2:37:29
     * @param inStr
     * @return
     */
    public static String convertMD5(String inStr) {

        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;

    }
    public static String md5Decode(String str) {
        return convertMD5(convertMD5(str));
    }

    public static void main(String[] args) {
//        String info = new String(Base64.decode("WwogIHsKICAgICJuYW1lIiA6ICLlhrDlhrAiLAogICAgInBob25lIiA6ICIxNTEtNTE5Ni02MjIxIgogIH0sCiAgewogICAgIm5hbWUiIDogIuWwj+WGsOWGsCIsCiAgICAicGhvbmUiIDogIjE1MS01MTk2LTYyMjIiCiAgfSwKICB7CiAgICAibmFtZSIgOiAi5bCP5YWwIiwKICAgICJwaG9uZSIgOiAiMTUwLTIwMzMtOTMxNyIKICB9Cl0="));
//        System.out.println(info);

//        String s = "7c31ec71485deccf19119316530eaa1a";
//        String reg = "^[0-9A-Za-z]{8,64}$";
//        System.out.print(s.matches(reg));

//        String in = new String(Base64.decode("W3sibmFtZSI6IuacseWFg+eSiyIsInBob25lIjoiMTIzNDU2Nzg5MTIifSx7Im5hbWUiOiLmnLHmtbfku5kiLCJwaG9uZSI6IjE4MDkyNTE1MzA3In0seyJuYW1lIjoi5Z6a5Z6aIiwicGhvbmUiOiIxODc1ODEyODc4NCJ9LHsibmFtZSI6IuS4reWVhuayqua3sSjmtZnmsZ8p5a6e5Lia5pyJ6ZmQ5YWs5Y+4IiwicGhvbmUiOiIwNTcxMjgxMjA2MDQifSx7Im5hbWUiOiLmmI7lsbHmjqfogqHpm4blm6LmnInpmZDlhazlj7giLCJwaG9uZSI6IjA1NzEyODEyMDYwNCJ9LHsibmFtZSI6Iui+ifCfmJw6UCIsInBob25lIjoiMTM3NTcwMTU5MTgifSx7Im5hbWUiOiLoiIzlsJbkuIrnvo7po58iLCJwaG9uZSI6IjE1OTI1Njk2NTA1In0seyJuYW1lIjoi5a6B5amJ5a65IiwicGhvbmUiOiIxNTA2ODExMjgyMCJ9LHsibmFtZSI6IuWwj+iIheWmiCIsInBob25lIjoiMTUyMTU3MTU5ODIifSx7Im5hbWUiOiLlsI/lj5QiLCJwaG9uZSI6IjEzNzU3MDU4NzgxIn0seyJuYW1lIjoiNjAxIiwicGhvbmUiOiIxMzczODEwNjk3MCJ9LHsibmFtZSI6IjYwMCIsInBob25lIjoiMTc2ODE4ODA0NjYifSx7Im5hbWUiOiLmlofkuowxMTflhagiLCJwaG9uZSI6Ijg2NDgzMjc3In0seyJuYW1lIjoi5LiB57+U8J+YgfCfmKgiLCJwaG9uZSI6IjE4ODA2NTExMjUwIn0seyJuYW1lIjoi5a2f5Li9IiwicGhvbmUiOiIxMzUxMzgwNjMyMyJ9LHsibmFtZSI6IuW8oOeQpiIsInBob25lIjoiMTg4MTQ4MTAwMTgifSx7Im5hbWUiOiLmoqbmtIEiLCJwaG9uZSI6IjE1OTcwNjYxODYxIn0seyJuYW1lIjoi5o2i5bGPIiwicGhvbmUiOiIxMzc3NzQzNzg2MiJ9XQ"));
//        System.out.println(in);
        String str = "borrowId=147&chnl=tencent&cliTime=1536288926922&curVer=1.0.3&devcId=866859020858769&platform=1&token=f4d5e0813e73d476395d088d1f8442d9&type=10&userId=12";
//        String str = "bundleId=com.wniu.zufang&chnl=tencent&cliTime=1536292948975&curVer=1.0.3&devcId=866859020858769&platform=1&token=c63f27c48d041ed3af950caaa25e96aa&userId=12";
        String[] paramArray = str.split("&");
        List<String> list = Arrays.asList(paramArray);
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append("|" + list.get(i));
        }
        String apiKey = "auS7mOS6rOS4nOWNoeaYr+WQpumqhOWCsuS6huenr+WIhuesrOS4ieaetuS6hu+8m+WPkeeahOW/q+S5kOaSkui3r+mZhOi/keaJk+atu+S6hmpmZHNhOTNkc2FmZHNhNTRkZjY4M2ZkMWFzMzPlpKczZGYx5ZWK";
        System.out.println(sb.toString().substring(1));
        System.out.println(md5(sb.toString().substring(1)+apiKey));
    }
}
