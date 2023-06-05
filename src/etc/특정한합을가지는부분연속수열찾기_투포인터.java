package etc;

public class 특정한합을가지는부분연속수열찾기_투포인터 {
    public static int n = 5; // 데이터의 개수 n
    public static int m = 5; // 찾고자 하는 부분합 m
    public static int[] arr = {1, 2, 3, 2, 5}; // 전체 수열

    public static void main(String[] args) {
        int cnt = 0;
        int intervalSum = 0;
        int end = 0;

        // start를 차례대로 증가시키며 반복
        for (int start = 0; start < n; start++) {
            // end를 가능한 만큼 이동시키기
            while (intervalSum < m && end < n) {
                intervalSum += arr[end];
                end += 1;
            }
            // 부분합이 m일 때 카운트 증가
            if (intervalSum == m) {
                cnt += 1;
            }
            intervalSum -= arr[start];
        }
        System.out.println(cnt);
    }
}
