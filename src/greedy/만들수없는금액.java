package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 만들수없는금액 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        Collections.sort(list);

        int target = 1;
        for (int i = 0; i < n; i++) {
            // 만들 수 없는 금액을 찾았을 때 반복 종료
            if (target < list.get(i))
                break;
            target += list.get(i);
        }

        System.out.println(target);
    }
}
