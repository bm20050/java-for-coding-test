package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 곱하기혹은더하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        // 첫 번째 문자를 숫자로 변경한 값을 대입
        int result = s.charAt(0) - '0';

        for (int i = 1; i < s.length(); i++) {
            // 두 수 중에서 하나라도 '0', 혹은 '1'인 경우, 곱하기보다는 더하기 수행
            int x = s.charAt(i) - '0';
            if (x <= 1 || result <= 1)
                result += x;
            else
                result *= x;
        }

        System.out.println(result);
    }
}
