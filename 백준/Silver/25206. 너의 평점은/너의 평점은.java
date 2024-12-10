import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Define grade mappings
        Map<String, Double> gradePoints = new HashMap<>();
        gradePoints.put("A+", 4.5); gradePoints.put("A0", 4.0);
        gradePoints.put("B+", 3.5); gradePoints.put("B0", 3.0);
        gradePoints.put("C+", 2.5); gradePoints.put("C0", 2.0);
        gradePoints.put("D+", 1.5); gradePoints.put("D0", 1.0);
        gradePoints.put("F", 0.0);

        double totalCredits = 0;
        double totalGradePoints = 0;

        for (int i = 0; i < 20; i++) {
            String[] input = br.readLine().split(" ");
            double credits = Double.parseDouble(input[1]);
            String grade = input[2];

            if (!grade.equals("P")) {
                totalCredits += credits;
                totalGradePoints += credits * gradePoints.get(grade);
            }
        }
        double result =  totalGradePoints / totalCredits;
        if(Double.isInfinite(result)) {
            result = 0.000000;
            System.out.println(result);
        }else {
            System.out.printf("%.6f\n", result);
        }
    }
}