/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 */
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class ValidAnagram {
    //排序
    public boolean isAnagram(String s, String t)
    {
        if (s.length() != t.length()) return false;

        char [] str1 = s.toCharArray();
        char [] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1,str2);
    }

    // 哈希表
    public boolean isAnagram2(String s, String t)
    {
        if (s.length() != t.length()) return false;

        int[] table = new int[26];
        for (int i=0; i<s.length(); i++)
        {
            table[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++)
        {
            table[t.charAt(i)-'a']--;
            if (table[t.charAt(i)-'a'] < 0) return false;
        }
        return true;
    }

    // 关于 Unicode
    public boolean isAnagram3(String s, String t)
    {
        if (s.length() != t.length()) return false;

        Map<Character,Integer> table = new HashMap<Character,Integer>();
        for (int i=0; i< s.length();i++) 
        {
            char ch = s.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0)+1);
        }
        for (int i=0; i< t.length();i++) 
        {
            char ch = t.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0)-1);
            if (table.get(ch) < 0) return false;
        }

        return true;
    }

}
