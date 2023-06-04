package dfs_bfs;

public class 괄호변환 {
    // "균형잡힌 괄호 문자열"의 인덱스 반환
    public static int balancedIndex(String p) {
        int count = 0; // 왼쪽 괄호의 개수
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(')
                count += 1;
            else
                count -= 1;
            if (count == 0)
                return i;
        }
        return -1;
    }

    // "올바른 괄호 문자열"인지 판단
    public static boolean checkProper(String p) {
        int count = 0; // 왼쪽 괄호의 개수
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(')
                count += 1;
            else {
                if (count == 0) { // 쌍이 맞지 않는 경우에 false 반환
                    return false;
                }
                count -= 1;
            }
        }
        return true; // 쌍이 맞는 경우에 true 반환
   }

    public static String solution(String p) {
        String answer = "";
        if (p.equals(""))
            return answer;
        int index = balancedIndex(p);
        String u = p.substring(0, index + 1);
        String v = p.substring(index + 1);
        // "올바른 괄호 문자열"이면, v에 대해 함수를 수행한 결과를 붙여 반환
        if (checkProper(u)) {
            answer = u + solution(v);
        } else {
            answer = "(";
            answer += solution(v);
            answer += ")";
            u = u.substring(1, u.length() - 1); // 첫 번째와 마지막 문자를 제거
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < u.length(); i++) {
                if (u.charAt(i) == '(')
                    temp.append(")");
                else
                    temp.append("(");
            }
            answer += temp;
        }
        return answer;
    }

    public static void main(String[] args) {
        String p = "()))((()";

        System.out.println(solution(p));
    }
}
