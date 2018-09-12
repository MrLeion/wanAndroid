package tzl.com.java.collection.list.arrayList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * author: tangzenglei
 * created on: 2018/9/11 下午5:55
 * description:
 */
//public class DynamicArray {
//
//    public static int pivotIndex(int[] nums) {
//        if (nums==null||nums.length<2) {
//            return -1;
//        }
//
//
//        int totalSum = sum(nums);
//        for (int i = 0; i < nums.length; i++) {
//            int leftSum = sum(nums, 0, i)-nums[i];
//            int rightSum = totalSum-leftSum-nums[i];
//            if (leftSum == rightSum) {
//                return i;
//            }
//        }
//
//        return -1;
//    }
//
//    public static  int sum(int[] nums) {
//        return sum(nums, 0, nums.length - 1);
//
//    }
//
//
//    //求和 [start,end]
//    public static int sum(int[] nums,int start,int end) {
//        if (nums==null
//                ||nums.length<start
//                ||nums.length<end
//                ||start>end) {
//            return 0;
//        }
//        int sum = 0;
//        for (int i = start; i <=end; i++) {
//            sum += nums[i];
//        }
//        return sum;
//    }
//
//
//
//    public static void main(String[] args){
//        int[] nums = {1, 7, 3, 6, 5, 6};
////        int[] nums = {1, 2, 3};
//        System.out.print(pivotIndex(nums));
////        System.out.print(sum(nums,0,nums.length));
//    }
//
//
//}
//
//
class Solution {
    public int pivotIndex(int[] nums) {
        if (nums==null||nums.length<2) {
            return -1;
        }


        int totalSum = sum(nums);
        for (int i = 0; i < nums.length; i++) {
            int leftSum = sum(nums, 0, i)-nums[i];
            int rightSum = totalSum-leftSum-nums[i];
            if (leftSum == rightSum) {
                return i;
            }
        }

        return -1;
    }

    public  int sum(int[] nums) {
        return sum(nums, 0, nums.length - 1);

    }


    //求和 [start,end]
    public int sum(int[] nums,int start,int end) {
        if (nums==null
                ||nums.length<start
                ||nums.length<end
                ||start>end) {
            return 0;
        }
        int sum = 0;
        for (int i = start; i <=end; i++) {
            sum += nums[i];
        }
        return sum;
    }
}




public class DynamicArray {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            int ret = new Solution().pivotIndex(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
