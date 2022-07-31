class Solution {
    public int majorityElement(int[] a) {
        
        //Moore Voting Algo
        int candidate = -1, count = 0;
        for(int i = 0; i < a.length; i++) {
            if(count == 0) {
                candidate = i;
            }
            
            count += (a[candidate] == a[i]) ? 1:-1;
        }
        
        //If it were not assured that Maj exists
        //Code to check:
        
        // count= 0;
        // for (int i = 0; i < a.length; i++) {
        //     if(a[candidate] == a[i])    count ++;
        // }
        // if(count <= a.length/2)
        //     candidate = -1;
        
        return a[candidate];
        
        //Hashing Method
        
        // HashMap<Integer, Integer> m = new HashMap<>();
        // int size = a.length;
        // for(int i = 0; i < size; i++) {
        //     m.put(a[i], m.getOrDefault(a[i], 0)+1);
        //     if(m.get(a[i]) > size/2) return a[i];
        // }
        // return -1;
    }
}