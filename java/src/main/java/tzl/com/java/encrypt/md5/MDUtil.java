package tzl.com.java.encrypt.md5;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Maliang
 * @desc
 * @date 2017/12/13 下午2:09.
 */

public class MDUtil {
    public enum TYPE {
        MD2("MD2"),
        MD5("MD5"),
        SHA1("SHA-1"),
        SHA224("SHA-224"),
        SHA256("SHA-256"),
        SHA384("SHA-384"),
        SHA512("SHA-512");
        private String value;

        TYPE(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public static String encode(TYPE type, String data) {
        try {
            MessageDigest digest = MessageDigest.getInstance(type.getValue());
            digest.update(data.getBytes());
            return bytes2Hex(digest.digest());
        } catch (Exception e) {
            e.printStackTrace();
            return data;
        }
    }

    /**
     * 32位加密补零
     * @param bts
     * @return
     */
    private static String bytes2Hex(byte[] bts) {
        String des = "";
        String tmp = null;
        for (int i = 0; i < bts.length; i++) {
            tmp = (Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length() == 1) {
                des += "0";
            }
            des += tmp;
        }
        return des;
    }

    public static String FileMD(TYPE type, File file) {
        FileInputStream fileInputStream = null;
        try {
            MessageDigest digest = MessageDigest.getInstance(type.getValue());

            fileInputStream = new FileInputStream(file);
            byte[] buffer = new byte[8192];
            int    length;
            while ((length = fileInputStream.read(buffer)) != -1) {
                digest.update(buffer, 0, length);
            }
            return new BigInteger(1, digest.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            return file.getPath();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String MD5(String key) {
        char hexDigits[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };
        try {
            byte[] btInput = key.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
//        String key  = "password";
//        String data = "I believe you can.";
//        System.out.println("待MD字符串：" + data);
//        System.out.println(encode(TYPE.MD2, data));
//
//        //path表示你所创建文件的路径
//        String path      = "D:/";
//        File directory = new File(path);
//        if (!directory.exists()) {
//            directory.mkdirs();
//        }
//        // fileName表示你创建的文件名；为txt类型；
//        String fileName = "test.txt";
//        File file     = new File(directory, fileName);
//        if (!file.exists()) {
//            file.createNewFile();
//        }
//
//        System.out.println("待MD文件：" + file.getAbsolutePath());
//        System.out.println(FileMD(TYPE.MD5, file));


//        String strProcessed = "borrowId=147|chnl=tencent|cliTime=1536292173351|curVer=1.0.3|devcId=866859020858769|platform=1|token=c63f27c48d041ed3af950caaa25e96aa|type=10|userId=12|userId=12";
//        String str = "borrowId=147&chnl=tencent&cliTime=1536288926922&curVer=1.0.3&devcId=866859020858769&platform=1&token=f4d5e0813e73d476395d088d1f8442d9&type=10&userId=12";
        String str = "borrowId=147&bundleId=com.wniu.zufang&chnl=tencent&cliTime=1536299898770&curVer=1.0.3&devcId=866859020858769&platform=1&token=105d1285c723368b388d07646aaf535e&type=10&userId=12";
        String[] paramArray = str.split("&");
        List<String> list = Arrays.asList(paramArray);
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append("|" + list.get(i));
        }
        String apiKey = "auS7mOS6rOS4nOWNoeaYr+WQpumqhOWCsuS6huenr+WIhuesrOS4ieaetuS6hu+8m+WPkeeahOW/q+S5kOaSkui3r+mZhOi/keaJk+atu+S6hmpmZHNhOTNkc2FmZHNhNTRkZjY4M2ZkMWFzMzPlpKczZGYx5ZWK";
        System.out.println(sb.toString().substring(1));
        System.out.println(MD5(sb.toString().substring(1)+apiKey).toLowerCase());
//        System.out.println(MD5(strProcessed+apiKey));
    }



}

