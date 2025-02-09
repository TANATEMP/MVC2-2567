import javax.swing.*;
import java.awt.*;

public class SuitRepairView extends JFrame {
    private JTextArea repairArea;

    public SuitRepairView() {
        setTitle("Repair Suite");
        setSize(300, 150);
        setLayout(new FlowLayout());

        repairArea = new JTextArea(5, 20);
        repairArea.setEditable(false);
        add(repairArea);

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(false);
    }

    //แสดงผลการซ่อมหลังจากกดซ่อม
    public void showRepairResult(Suit suit) {
        repairArea.setText("Repaired\n"
                + "ID: " + suit.getId() + "\n"
                + "Type: " + suit.getType() + "\n"
                + "Durability: " + suit.getDurability());
    }
}
