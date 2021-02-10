package gui;

import main.Data;
import main.Main;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RemovePerson extends JDialog {
    private final Data data = Main.data;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField nameBox;

    public RemovePerson() {
        setTitle("Remove Person ");
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(e -> onOK());

        buttonCancel.addActionListener(e -> onCancel());

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    public static void main() {
        RemovePerson dialog = new RemovePerson();
        dialog.pack();
        dialog.setVisible(true);
    }

    private void onOK() {
        data.removePerson(nameBox.getText());
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
