class Solution {
    public int findTheWinner(int n, int k) {
        ArrayList<Integer> arr = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            arr.add(i+1);
        }

        
//-------------------ITERATIVE -------------------
        
//        this is current position
//         int curr = 0;
//         while (arr.size() > 1) {
//             int killAt = (curr + k - 1) % arr.size();

//             arr.remove(killAt);
//             curr = killAt;
//         }

//         return arr.get(0);
        
        
        
//-------------------RECURSIVE-------------------
        return helper(arr, k, 0);
        
    }
    
    public int helper(ArrayList<Integer> arr, int k, int curr) {
        //        H : jPR(arr, k, curr) --> returns safe posn in the circle
//        I : jPR(arr, k, curr) --> arr.remove(killat)
//                                  jPR(arr, k, killat)
//        BC : if arr.size == 1, return arr[0]

        if (arr.size() == 1)
            return arr.get(0);

        int killAt = (curr + k - 1) % arr.size();
        arr.remove(killAt);
        return helper(arr, k, killAt);
    }
}