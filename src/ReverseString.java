/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 */
public class ReverseString {
    public void reverseString(char[] s)
    {
        int n = s.length;
        for (int left=0, right=n-1; left<right; left++, right--)
        {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }
}
