class Solution {
    public int findTheWinner(int n, int k) {
        ArrayList<Integer> arr = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            arr.add(i+1);
        }

//        this is current position
        int curr = 0;
        while (arr.size() > 1) {
            int killAt = (curr + k - 1) % arr.size();

            arr.remove(killAt);
            curr = killAt;
        }

        return arr.get(0);
    }
}