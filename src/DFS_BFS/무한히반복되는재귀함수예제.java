package DFS_BFS;

public class 무한히반복되는재귀함수예제 {
    private static void recursiveFunction() {
        System.out.println("재귀함수를 호출합니다.");
        recursiveFunction();
    }

    public static void main(String[] args) {
        recursiveFunction();
    }
}
