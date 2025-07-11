package com.quiz.MiniQuiz;

import java.util.*;

public class TestQuizJDBC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuizJDBC qjc = new QuizJDBC();
        int score = 0;

        System.out.println("🔸 Mini Quiz App Started!");
        System.out.print("Enter your name: ");
        String username = sc.nextLine();

        // 📌 Controlled Topic Selection
        String topic = "";
        while (true) {
            System.out.println("\nChoose a topic:");
            System.out.println("1. Java Basics");
            System.out.println("2. OOPs");
            System.out.println("3. Collections");
            System.out.print("Enter choice (1-3): ");
            String choice = sc.nextLine().trim();

            if (choice.equals("1")) {
                topic = "Java Basics";
                break;
            } else if (choice.equals("2")) {
                topic = "OOPs";
                break;
            } else if (choice.equals("3")) {
                topic = "Collections";
                break;
            } else {
                System.out.println("⚠️ Please enter 1, 2, or 3 only.");
            }
        }

        // ✅ Number of Questions
        int questionCount = 0;
        while (true) {
            System.out.print("\nHow many questions do you want? (5, 10, 15): ");
            try {
                questionCount = Integer.parseInt(sc.nextLine().trim());
                if (questionCount == 5 || questionCount == 10 || questionCount == 15) {
                    break;
                } else {
                    System.out.println("⚠️ Please choose 5, 10, or 15 only.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Enter numbers only.");
            }
        }

        List<QuizPOJO> allQuestions = qjc.getQuestionsByTopic(topic);

        if (allQuestions.size() == 0) {
            System.out.println("❌ No questions found for topic: " + topic);
            return;
        }

        Collections.shuffle(allQuestions); // randomize
        int limit = Math.min(questionCount, allQuestions.size());

        for (int i = 0; i < limit; i++) {
            QuizPOJO q = allQuestions.get(i);
            System.out.println();
            System.out.println("Q" + (i + 1) + ": " + q.getQuestionText());
            System.out.println("A. " + q.getOptionA());
            System.out.println("B. " + q.getOptionB());
            System.out.println("C. " + q.getOptionC());
            System.out.println("D. " + q.getOptionD());

            // ✅ Cursor will appear in correct line now
            String answer = "";
            while (true) {
                System.out.print("Your answer (A/B/C/D): ");
                answer = sc.nextLine().trim().toUpperCase();
                if (answer.matches("[A-D]")) {
                    break;
                } else {
                    System.out.println("⚠️ Invalid input! Please enter A, B, C, or D.");
                }
            }

            if (answer.charAt(0) == q.getCorrectOption()) {
                score++;
            }
            System.out.println("---------------------------------");
        }

        // Save score
        qjc.saveUserScore(username, score);

        // Compliment
        String feedback = "";
        if (score == limit) {
            feedback = "🌟 Excellent!";
        } else if (score >= limit * 0.7) {
            feedback = "👍 Good job!";
        } else if (score >= limit * 0.4) {
            feedback = "🙂 Not bad. Keep practicing!";
        } else {
            feedback = "😅 Keep learning. Don’t give up!";
        }

        System.out.println("\n✅ Quiz Completed!");
        System.out.println("👤 Name: " + username);
        System.out.println("📘 Topic: " + topic);
        System.out.println("📊 Score: " + score + "/" + limit);
        System.out.println(feedback);
        System.out.println("🎉 Result saved successfully!");

        sc.close();
    }
}



