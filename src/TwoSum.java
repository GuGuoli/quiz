import java.util.Map;
import java.util.HashMap;


public class TwoSum {
    // 暴力枚举
    public int[] twoSum(int[] nums, int target)
    {
        int n = nums.length;
        for (int i=0; i<n; i++) 
        {
            for (int j=i+1; j<n; j++) 
            {
                if (nums[i] + nums[j] == target) 
                return new int[] {i, j};
            }
        }

        return new int[0];
    }

    // 哈希表
    public int[] twoSum2(int[] nums, int target)
    {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i=0; i<nums.length; i++) 
        {
            if (hashtable.containsValue(target-nums[i]))
            return new int[] {hashtable.get(target - nums[i]), i};

            hashtable.put(nums[i], i);
        }

        return new int[0];
    }
}
