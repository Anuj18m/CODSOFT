import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class NumberGameGUI {

    private int randomNumber;
    private int attempts;
    private int maxAttempts;
    private int range;

    private JTextField inputField;
    private JLabel messageLabel;
    private JButton guessButton;
    private JButton resetButton;
    private JComboBox<String> difficultyBox;

    public NumberGameGUI() {

        JFrame frame = new JFrame("Number Guessing Game");

        // Difficulty options
        String[] levels = {"Easy", "Medium", "Hard"};
        difficultyBox = new JComboBox<>(levels);

        // Initialize game
        setDifficulty("Medium");
        resetGame();

        JLabel instruction = new JLabel("Guess a number:");
        inputField = new JTextField(10);
        guessButton = new JButton("Guess");
        resetButton = new JButton("Play Again");
        messageLabel = new JLabel("Select difficulty and start!");

        // Guess button logic
        guessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int userGuess = Integer.parseInt(inputField.getText());
                    attempts++;

                    if (userGuess == randomNumber) {
                        messageLabel.setText("🎉 Correct! Attempts: " + attempts);
                        guessButton.setEnabled(false);
                    } else if (attempts >= maxAttempts) {
                        messageLabel.setText("❌ Game Over! Number was: " + randomNumber);
                        guessButton.setEnabled(false);
                    } else if (userGuess < randomNumber) {
                        messageLabel.setText("Too Low! Attempts left: " + (maxAttempts - attempts));
                    } else {
                        messageLabel.setText("Too High! Attempts left: " + (maxAttempts - attempts));
                    }

                    inputField.setText("");

                } catch (NumberFormatException ex) {
                    messageLabel.setText("⚠️ Enter a valid number!");
                }
            }
        });

        // Reset button logic
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selected = (String) difficultyBox.getSelectedItem();
                setDifficulty(selected);
                resetGame();

                messageLabel.setText("Game reset! Difficulty: " + selected);
                inputField.setText("");
                guessButton.setEnabled(true);
            }
        });

        // Layout
        frame.setLayout(new java.awt.FlowLayout());
        frame.add(new JLabel("Difficulty:"));
        frame.add(difficultyBox);
        frame.add(instruction);
        frame.add(inputField);
        frame.add(guessButton);
        frame.add(resetButton);
        frame.add(messageLabel);

        frame.setSize(350, 220);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Set difficulty
    private void setDifficulty(String level) {
        switch (level) {
            case "Easy":
                range = 50;
                maxAttempts = 10;
                break;
            case "Hard":
                range = 200;
                maxAttempts = 3;
                break;
            default:
                range = 100;
                maxAttempts = 5;
        }
    }

    // Reset game
    private void resetGame() {
        Random random = new Random();
        randomNumber = random.nextInt(range) + 1;
        attempts = 0;
    }

    public static void main(String[] args) {
        new NumberGameGUI();
    }
}