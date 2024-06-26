//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;


class Array {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		  
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling trappingWater() function
		    System.out.println(obj.trappingWater(arr, n));
		}
	}
}


// } Driver Code Ends






class Solution{
    
    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int height[], int n) { 
        // Your code here
       if(n<=2){
            return 0;
        }

        //contains left side maximum of current element 
        int left[] = new int[n];
        left[0]=height[0];

        for(int i=1;i<n;i++){
            int t = left[i-1];
            if(t<height[i]){
                left[i]=height[i];
            }
            else{
                left[i]=t;
            }
        }

        ////contains right  side maximum of current element 
        int right[] = new int[n];
        right[n-1]=height[n-1];

        for(int i=n-2;i>=0;i--){
            int t = right[i+1];
            if(t<height[i]){
                 right[i]=height[i];
            }
            else{
                right[i]=t;
            }
        }
          
        long  ans =0;
        for(int i=0;i<n;i++){
            int l = left[i];
            int r = right[i];
            int min = Math.min(l,r);
            int total = min-height[i];
            if(total>=0){
                ans = ans +total;
            }
        }

        return ans ;
    } 
}


