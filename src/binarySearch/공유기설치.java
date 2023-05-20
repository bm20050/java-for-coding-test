package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 공유기설치 {
    public static void main(String[] args) throws IOException {
        // 집의 개수(n)와 공유기의 개수(c)를 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // 전체 집의 좌표 정보를 입력받기
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        // 이진 탐색을 위해 정렬 수행
        Collections.sort(list);

        int start = 1; // 가능한 최소 거리(min gap)
        int end = list.get(n - 1) - list.get(0); // 가능한 최대거리 (max gap)
        int result = 0;

        while (start <= end) {
            // mid는 가장 인접한 두 공유기 사이의 거리(gap)을 의미
            int mid = (start + end) / 2;
            // 첫째 집에는 무조건 공유기를 설치한다고 가정
            int value = list.get(0);
            int cnt = 1;
            // 현재의 mid 값을 이용해 공유기를 설치하기
            for (int i = 1; i < list.size(); i++) { // 앞에서부터 차근차근 설치
                if (list.get(i) >= value + mid) {
                    value = list.get(i);
                    cnt += 1;
                }
            }
            // c개 이상의 공유기를 설치할 수 있는 경우, 거리를 증가시키기
            if (cnt >= c) {
                start = mid + 1;
                result = mid; // 최적의 결과를 저장
            } else
                end = mid - 1;
        }
        System.out.println(result);
    }
}
