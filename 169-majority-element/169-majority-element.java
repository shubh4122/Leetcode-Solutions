class Solution {
    public int majorityElement(int[] a) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int size = a.length;
        for(int i = 0; i < size; i++) {
            m.put(a[i], m.getOrDefault(a[i], 0)+1);
            if(m.get(a[i]) > size/2) return a[i];
        }
        return -1;
    }
}