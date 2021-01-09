package com.lwj.test.count;

/**
 * @author: linwj
 * @date: 2020-12-13 14:51
 * @description:
 **/
public class ExclusiveOrTest {

    public static void main(String[] args) {
        //进位运算
        //0^N=N
        //N^N=0
        int a = 123;
        int b = 456;
        a = a ^ b;
        b = a ^ b;//相当于b=a^b^b=a
        a = a ^ b;//相当于a=a^b^a=b
        System.out.println(a);
        System.out.println(b);
    }

    public int[] singleNumbers(int[] nums) {

        //假设出现奇数次的数字为a和b
        int eor = 0;
        for (int num : nums) {
            //循环结束后的eor=a^b不等于0
            //说明a和b至少一位地方不同
            eor = eor ^ num;
        }
        //找到eor最右边的1
        int rightOne = eor & (~eor + 1);
        int eor1=0;
        for (int num : nums) {
            //!=0说明数组中该位置为1的数字
            if ((num & rightOne) != 0) {
                eor1 = eor1 ^ num;
            }
        }
        int res[]=new int[2];
        res[0]=eor1;
        res[1]=(eor^eor1);
        return res;
    }
}
