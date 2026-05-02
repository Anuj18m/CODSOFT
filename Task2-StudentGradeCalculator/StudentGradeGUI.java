import javax.swing.*;
import java.awt.*;

public class StudentGradeGUI {

    public StudentGradeGUI() {

        JFrame frame = new JFrame("Student Grade Calculator");

        // Components
        JLabel label = new JLabel("Enter marks for 5 subjects:");

        JTextField m1 = new JTextField(5);
        JTextField m2 = new JTextField(5);
        JTextField m3 = new JTextField(5);
        JTextField m4 = new JTextField(5);
        JTextField m5 = new JTextField(5);

        JButton calculateBtn = new JButton("Calculate");

        JLabel resultLabel = new JLabel("Result will appear here");
        resultLabel.setHorizontalAlignment(JLabel.CENTER);

        // Fonts
        label.setFont(new Font("Arial", Font.BOLD, 14));
        resultLabel.setFont(new Font("Arial", Font.BOLD, 12));

        // Button styling
        calculateBtn.setBackground(new Color(70, 130, 180));
        calculateBtn.setForeground(Color.WHITE);

        // Panels
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        inputPanel.add(label);
        inputPanel.add(m1);
        inputPanel.add(m2);
        inputPanel.add(m3);
        inputPanel.add(m4);
        inputPanel.add(m5);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(calculateBtn);

        JPanel resultPanel = new JPanel();
        resultPanel.add(resultLabel);

        // Frame layout
        frame.setLayout(new GridLayout(3, 1, 10, 10));

        frame.add(inputPanel);
        frame.add(buttonPanel);
        frame.add(resultPanel);

        // Padding
        ((JComponent) frame.getContentPane()).setBorder(
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        // Button logic
        calculateBtn.addActionListener(e -> {
            try {
                int marks1 = Integer.parseInt(m1.getText());
                int marks2 = Integer.parseInt(m2.getText());
                int marks3 = Integer.parseInt(m3.getText());
                int marks4 = Integer.parseInt(m4.getText());
                int marks5 = Integer.parseInt(m5.getText());

                int[] marks = {marks1, marks2, marks3, marks4, marks5};

                // Validation
                for (int m : marks) {
                    if (m < 0 || m > 100) {
                        resultLabel.setText("⚠️ Marks must be between 0–100");
                        return;
                    }
                }

                // Total
                int total = 0;
                for (int m : marks) total += m;

                // Average
                double average = total / 5.0;

                // Max & Min
                int max = marks[0];
                int min = marks[0];

                for (int i = 1; i < marks.length; i++) {
                    if (marks[i] > max) max = marks[i];
                    if (marks[i] < min) min = marks[i];
                }

                // Grade + performance
                char grade;
                String performance;

                if (average >= 90) {
                    grade = 'A';
                    performance = "Excellent";
                } else if (average >= 80) {
                    grade = 'B';
                    performance = "Good";
                } else if (average >= 70) {
                    grade = 'C';
                    performance = "Average";
                } else if (average >= 60) {
                    grade = 'D';
                    performance = "Needs Improvement";
                } else {
                    grade = 'F';
                    performance = "Fail";
                }

                // Display result
                resultLabel.setText(
                        "<html>Total: " + total +
                        " | Avg: " + average + "%" +
                        " | Max: " + max +
                        " | Min: " + min +
                        "<br>Grade: " + grade +
                        " (" + performance + ")</html>"
                );

            } catch (Exception ex) {
                resultLabel.setText("⚠️ Enter valid numbers!");
            }
        });

        // Frame settings
        frame.setSize(400, 220);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new StudentGradeGUI();
    }
}