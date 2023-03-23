package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class 큰수의법칙 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // n, m, k를 공백을 기준으로 구분하여 입력받기
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        // n개의 수를 공백을 기준으로 구분하여 입력 받기
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr); // 입력 받은 수들 정렬하기

        int first = arr[n - 1]; // 가장 큰 수
        int second = arr[n - 2]; // 두 번째로 큰 수

        int cnt = (m / (k + 1)) * k;
        cnt += m % (k + 1);

        int result = 0;
        result += cnt * first; // 가장 큰 수 더하기
        result += (m - cnt) * second; // 두 번째로 큰 수 더하기

        System.out.println(result);
    }
}
