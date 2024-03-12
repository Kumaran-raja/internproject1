package com.project.project1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    private String questionText;
    private ArrayList<String> options;
    private String correctAnswer;

    public Question(String questionText, ArrayList<String> options, String correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}

class Quiz {
    private ArrayList<Question> questions;

    public Quiz(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public Question getQuestion(int index) {
        return questions.get(index);
    }

    public int getSize() {
        return questions.size();
    }
}

public class OnlineQuizApplication {

    public static void main(String[] args) {
        // Create quiz questions
        ArrayList<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?", new ArrayList<>(List.of("A. London", "B. Paris", "C. Berlin")), "B"));
        questions.add(new Question("Which planet is known as the Red Planet?", new ArrayList<>(List.of("A. Venus", "B. Mars", "C. Jupiter")), "B"));

        // Create quiz
        Quiz quiz = new Quiz(questions);

        // Initialize variables
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        // Display and process quiz questions
        for (int i = 0; i < quiz.getSize(); i++) {
            Question currentQuestion = quiz.getQuestion(i);
            System.out.println("Question " + (i + 1) + ": " + currentQuestion.getQuestionText());
            for (String option : currentQuestion.getOptions()) {
                System.out.println(option);
            }

            // Get user input with validation
            String userAnswer;
            do {
                System.out.print("Your answer (Enter the corresponding letter): ");
                userAnswer = scanner.nextLine().toUpperCase();
            } while (!userAnswer.matches("[A-C]"));

            // Check user's answer
            if (userAnswer.equals(currentQuestion.getCorrectAnswer())) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + currentQuestion.getCorrectAnswer());
            }

            System.out.println(); // Add a line break for better readability
        }

        // Display final score
        System.out.println("Quiz completed! Your final score: " + score + " out of " + quiz.getSize());

        // Close the scanner
        scanner.close();
    }
}