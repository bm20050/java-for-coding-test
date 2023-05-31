package implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 기둥과보설치 {
    static class Node implements Comparable<Node> {
        private int x;
        private int y;
        private int stuff;

        public Node(int x, int y, int stuff) {
            this.x = x;
            this.y = y;
            this.stuff = stuff;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getStuff() {
            return stuff;
        }

        // 정렬 기준 설정 (x, y, stuff 순서대로 오름차순)
        @Override
        public int compareTo(Node o) {
            if (this.x == o.x && this.y == o.y)
                return Integer.compare(this.stuff, o.stuff);
            if (this.x == o.x)
                return Integer.compare(this.y, o.y);
            return Integer.compare(this.x, o.x);
        }
    }

    // 현재 설치된 구조물이 '가능한' 구조물인지 확인하는 함수
    public static boolean possible(ArrayList<ArrayList<Integer>> answer) {
        for (int i = 0; i < answer.size(); i++) {
            int x = answer.get(i).get(0);
            int y = answer.get(i).get(1);
            int stuff = answer.get(i).get(2);
            if (stuff == 0) { // 설치된 것이 '기둥'인 경우
                boolean check = false;
                // '바닥 위'라면 정상
                if (y == 0)
                    check = true;
                // '보의 한 쪽 끝 부분 위' 혹은 '다른 기둥 위'라면 정상
                for (int j = 0; j < answer.size(); j++) {
                    if (x - 1 == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2))
                        check = true;
                    if (x == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2))
                        check = true;
                    if (x == answer.get(j).get(0) && y - 1 == answer.get(j).get(1) && 0 == answer.get(j).get(2))
                        check = true;
                }
                if (!check)
                    return false; // 아니라면 거짓(false) 반환
            }
            else if (stuff == 1) { // 설치된 것이 '보'인 경우
                boolean check = false;
                boolean left = false;
                boolean right = false;
                // '한쪽 끝부분이 기둥 위' 혹은 '양쪽 끝부분이 다른 보와 동시에 연결'이라면 정상
                for (int j = 0; j < answer.size(); j++) {
                    if (x == answer.get(j).get(0) && y - 1 == answer.get(j).get(1) && 0 == answer.get(j).get(2))
                        check = true;
                    if (x + 1 == answer.get(j).get(0) && y - 1 == answer.get(j).get(1) && 0 == answer.get(j).get(2))
                        check = true;
                    if (x - 1 == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2))
                        left = true;
                    if (x + 1 == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2))
                        right = true;
                }
                if (left && right)
                    check = true;
                if (!check)
                    return false; // 아니라면 거짓(false) 반환
            }
        }
        return true;
    }

    public static int[][] solution(int n, int[][] build_frame) {
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        // 작업(frame)의 개수는 최대 1,000개
        for (int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int stuff = build_frame[i][2];
            int operate = build_frame[i][3];
            if (operate == 0) { // 삭제하는 경우
                // 일단 삭제를 해 본 뒤에
                int index = 0;
                for (int j = 0; j < answer.size(); j++) {
                    if (x == answer.get(j).get(0) && y == answer.get(j).get(1) && stuff == answer.get(j).get(2)) {
                        index = j;
                    }
                }
                ArrayList<Integer> erased = answer.get(index);
                answer.remove(index);
                if (!possible(answer)) { // 가능한 구조물인지 확인
                    answer.add(erased); // 가능한 구조물이 아니라면 다시 설치
                }
            }
            if (operate == 1) { // 설치하는 경우
                // 일단 설치를 해 본 뒤에
                ArrayList<Integer> inserted = new ArrayList<>();
                inserted.add(x);
                inserted.add(y);
                inserted.add(stuff);
                answer.add(inserted);
                if (!possible(answer)) { // 가능한 구조물인지 확인
                    answer.remove(answer.size() - 1); // 가능한 구조밀이 아니라면 다시 제거
                }
            }
        }

        // 정렬 수행
        ArrayList<Node> ans = new ArrayList<Node>();
        for (int i = 0; i < answer.size(); i++) {
            ans.add(new Node(answer.get(i).get(0), answer.get(i).get(1), answer.get(i).get(2)));
        }
        Collections.sort(ans);

        // 배열로 바꾸어 반환
        int[][] res = new int[ans.size()][3];
        for (int i = 0; i < ans.size(); i++) {
            res[i][0] = ans.get(i).getX();
            res[i][1] = ans.get(i).getY();
            res[i][2] = ans.get(i).getStuff();
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] build_frame = {{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}};

        System.out.println(Arrays.deepToString(solution(n, build_frame)));
    }
}
