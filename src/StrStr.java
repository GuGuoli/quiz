/**
 * 实现 strStr() 函数。
 */
public class StrStr {
    // 子串逐一比较
    public int strStr(String haystack, String needle)
    {
        int L = needle.length(), n = haystack.length();
        for (int start = 0; start < n-L+1; start++)
        {
            if (haystack.substring(start, start + L).equals(needle))
            { return start; }

        }
        return -1;
    }

    // 双指针
    public int strStr2 (String haystack, String needle)
    {
        int L = needle.length(), n = haystack.length();
        if (L == 0) return 0;

        int pn = 0;
        while (pn < n-L+1)
        {
            // 在 haystack 字符串中找 needle 的第一个字符
            while (pn < n-L+1 && haystack.charAt(pn) != needle.charAt(0)) pn++;

            // 计算最大匹配字符串
            int currLen = 0, pL = 0;
            while (pL < L && pn < n && haystack.charAt(pn) == needle.charAt(pL)) 
            {
                pn++;
                pL++;
                currLen++;
            }

            // 若完整子串被找到，返回匹配的开始位置
            if (currLen == L) return pn - L;

            // 否则，回溯
            pn = pn - L + 1;
        }

        return -1;
    }

    // Rabin Karp 方法，常数复杂度
    // 滚动哈希，常数时间生成哈希码
    public int strStr3(String haystack, String needle)
    {
        int L = needle.length(), n = haystack.length();
        if (L > n) return -1;

        // base value for the rolling hash function
        int a = 26;

        // modulus value for the rolling function to avoid overflow
        long modulus = (long) Math.pow(2,31);

        // compute the hash of strings haystack[:L], needle[:L]
        long h = 0, ref_h = 0;
        for (int i=0;i<L;i++)
        {
            h = (h * a + charToInt(i, haystack)) % modulus;
            ref_h = (ref_h*a + charToInt(i, needle)) % modulus;
        }
        if (h == ref_h) return 0;

        // const value to be used often : a**L % modulus
        long aL = 1;
        for (int i=1;i<=L;i++) aL = (aL*a) % modulus;

        for (int start=1;start < n-L+1; start++) 
        {
            // compute rolling hash in O(1) time
            h = (h * a - charToInt(start - 1, haystack) * aL + charToInt(start + L -1, haystack)) % modulus;

            if (h == ref_h) return start;
        }


        return -1;
    }

    public int charToInt(int idx, String s)
    {
        return (int)s.charAt(idx) - (int)'a';
    }

}
