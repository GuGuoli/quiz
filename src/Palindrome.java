/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 */
public class Palindrome {
    // 筛选 + 判断
    public boolean isPalindrome(String s)
    {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i=0; i<length; i++)
        {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) 
            { 
                sgood.append(Character.toLowerCase(ch));
            }
        }

        StringBuffer sgood_rev = new StringBuffer(sgood).reverse();
        return sgood.toString().equals(sgood_rev.toString());
    }

    // 双指针
    public boolean isPalindrome2(String s)
    {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i=0; i<length; i++)
        {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) 
            { 
                sgood.append(Character.toLowerCase(ch));
            }

        }
        int n = sgood.length();
        int left = 0, right = n - 1;
        while (left < right)
        {
            if (Character.toLowerCase(sgood.charAt(left)) != Character.toLowerCase(sgood.charAt(right))) 
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 在原字符上直接判断
    public boolean isPalindrome3(String s)
    {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right)
        {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;

            if (left < right) 
            {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                { return false; }
            }
            left++;
            right--;
        }
        return true;
    }
    
}
