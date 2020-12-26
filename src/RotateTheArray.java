/**
 * 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */
public class RotateTheArray {

    // 暴力
    public void rotate(int[] nums, int k)
    {
        int temp, previous;
        for (int i=0; i<k; i++)
        {
            previous = nums[nums.length-1];
            for (int j=0; j< nums.length; j++)
            {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    // 使用额外的数组
    // 空间复杂度 O(n)
    public void rotate2(int[] nums, int k)
    {
        int[] a = new int[nums.length];
        for (int i=0; i<nums.length; i++) 
        {
            a[(i+k)%nums.length] = nums[i];
        }

        for (int i=0; i<nums.length; i++) 
        {
            nums[i] = a[i];
        }

    }

    // 使用环状替换 time O(n) space O(1)
    public void rotate3(int[] nums, int k)
    {
        k = k % nums.length;
        int count = 0;
        for(int start = 0; start < nums.length; start++)
        {
            int current = start;
            int prev = nums[start];
            do
            {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;

                current = next;
                count++;

            } while (start != current);
        }
    }

    // 使用反转
    public void reverse(int[] nums, int start, int end)
    {
        while(start < end)
        {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate4(int[] nums, int k)
    {
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
    
}
