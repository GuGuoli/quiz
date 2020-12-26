import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 */
class ContainsDuplicate 
{
    // 排序，扫描
    public boolean containsDuplicate(int[] nums)
    {
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0; i < n-1; i++)
        {
            if (nums[i]==nums[i+1]) 
            {
                return true;
            }
        }

        return false;
    }

    // 哈希表
    public boolean containsDuplicate2(int[] nums) 
    {
        Set<Integer> set = new HashSet<Integer>();
        for (int x: nums)
        {
            if (!set.add(x))
            {
                return true;
            }

        }

        return false;
    }
}