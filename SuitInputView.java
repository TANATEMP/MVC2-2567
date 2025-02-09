import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SuitInputView extends JFrame {
    private JTextField suitIdField;
    private JButton checkButton;
    private JLabel repairCountLabel;
    private JLabel errorMessageLabel;

    public SuitInputView() {
        setTitle("Enter Superhero Suit ID");
        setSize(500, 350);
        setLayout(new GridLayout(7, 1, 10, 10));

        JPanel suitIdPanel = new JPanel();
        suitIdPanel.add(new JLabel("Enter Suit ID (6 digits):"));
        suitIdField = new JTextField(10);
        suitIdPanel.add(suitIdField);
        add(suitIdPanel);

        //ปุ่มcheck
        JPanel checkButtonPanel = new JPanel();
        checkButton = new JButton("Check");
        checkButtonPanel.add(checkButton);
        add(checkButtonPanel);
    
        //แสดง repair count
        repairCountLabel = new JLabel("Repair Counts: Power: 0 Stealth: 0 Identity: 0");
        repairCountLabel.setHorizontalAlignment(JLabel.CENTER);
        add(repairCountLabel);
    
        // แสดงinput error
        errorMessageLabel = new JLabel("");
        errorMessageLabel.setHorizontalAlignment(JLabel.CENTER);
        errorMessageLabel.setForeground(Color.RED);
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

    public void resetSuitIdField() {
        suitIdField.setText("");
    }

    public void setRepairCountText(String text) {
        repairCountLabel.setText(text);
    }

    public void setErrorMessage(String message) {
        errorMessageLabel.setText(message);
    }

    public void clearErrorMessage() {
        errorMessageLabel.setText("");
    }
}
