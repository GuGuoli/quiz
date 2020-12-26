import java.util.Map;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 */
public class IntersectOfTwoArrays {
    // 哈希表
    public int[] intersect(int[] nums1, int[] nums2)
    {
        if (nums1.length > nums2.length) 
        { return intersect(nums2, nums1); }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int num:nums1)
        {
            int count = map.getOrDefault(num, 0);
            map.put(num, count);
        }

        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num:nums2)
        {
            int count = map.getOrDefault(num, 0);
            if (count > 0)
            {
                intersection[index] = num;
                index++;
                count--;
                if (count > 0) map.put(num, count);
                else map.remove(num);
            }
        }

        return Arrays.copyOfRange(intersection, 0, index);
    }

    // 排序 双指针
    public int[] intersect2(int[] nums1, int[] nums2)
    {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int length1=nums1.length, length2 = nums2.length;
        int[] intersection = new int[Math.min(length1, length2)];

        int index1=0, index2=0, index = 0;

        while (index1<length1 && index2<length2)
        {
            if(nums1[index1] < nums2[index2]) index1++;
            else if (nums1[index1] > nums2[index2]) index2++;
            else 
            {
                intersection[index] = nums1[index1];
                index++;
                index1++;
                index2++;
            }
        }

        return Arrays.copyOfRange(intersection, 0, index);
    }
}
