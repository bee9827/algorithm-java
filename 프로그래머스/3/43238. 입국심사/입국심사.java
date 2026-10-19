import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        
        long low = 0;
        long high = (long)Math.pow(10,18);
        
        while(low + 1 < high){
            long mid = (high+low)/2;
            if(cal(mid, times) < n) low = mid;
            else high = mid;
        }
    
        return high;
    }
    
    long cal(long totalTime, int[] times){
        long count = 0; 
        for(int time: times){
            count += (totalTime/(long)time);
        }
        return count;
    }
}