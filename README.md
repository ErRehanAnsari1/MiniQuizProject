# Mini Quiz Application

A simple and interactive console-based Java application that allows users to take quizzes on core Java topics. This project is developed using Core Java, JDBC, and MySQL. It is ideal for beginners and intermediate developers who want to practice Java with database integration.

---

## Features

- Select topic from predefined categories (Java Basics, OOPs, Collections)
- Choose the number of questions (5 or 10)
- Randomized questions for every attempt
- Input validation for topic selection and answers
- Personalized score and feedback at the end
- Score is saved into the database for future reference

---

## Technologies Used

- Java (JDK 8+)
- JDBC (MySQL Connector)
- MySQL Database
- Maven (for dependency and project management)

---

## Prerequisites

To run this project locally, make sure you have:

- JDK 8 or later installed
- MySQL installed and running
- Maven installed (recommended but optional if using Eclipse)
- MySQL Connector/J 5.1.42 dependency added (already present in the project)

---

## Database Setup

1. **Create Database**

```sql
CREATE DATABASE quiz_app;
USE quiz_app;

##Table##

CREATE TABLE questions (
    id INT PRIMARY KEY AUTO_INCREMENT,
    question_text TEXT NOT NULL,
    option_a VARCHAR(255),
    option_b VARCHAR(255),
    option_c VARCHAR(255),
    option_d VARCHAR(255),
    correct_option CHAR(1),
    topic VARCHAR(100)
);

##OutPutDemo##

🔸 Mini Quiz App Started!
Enter your name: rehan ansari
Choose topic:
1. Java Basics
2. OOPs
3. Collections
Enter choice (1-3): 2
How many questions do you want? (5 or 10): 5

Q1: What is polymorphism in OOPs?
A. Feature that allows inheritance
B. Method overloading/overriding
...

✅ Quiz Completed!
👤 Name: rehan ansari
📘 Topic: OOPs
📊 Score: 4/5
👍 Good job!
🎉 Result saved successfully!


About the Author
Hi, I'm Rehan Ansari, a passionate Java developer currently learning and building real-time console-based projects using Core Java, JDBC, and MySQL.
This project helped me strengthen my backend logic and apply Java fundamentals in a practical way.
Feel free to explore, learn, and contribute!

GitHub Profile: @ErRehanAnsari1

