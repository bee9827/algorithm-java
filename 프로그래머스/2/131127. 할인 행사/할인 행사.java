
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 할인 행사 (프로그래머스 Lv.2)
 * https://school.programmers.co.kr/learn/courses/30/lessons/131127
 *
 * 마트는 매일 한 가지 제품을 할인하고, 회원 자격은 10일 동안 유지된다.
 * 원하는 제품 want와 수량 number가 할인 기간 10일 동안 모두 맞아떨어지는 날에만 회원가입한다.
 * discount[i]는 i+1일째 할인 제품. 회원가입할 수 있는 날짜의 총 일수를 반환 (없으면 0).
 * 제한: want와 number 길이 1~10, number 합 = 10, discount 길이 10~100,000
 */
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {

        Map<String, Integer> discountMap = new HashMap<>();
        int amount = Arrays.stream(number).sum();

        for (int i = 0; i < amount; i++) {
            String key = discount[i];
            Integer value = discountMap.getOrDefault(key, 0) + 1;
            discountMap.put(key, value);
        }
        
        int ans = 0;

        if (getAmountOfDiscounted(discountMap, want, number) == amount) {
            ans++;
        }

        for (int i = amount; i < discount.length; i++) {
            int removePoint = i - amount;
            Integer removedCount = discountMap.getOrDefault(discount[removePoint], 0) - 1;
            discountMap.put(discount[removePoint], removedCount);

            Integer plusCount = discountMap.getOrDefault(discount[i], 0) + 1;
            discountMap.put(discount[i], plusCount);

            if (getAmountOfDiscounted(discountMap, want, number) == amount) {
                ans++;
            }
        }

        return ans;
    }

    public int getAmountOfDiscounted(Map<String, Integer> discountMap, String[] want, int[] number) {
        int total = 0;

        for (int i = 0; i < want.length; i++) {
            String key = want[i];
            int amount = number[i];

            Integer discountAmount = discountMap.getOrDefault(key, 0);
            if (amount < discountAmount) {
                total += amount;
                continue;
            }
            total += discountAmount;
        }
        return total;
    }
}
