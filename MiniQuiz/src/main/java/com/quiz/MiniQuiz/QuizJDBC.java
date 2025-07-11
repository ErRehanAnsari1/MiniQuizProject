package com.quiz.MiniQuiz;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuizJDBC {

    public List<QuizPOJO> getQuestionsByTopic(String topic) {
        List<QuizPOJO> list = new ArrayList<>();
        String query = "SELECT * FROM questions WHERE topic = ?";

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/quiz_app", "root", "root");
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, topic);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                QuizPOJO q = new QuizPOJO(
                    rs.getInt("id"),
                    rs.getString("question_text"),
                    rs.getString("option_a"),
                    rs.getString("option_b"),
                    rs.getString("option_c"),
                    rs.getString("option_d"),
                    rs.getString("correct_option").charAt(0),
                    rs.getString("topic")
                );
                list.add(q);
            }

            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // ✅ New method to save username and score
    public void saveUserScore(String username, int score) {
        String sql = "INSERT INTO users (username, score) VALUES (?, ?)";
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/quiz_app", "root", "root");
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setInt(2, score);
            ps.executeUpdate();

            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
