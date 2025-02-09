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

    public SuitInputView() {
        setTitle("Enter Superhero Suit ID");
        setSize(500, 350);
        setLayout(new GridLayout(6, 1, 10, 10));
    
        JPanel suitIdPanel = new JPanel();
        suitIdPanel.add(new JLabel("Enter Suit ID (6 digits):"));
        suitIdField = new JTextField(10);
        suitIdPanel.add(suitIdField);
        add(suitIdPanel);

        JPanel checkButtonPanel = new JPanel();
        checkButton = new JButton("Check");
        checkButtonPanel.add(checkButton);
        add(checkButtonPanel);
    
        resultLabel = new JLabel("");
        resultLabel.setHorizontalAlignment(JLabel.CENTER);
        add(resultLabel);
    
        repairCountLabel = new JLabel("Repair Counts: Power: 0 Stealth: 0 Identity: 0");
        repairCountLabel.setHorizontalAlignment(JLabel.CENTER);
        add(repairCountLabel);
    
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
}
