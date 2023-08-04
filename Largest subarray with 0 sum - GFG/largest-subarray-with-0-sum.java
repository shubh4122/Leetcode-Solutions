//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n){
        HashMap<Integer, Integer> map = new HashMap<>();//{val, index}
        map.put(arr[0], 0);
        int maxSubarrayLen = 0;
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i-1]+arr[i];//prefix sum
            if (arr[i] != 0 && map.containsKey(arr[i])){
                maxSubarrayLen = Math.max(maxSubarrayLen, Math.abs(map.get(arr[i]) - i));
                //dont update map with new index, as we want the least index to be there for comparison
            }
            else
                map.put(arr[i], i);
        }
        maxSubarrayLen = Math.max(maxSubarrayLen, map.getOrDefault(0, -1)+1);
        return maxSubarrayLen;
    }
}