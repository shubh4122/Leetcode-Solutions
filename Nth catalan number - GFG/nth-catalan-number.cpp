//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution
{
    public:
    //Function to find the nth catalan number.
    int findCatalan(int N) 
    {
        int mod = (int)1e9+7;
        //code here
        long long int dp[N+1];
        dp[0] = 1; dp[1] = 1; //BC
        
        for(int n = 2; n <= N; n++){//this loop replaces recursion.
        //but recursion also has 1 for loop inside so:
            // dp[n] = 0;
            long long int ans = 0;
            for(int i = n; i>=1; i--) {
                long long int r = dp[n-i];
                long long int l = dp[i-1];
                ans = (ans%mod + (l*r)%mod)%mod;
            }
            dp[n] = ans%mod;
        }
        return (int)dp[N];
    }
};

//{ Driver Code Starts.
int main() 
{
	int t;
	cin>>t;
	while(t--) {
	    
	    int n;
	    cin>>n;
	    Solution obj;
	    cout<< obj.findCatalan(n) <<"\n";    
	}
	return 0;
}
// } Driver Code Ends