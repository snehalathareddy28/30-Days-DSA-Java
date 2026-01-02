import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GuessNumber extends JFrame implements ActionListener {

JTextField input;
JLabel status, attemptsLabel;
JButton guessBtn, resetBtn;
int number, attempts;

GuessNumber() {
Random r = new Random();
number = r.nextInt(100) + 1;
attempts = 5;

setTitle("Guess The Number Game");
setSize(420, 300);
setLocationRelativeTo(null);
setDefaultCloseOperation(EXIT_ON_CLOSE);

JPanel panel = new JPanel();
panel.setBackground(new Color(240, 248, 255));
panel.setLayout(new GridLayout(6, 1, 10, 10));

JLabel title = new JLabel("Guess a number between 1 and 100", JLabel.CENTER);
title.setFont(new Font("Arial", Font.BOLD, 16));

input = new JTextField();
input.setHorizontalAlignment(JTextField.CENTER);

guessBtn = new JButton("GUESS");
resetBtn = new JButton("RESET");

guessBtn.setBackground(Color.GREEN);
resetBtn.setBackground(Color.ORANGE);

status = new JLabel("Start guessing!", JLabel.CENTER);
attemptsLabel = new JLabel("Attempts left: 5", JLabel.CENTER);

guessBtn.addActionListener(this);
resetBtn.addActionListener(e -> resetGame());

panel.add(title);
panel.add(input);
panel.add(guessBtn);
panel.add(resetBtn);
panel.add(attemptsLabel);
panel.add(status);

add(panel);
setVisible(true);
}

public void actionPerformed(ActionEvent e) {
try {
int guess = Integer.parseInt(input.getText());
attempts--;

if (guess == number) {
JOptionPane.showMessageDialog(this, " Won!");
guessBtn.setEnabled(false);
} else if (guess > number) {
status.setText("Too High!");
} else {
status.setText("Too Low!");
}

attemptsLabel.setText("Attempts left: " + attempts);
if (attempts == 0 && guess != number) {
JOptionPane.showMessageDialog(this,
"Game Over! Number was: " + number);
guessBtn.setEnabled(false);
}
} catch (Exception ex) {
JOptionPane.showMessageDialog(this, "⚠ Enter a valid number!");
}
input.setText("");
}
void resetGame() {
number = new Random().nextInt(100) + 1;
attempts = 5;
guessBtn.setEnabled(true);
status.setText("New Game Started!");
attemptsLabel.setText("Attempts left: 5");
}
public static void main(String[] args) {
new GuessNumber();
}
}
