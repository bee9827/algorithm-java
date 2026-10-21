import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        //two Pointer
        
        int start = 0;
        int bestS = 0, bestE = gems.length-1;
        
        int count = new HashSet<>(Arrays.asList(gems)).size();
        
        Map<String,Integer> map = new HashMap<>();
    
        
        int[] answer = {};
        
        for(int end=0; end<gems.length; end++){
            map.put(gems[end], map.getOrDefault(gems[end],0) + 1);
            
            while(map.size() == count){
                if(end-start < bestE - bestS){
                    bestS = start;
                    bestE = end;
                }
                remove(map, gems[start]);
                start++;
            }
        }
        
        return new int[]{bestS+1, bestE+1};
    }
    
    void remove(Map<String, Integer> gemsCountMap, String gem){
        int count = gemsCountMap.get(gem) - 1;
        
        if(count == 0){
            gemsCountMap.remove(gem);
        }else{
            gemsCountMap.put(gem,count);
        }
    }
}