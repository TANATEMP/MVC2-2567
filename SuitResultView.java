import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SuitResultView extends JFrame {
    private JTextArea resultArea;
    private JButton repairButton;
    private Suit currentSuit;

    public SuitResultView() {
        setTitle("Result");
        setSize(350, 250);
        setLayout(new FlowLayout());

        resultArea = new JTextArea(6, 25);
        resultArea.setEditable(false);
        add(resultArea);

        repairButton = new JButton("Repair");
        repairButton.setVisible(false);
        add(repairButton);

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(false);
    }

    public void showResult(String message) {
        resultArea.setText(message);
        repairButton.setVisible(false);
        currentSuit = null;
    }
    
    public void showResult(String message, Suit suit) {
        String resultMessage = message + "\nDurability: " + suit.getDurability();
        resultArea.setText(resultMessage);
        currentSuit = suit;
    }
    
    
    public void showRepairButton() {
        repairButton.setVisible(true);
    }

    public void addRepairButtonListener(ActionListener listener) {
        repairButton.addActionListener(listener);
    }

    public Suit getSuitForRepair() {
        return currentSuit;
    }
}
