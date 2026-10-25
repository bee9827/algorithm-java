class Solution {
    
    int dy[] = {1,-1,0,0};
    int dx[] = {0,0,1,-1};
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        
        int H = park.length;
        int W = park[0].length();
        
        for(int i=0; i<park.length; i++){
            for(int j=0; j<park[i].length(); j++){
                if(park[i].charAt(j) == 'S'){
                    answer = new int[]{i,j};
                }
            }
        }
        
        for(String route : routes){
            int[] dir = new int[2];
            int count = (route.charAt(2) - '0');
            char op = route.charAt(0);
            switch(op){
                case 'E': dir = new int[]{0,1}; break;
                case 'W': dir = new int[]{0,-1}; break;
                case 'S': dir = new int[]{1,0}; break;
                case 'N': dir = new int[]{-1,0}; break;
            }
            
            int ry = answer[0];
            int rx = answer[1]; 
            
            for(int i=0; i < count; i++){
                int ny = dir[0] + ry;
                int nx = dir[1] + rx;
                
                if(ny<0 || ny>= H || nx<0 || nx>= W || park[ny].charAt(nx) == 'X'){
                    break;
                }
                ry = ny;
                rx = nx;
                
                if(i== count-1){
                    answer[0] = ry;
                    answer[1] = rx;
                }
            }    
        }
        
        return answer;
    }
}