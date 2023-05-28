package implementation;

public class 문자열압축 {
    public static int solution(String s) {
        int answer = s.length();
        // 1개 단위(step)부터 압축 단위를 늘려가며 확인
        for (int step = 1; step < s.length() / 2 + 1; step++) {
            StringBuilder compressed = new StringBuilder();
            String prev = s.substring(0, step); // 앞에서부터 step만큼의 문자열 추출
            int cnt = 1;
            // 단위(step) 크기만큼 증가시키며 이전 문자열과 비교
            for (int j = step; j < s.length(); j += step) {
                // 이전 상태와 동일하다면 압축 횟수(count) 증가
                StringBuilder sub = new StringBuilder();
                for (int k = j; k < j + step; k++) {
                    if (k < s.length())
                        sub.append(s.charAt(k));
                }
                if (prev.contentEquals(sub))
                    cnt += 1;
                // 다른 문자열이 나왔다면(더 이상 압축하지 못하는 경우라면)
                else {
                    compressed.append((cnt >= 2) ? cnt + prev : prev);
                    sub = new StringBuilder();
                    for (int k = j; k < j + step; k++) {
                        if (k < s.length())
                            sub.append(s.charAt(k));
                    }
                    prev = String.valueOf(sub);
                    cnt = 1;
                }
            }
            // 남아있는 문자열에 대해서 처리
            compressed.append((cnt >= 2) ? cnt + prev : prev);
            // 만들어지는 압축 문자열이 가장 짧은 것이 정답
            answer = Math.min(answer, compressed.length());
        }
        return answer;
    }

    public static void main(String[] args) {
        String s = "aabbaccc";

        System.out.println(solution(s));
    }
}
