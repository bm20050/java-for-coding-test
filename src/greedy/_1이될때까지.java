package greedy;

import java.util.Scanner;

public class _1이될때까지 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // n, k를 공백을 기준으로 구분하여 입력 받기
        int n = sc.nextInt();
        int k = sc.nextInt();
        int result = 0;

        while (true) {
            // n이 k로 나누어 떨어지는 수가 될 때가지만 1씩 빼기
            int target = (n / k) * k;
            result += (n - target);
            n = target;
            // n이 k보다 작을 때 (더 이상 나눌 수 없을 때) 반복문 탈출
            if (n < k) break;
            // k로 나누기
            result += 1;
            n /= k;
        }

        // 마지막으로 남은 수에 대하여 1씩 빼기
        result += (n - 1);
        System.out.println(result);
    }
}
