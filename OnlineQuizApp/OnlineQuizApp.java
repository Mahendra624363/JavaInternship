import java.io.*;
import java.util.Scanner;

class Quiz {
    String ques;
    String[] opts;
    int correct;

    void setQuestion(String ques, String[] opts, int correct) {
        this.ques = ques;
        this.opts = opts;
        this.correct = correct;
    }

    String getQuestion() {
        return ques;
    }

    String[] getOpts() {
        return opts;
    }

    int getCorrect() {
        return correct;
    }
}

class OnlineQuizApp {
    public static void main(String args[]) throws Exception {
        int noc = 0;
        int n = 6;

        Quiz[] L = new Quiz[6];
        for (int i = 0; i < n; i++) {
            L[i] = new Quiz();
        }
        Scanner sc = new Scanner(System.in);
        L[0].setQuestion("Which planet in our solar system is known as the Red Planet?",
                new String[]{"Venus", "Mars", "Jupiter", "Saturn"}, 2);

        L[1].setQuestion("What is the capital city of Japan?",
                new String[]{"Beijing", "Seoul", "Tokyo", "Bangkok"}, 3);

        L[2].setQuestion("Who wrote the play 'Romeo and Juliet'?",
                new String[]{"William Shakespeare", "Charles Dickens", "Jane Austen", "Mark Twain"}, 1);

        L[3].setQuestion("Which element has the chemical symbol 'O'?",
                new String[]{"Gold", "Oxygen", "Osmium", "Zinc"}, 2);

        L[4].setQuestion("What is the largest ocean on Earth?",
                new String[]{"Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "Pacific Ocean"}, 4);

        L[5].setQuestion("In which year did the Titanic sink?",
                new String[]{"1905", "1912", "1918", "1923"}, 2);

        for (int i = 0; i < n; i++) {
            System.out.println("\n\n"+L[i].getQuestion());
            for (int j = 0; j < 4; j++) {
                System.out.println("(" + (j + 1) + ")" + L[i].getOpts()[j]);
            }

            System.out.println("Enter Your Option [1,2,3,4]");
            int opt = sc.nextInt();
            while (opt < 1 || opt > 4) {
                System.out.println("Please Enter Correct Option");
                opt = sc.nextInt();
            }
            if (L[i].getCorrect() == opt) {
                noc = noc + 1;
            }
        }

        System.out.println("Total Score:" + noc);
    }
}
