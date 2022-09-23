class Solution {
    public List<String> letterCasePermutation(String s) {
        return helper(s, "");
    }
    
    
    public ArrayList<String> helper(String ip, String op) {
        
//        Input here can have lowercase, uppercase letters and digits
        ArrayList<String> a = new ArrayList<>();
        if (ip.isEmpty()) {
            a.add(op);
            return a;
        }

        char c = ip.charAt(0);
        if (!Character.isDigit(c)) {
            a.addAll(helper(ip.substring(1), op+ changeCase(c)));
            a.addAll(helper(ip.substring(1), op + c));
        }
        else {
            a.addAll(helper(ip.substring(1), op+c));
        }
        return a;
    }
    
    public Character changeCase(char character) {
        if (Character.isLowerCase(character))   return Character.toUpperCase(character);
        else    return Character.toLowerCase(character);
    }
}