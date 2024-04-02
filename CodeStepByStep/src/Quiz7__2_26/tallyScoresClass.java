package Quiz7__2_26;

import java.util.Scanner;

/*
 * Write a static method called tallyScores that takes as a parameter a Scanner containing a series of student 
 * records and that prints a summary of each student record. A student record will begin with a name followed
 * by a sequence of integer test scores. The name is guaranteed to be one word composed of letters. You may 
 * assume that each student has at least one test score. Your method should produce two lines of output for each 
 * student: one showing the student's name and test scores and a second line showing the average score. For 
 * example, if a Scanner called records contains the following:
 * 
 * John 71 83 94 Sally 94
 * 85 Fred 90 95 82 85
 * 
 * and the following call is made:
 * 
 * tallyScores(records);
 * 
 * the following output should be produced:
 * 
 * John: 71 83 94
 * average = 82.66666666666667
 * Sally: 94 85
 * average = 89.5
 * Fred: 90 95 82 85
 * average = 88.0
 * 
 * You are to exactly reproduce the format of this output. Notice that line breaks in the input are
 * not meaningful and that the average is not rounded. You may not construct any extra data
 * structures to solve this problem.
 */
// public class tallyScoresClass {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         tallyScores(scanner);
//     }

//     public static void tallyScores(Scanner scanner) {
//         String studentName = "";
//         int totalScore = 0;
//         int scoreCount = 0;

//         while (scanner.hasNext()) {
//             String token = scanner.next();
//             if (Character.isDigit(token.charAt(0))) {
//                 // token is a score
//                 int score = Integer.parseInt(token);
//                 totalScore += score;
//                 scoreCount++;
//             } else {
//                 // token is a name, check if were moving to a new student
//                 if (!)
//             }
//         }
//     }
// }
