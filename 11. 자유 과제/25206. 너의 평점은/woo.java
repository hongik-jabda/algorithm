import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str[] = new String[20];
        double totalSum = 0;    // 학점 * 성적 점수의 총합
        double scoreSum = 0;    // 총 이수학점
        String gradeList[] = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F", "P"};
        double gradeScore[] = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0, 0.0};

        for (int i = 0; i < 20; i++) {
            str[i] = br.readLine();    // 한 줄씩 쫘르륵 읽음
            StringTokenizer st = new StringTokenizer(str[i], " ");    // 공백 단위로 구분해서 저장
            // str[i]는 English 4.0 A0 이런 식으로 되어있음
            String subject = st.nextToken();    // 과목명(안씀)
            double score = Double.parseDouble(st.nextToken());    // (이수)학점
            String grade = st.nextToken();    // 성적

            for (int j = 0; j < 10; j++) {
                if (grade.equals(gradeList[j])) {    // ex A0면 totalSum에 4.0 * 3.0 해서 더함
                    totalSum += score * gradeScore[j];
                    if (j != 9) {    // 성적 "P"일 때는 제외시키기!!!(핵심)
                        scoreSum += score;
                    }
                }
            }
        }

        double average = totalSum / scoreSum;    // 평균평점 구하기
        System.out.printf("%.6f\n", average);    // 소수점 6자리까지

        br.close();
    }
}
