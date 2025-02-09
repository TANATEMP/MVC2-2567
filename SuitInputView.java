import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SuitInputView extends JFrame {
    private JTextField suitIdField;
    private JButton checkButton;
    private JButton repairButton;
    private JLabel resultLabel;
    private JLabel durabilityLabel;
    private JLabel repairCountLabel;
    private JLabel errorMessageLabel; // New label for error messages

    public SuitInputView() {
        setTitle("Enter Superhero Suit ID");
        setSize(500, 350);
        setLayout(new GridLayout(7, 1, 10, 10)); // Increased rows for the error message label
    
        // Panel for Suit ID input
        JPanel suitIdPanel = new JPanel();
        suitIdPanel.add(new JLabel("Enter Suit ID (6 digits):"));
        suitIdField = new JTextField(10);
        suitIdPanel.add(suitIdField);
        add(suitIdPanel);

        // Panel for Check button
        JPanel checkButtonPanel = new JPanel();
        checkButton = new JButton("Check");
        checkButtonPanel.add(checkButton);
        add(checkButtonPanel);
    
        // Result label
        resultLabel = new JLabel("");
        resultLabel.setHorizontalAlignment(JLabel.CENTER);
        add(resultLabel);
    
        // Repair Count label
        repairCountLabel = new JLabel("Repair Counts: Power: 0 Stealth: 0 Identity: 0");
        repairCountLabel.setHorizontalAlignment(JLabel.CENTER);
        add(repairCountLabel);
    
        // Error message label (new)
        errorMessageLabel = new JLabel("");  // Initially empty
        errorMessageLabel.setHorizontalAlignment(JLabel.CENTER);
        errorMessageLabel.setForeground(Color.RED);  // Red color for errors
        add(errorMessageLabel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public String getSuitId() {
        return suitIdField.getText();
    }

    public void addCheckButtonListener(ActionListener listener) {
        checkButton.addActionListener(listener);
    }

    public void addRepairButtonListener(ActionListener listener) {
        repairButton.addActionListener(listener);
    }

    public void setResult(String result) {
        resultLabel.setText(result);
    }

    public void setDurabilityText(String durability) {
        durabilityLabel.setText(durability);
    }

    public void setRepairButtonEnabled(boolean enabled) {
        repairButton.setEnabled(enabled);
    }

    public void resetSuitIdField() {
        suitIdField.setText("");
    }

    public void setRepairCountText(String text) {
        repairCountLabel.setText(text);
    }

    // Set error message
    public void setErrorMessage(String message) {
        errorMessageLabel.setText(message); // Display the error message
    }

    // Clear the error message
    public void clearErrorMessage() {
        errorMessageLabel.setText(""); // Clear the error message
    }
}
