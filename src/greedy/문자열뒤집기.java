package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열뒤집기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int count0 = 0;
        int count1 = 0;

        // 첫 번째 원소에 대해서 처리
        if (s.charAt(0) == '1')
            count0 += 1;
        else
            count1 += 1;

        // 두 번째 원소부터 모든 원소를 확인하며
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                // 다음 수에서 1로 바뀌는 경우
                if (s.charAt(i + 1) == '1')
                    count0 += 1;
                // 다음 수에서 0으로 바뀌는 경우
                else
                    count1 += 1;
            }
        }

        System.out.println(Math.min(count0, count1));
    }
}
