//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{

int mod = pow(10,9) + 7;
	public:
	  int dfs(int n,int arr[],int sum,vector<vector<int>> &dp){
    if( n == 0 && sum != 0){
        return 0;
    }
    if(sum == 0 && n == 0){
        return 1;
    }
    
    if(dp[n][sum] != -1){
        return dp[n][sum]%mod;
    }
    
    
    if(arr[n-1] <= sum){
        return dp[n][sum] = (dfs(n-1,arr,sum-arr[n-1],dp) + dfs(n-1,arr,sum,dp))%mod;
    }else{
        return dp[n][sum] = (dfs(n-1,arr,sum,dp))%mod;
    }
}
	int perfectSum(int arr[], int n, int sum)
	{
        // Your code goes here
        vector<vector<int>> dp(n+1,vector<int>(sum+1,-1));
    return dfs(n,arr,sum,dp);
	}
};

//{ Driver Code Starts.
int main() 
{
   	
   
   	int t;
    cin >> t;
    while (t--)
    {
        int n, sum;

        cin >> n >> sum;

        int a[n];
        for(int i = 0; i < n; i++)
        	cin >> a[i];

       

	    Solution ob;
	    cout << ob.perfectSum(a, n, sum) << "\n";
	     
    }
    return 0;
}

// } Driver Code Ends