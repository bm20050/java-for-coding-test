package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 국영수 {
    static class Student implements Comparable<Student> {
        private String name;
        private int kor;
        private int eng;
        private int m;

        public Student(String name, int kor, int eng, int m) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.m = m;
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(Student o) {
            if (this.kor == o.kor && this.eng == o.eng && this.m == o.m)
                return this.name.compareTo(o.name);
            if (this.kor == o.kor && this.eng == o.eng)
                return Integer.compare(o.m, this.m);
            if (this.kor == o.kor)
                return Integer.compare(this.eng, o.eng);
            return Integer.compare(o.kor, this.kor);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int kor = sc.nextInt();
            int eng = sc.nextInt();
            int m = sc.nextInt();
            students.add(new Student(name, kor, eng, m));
        }

        Collections.sort(students);

        // 정렬된 학생 정보에서 이름만 출력
        for (int i = 0; i < n; i++) {
            System.out.println(students.get(i).getName());
        }
    }
}
