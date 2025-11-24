import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.Scanner;

public class Nav {
    int chosenNumber;
    int playerAnswer;
    private Question currentQuestion;
    private ArrayList subject;
    Answer currentAnswer = new Answer("Text", false);

    public void start() {
        DAO dao = new DAO();
        System.out.println("Which subject? Enter Number");
        System.out.println("1.Media, 2.History, 3.Nature or 4.Geography?");
        Scanner scanner = new Scanner(System.in);
        dao.shuffleQuestions();
        while (true) {
            chosenNumber = scanner.nextInt();
            if (chosenNumber == 1) {
                subject = DAO.Media;
                break;
            }
            if (chosenNumber == 2) {
                subject = DAO.History;
                break;
            }
            if (chosenNumber == 3) {
                subject = DAO.Nature;
                break;
            }
            if (chosenNumber == 4) {
                subject = DAO.Geography;
                break;
            } else System.out.println("Choose a number 1-4 please.");
        }
        while (true) {
            currentQuestion = dao.getQuestion(subject);
            System.out.println(currentQuestion.getQuestionText());
            System.out.println("Enter answer number 1-4.");
            currentQuestion.getAnswers(currentQuestion);
            playerAnswer = currentQuestion.enterAnswer();
            currentAnswer = currentQuestion.getAnswer(playerAnswer);
            if (currentAnswer.isCorrect()) {
                System.out.println("Correct!!!!");
            } else System.out.println("WRONG!!!!");
        }

    }

    static void main() {
        Nav nav = new Nav();
        nav.start();
    }
}
