import java.util.Random;

/**
 * 打乱数组
 */
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class ShuffleArray {
    private int[] array;
    private int[] original;

    private Random rand = new Random();

    private List<Integer> getArrayCopy()
    {
        List<Integer> asList = new ArrayList<Integer>();
        for (int i=0;i<array.length;i++)
        {
            asList.add(array[i]);
        }
        return asList;
    }

    public ShuffleArray(int[] nums)
    {
        array = nums;
        original = nums.clone();
    }

    public int[] reset()
    {
        array = original;
        original = original.clone();
        return array;
    }

    // 暴力算法 O(n^2)时间
    public int[] shuffle()
    {
        List<Integer> aux = getArrayCopy();
        for (int i=0;i<array.length;i++)
        {
            int removeIdx = rand.nextInt(aux.size());
            array[i] = aux.get(removeIdx);
            aux.remove(removeIdx);
        }
        return array;
    }

    // Fisher-Yates 洗牌算法 O(n)时间
    private int randRange(int min, int max)
    {
        return rand.nextInt(max - min) + min;
    }

    private void swapAt(int i, int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int[] shuffle2()
    {
        for (int i=0;i<array.length;i++)
        {
            swapAt(i, randRange(i, array.length));
        }
        return array;
    }
    
}
