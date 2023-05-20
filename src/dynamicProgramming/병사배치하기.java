package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 병사배치하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        // 순서를 뒤집어 '최장 증가 부분 수열' 문제로 변환
        Collections.reverse(list);

        int[] dp = new int[n];
        // 다이나믹 프로그래밍을 위한 1차원 DP 테이블 초기화
        Arrays.fill(dp, 1);

        // 가장 긴 증가하는 부분 수열(LIS) 알고리즘 수행
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (list.get(j) < list.get(i))
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        // 열외해야 하는 병사의 최수 수를 출력
        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            maxValue = Math.max(maxValue, dp[i]);
        }

        System.out.println(n - maxValue);
    }
}
