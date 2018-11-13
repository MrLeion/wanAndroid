package tzl.com.basicknowledage.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * author: tangzenglei
 * created on: 2018/11/12 上午10:58
 * description:
 */
public class Solution {


    /**
     * 349.两整数集合交集
     * 思路：双层遍历去重
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] returnArrays = {};
        if (nums1 ==null||
                nums2==null||
                nums1.length == 0||
                nums2.length == 0) {
            return returnArrays;
        }
        List<Integer> list1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());
        list1.retainAll(list2);
        if (list1!=null) {
            return  new HashSet<>(list1).stream().mapToInt(Integer::intValue)
                    .toArray();
        } else {
            return returnArrays;
        }
    }


    /**
     * 202-快乐数
     *思路：不重复循环
     * @param n
     * @return
     */
    public boolean isHappy(int n) {


        HashSet<Integer> result = new HashSet<>();

        while (n!=1) {
            int temp = 0;
            //获取数字每一位：1.转化为字符数组取每一位2.非 0 整除 10

            while (n!=0) {
                temp += (n % 10) * (n % 10);
                n /= 10;
            }

            n = temp;

            if (result.contains(n)) {
                break;
            }else{
                result.add(n);
            }
        }
        return n == 1;

    }


    /**
     * 217 -  存在重复元素
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums==null||nums.length==0) {
            return false;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;

    }



    /**
     * 350.两个数组的交集 II
     */
    public int[] intersect(int[] nums1, int[] nums2) {

        int[] returnArrays = {};
        if (nums1 ==null||
                nums2==null||
                nums1.length == 0||
                nums2.length == 0) {
            return returnArrays;
        }

        HashMap<Integer, Integer> statics= new HashMap<>();
        Set<Integer> result = new HashSet<>();

        for (int num : nums1) {
            statics.put(num, statics.get(num) == null ? 0 : statics.get(num)+1);
        }


        for (int num : nums2) {

            //存在于 map 中
            if (statics.get(num)!=null) {
                result.add(num);
            }
            statics.put(num, statics.get(num) == null ? 0 : statics.get(num)+1);
        }

        returnArrays = result.stream().mapToInt(Integer::intValue).toArray();
        return returnArrays;

    }













}




