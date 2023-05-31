import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class tesztform extends JFrame{
    private JPanel panelMain;
    private JLabel mainLbl;
    private JTextField textField1;
    private JButton button1;
public tesztform() {

    this.setContentPane(this.panelMain);
    this.setVisible(true);
    this.setSize(300,300);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    button1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(button1, textField1.getText());
        }
    });
}

//public static void main(String[] args) {
//    tesztform frame = new tesztform();
//    frame.setContentPane(frame.panelMain);
//    frame.setVisible(true);
//    frame.setSize(300,300);
//    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//}
}
