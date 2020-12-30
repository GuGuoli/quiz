/**
 * 外观数列
 */
public class CountAndSay {

    // 直接描述前一个字符
    public String countAndSay (int n)
    {
        if (n <= 0) return "";

        if (n == 1) return "1";
        String[] dp = new String[n+1];
        dp[1] = "1";
        dp[2] = "11";
        for (int i=3; i<=n; i++)
        {
            dp[i] = describe(dp[i-1]);
        }
        return dp[n];
    }

    private String describe (String pre)
    {
        StringBuilder ans = new StringBuilder();
        int len = pre.length();
        int num = pre.charAt(0) - '0';
        int count = 1;
        for (int i=1;i<len;i++)
        {
            if (pre.charAt(i) == pre.charAt(i-1))
            { count++; }
            else
            {
                ans.append(count);
                ans.append(num);
                num = pre.charAt(i) - '0';
                count = 1;
            }

            if (i == len - 1)
            {
                ans.append(count);
                ans.append(num);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args)
    {
        CountAndSay o = new CountAndSay();
        for (int i=1; i<=30; i++)
        {
            System.out.println(o.countAndSay(i));
        }
        // System.out.println(o.countAndSay(10));
    }
    
}
