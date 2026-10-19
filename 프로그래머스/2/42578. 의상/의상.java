
import java.util.HashMap;
import java.util.Map;

/*
 * 의상 (프로그래머스 Lv.2)
 * https://school.programmers.co.kr/learn/courses/30/lessons/42578
 *
 * clothes[i] = [의상 이름, 의상 종류]. 매일 다른 조합으로 옷을 입는다.
 * 종류별로 최대 1개만 입을 수 있고, 하루에 최소 1개는 입는다.
 * 서로 다른 옷 조합의 수를 반환.
 * 제한: 의상 1~30개, 같은 이름의 의상은 없음
 */
class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> clothesMap = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            String category = clothes[i][clothes[i].length - 1];
            for (int j = 0; j < clothes[i].length - 1; j++) {
                Integer count = clothesMap.getOrDefault(category, 0);
                clothesMap.put(category, count + 1);
            }
        }

        int ans = 1;
        for(String key : clothesMap.keySet()) {
            Integer count = clothesMap.get(key);
            ans *= (count+1);
        }

        return ans-1;
    }
}
