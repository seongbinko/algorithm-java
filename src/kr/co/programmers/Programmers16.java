package kr.co.programmers;
/*
주식가격
        문제 설명
        초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.

        제한사항
        prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
        prices의 길이는 2 이상 100,000 이하입니다.
        입출력 예
        prices	return
        [1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]
        입출력 예 설명
        1초 시점의 ₩1은 끝까지 가격이 떨어지지 않았습니다.
        2초 시점의 ₩2은 끝까지 가격이 떨어지지 않았습니다.
        3초 시점의 ₩3은 1초뒤에 가격이 떨어집니다. 따라서 1초간 가격이 떨어지지 않은 것으로 봅니다.
        4초 시점의 ₩2은 1초간 가격이 떨어지지 않았습니다.
        5초 시점의 ₩3은 0초간 가격이 떨어지지 않았습니다.
        ※ 공지 - 2019년 2월 28일 지문이 리뉴얼되었습니다.

        int로 Array를 할당하면 초기값 0 이 셋팅이된다 Integer는 null
*/
import java.util.*;
public class Programmers16 {
    public static void main(String[] args) {
       int[] prices = {1,2,3,2,3};
       System.out.println(Arrays.toString(solution4(prices)));
    }
    public static int[] solution(int[] prices) {

        int[] answer = new int[prices.length];

        int count = 0;
        while(count < prices.length) {
            if(count != prices.length-1 ) {

                Stack<Integer> st = new Stack<>();
                st.push(prices[count]);

                for(int i = count +1; i<prices.length; i++) {
                    if(prices[count] <= prices[i]) {
                        st.push(prices[i]);
                    } else {
                        st.push(0);
                        break;
                    }
                }
                answer[count] = st.size() - 1;
            } else {
                answer[count] = 0;
            }
            count++;
        }
        return answer;
    }
    public static int[] solution2 (int[] prices) {
        int[] answer = new int[prices.length];

        for(int i=0; i<prices.length; i++)
        {
            for(int j=i+1; j<prices.length; j++)
            {
                if(prices[i] > prices[j])
                {
                    answer[i] = j - i;
                    break;
                }
                else {
                    answer[i] = j - i;
                }
            }
        }
        return answer;
    }

    public static int[] solution3 (int[] prices) {
        Stack<Integer> beginIdxs = new Stack<>();
        int i=0;
        int[] terms = new int[prices.length];

        beginIdxs.push(i);
        for (i=1; i<prices.length; i++) {
            while (!beginIdxs.empty() && prices[i] < prices[beginIdxs.peek()]) {
                int beginIdx = beginIdxs.pop();
                terms[beginIdx] = i - beginIdx;
            }
            beginIdxs.push(i);
        }
        while (!beginIdxs.empty()) {
            int beginIdx = beginIdxs.pop();
            terms[beginIdx] = i - beginIdx - 1;
        }

        return terms;
    }

    public static int[] solution4 (int[] prices) {

        int[] answer = new int[prices.length];
        Stack<int[]> stack = new Stack<>();

        // 뒤에서부터 순회
        for (int i = prices.length - 2; i >= 0; i--) {

            // 앞쪽의 숫자가 뒷쪽의 숫자보다 클 경우
            if (prices[i] > prices[i + 1]) {

                answer[i] = 1;
                stack.push(new int[] { prices[i + 1], i + 1 });

                // 앞쪽의 숫자가 뒷쪽의 숫자보다 작거나 같은 경우
            } else {

                // 스택에서 자신보다 낮은 값이 나올때까지 모두 지워줌
                while (stack.size() > 0 && stack.peek()[0] >= prices[i]) {
                    stack.pop();
                }

                // 스택이 빌 경우 (뒷쪽의 모든 값이 자신보다 큼)
                if (stack.size() == 0) {
                    answer[i] = prices.length - i - 1;

                    // 스택에 자신보다 낮은 숫자가 남아있다면 해당 인덱스와 자신의 인덱스를 이용해 계산
                } else {
                    answer[i] = stack.peek()[1] - i;
                }
            }
        }

        return answer;
    }
}
