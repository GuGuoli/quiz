/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 */

 /**
  * 集合、哈希表、求和求差 O(n) space
  */

  /**
    异或运算有以下三个性质:
    任何数和 00 做异或运算，结果仍然是原来的数
    任何数和其自身做异或运算，结果是 0
    异或运算满足交换律和结合律
  */

public class SingleNumber {

    // 位运算
    public int singleNumber(int [] nums)
    {
        int single = 0;
        for (int x:nums)
        {
            single ^= x;
        }

        return single;
    }
    
}
