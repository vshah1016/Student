package gui;


import dataClass.Graduate;
import dataClass.Person;
import dataClass.Student;
import dataClass.Undergraduate;
import exceptions.MaximumPeople;
import main.Data;
import main.Main;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.InputMismatchException;

public class AddPerson extends JDialog {
    private final Data data = Main.data;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField studentID;
    private JTextField gradeLevel;
    private JTextField major;
    private JTextField name;

    public AddPerson() {
        setTitle("Add Person");
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(e -> {
            try {
                onOK();
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
            dispose();
        });

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
        AddPerson dialog = new AddPerson();
        dialog.pack();
        dialog.setVisible(true);
    }

    private void onOK() throws InputMismatchException, MaximumPeople {
        int id;
        String nameText = name.getText();
        String idText = studentID.getText();
        String gradeLevelText = gradeLevel.getText();
        String majorText = major.getText();

        if (!gradeLevelText.equals("") && !majorText.equals("")) throw new InputMismatchException("Invalid Input.");


        if (idText.equals("") && gradeLevelText.equals("") && majorText.equals(""))
            data.addPerson(new Person(nameText));
        else if (gradeLevelText.equals("") && majorText.equals("")) {
            try {
                id = Integer.parseInt(idText);
            } catch (Exception e) {
                throw new InputMismatchException("Invalid Input.");
            }
            data.addPerson(new Student(nameText, id));
        } else if (!gradeLevelText.equals("")) {
            try {
                if (idText.equals("")) throw new InputMismatchException("Invalid Input.");
                id = Integer.parseInt(idText);
            } catch (Exception e) {
                throw new InputMismatchException("Invalid Input.");
            }
            data.addPerson(new Undergraduate(nameText, id, gradeLevelText));
        } else {
            try {
                if (idText.equals("")) throw new InputMismatchException("Invalid Input.");
                id = Integer.parseInt(idText);
            } catch (Exception e) {
                throw new InputMismatchException("Invalid Input.");
            }
            data.addPerson(new Graduate(nameText, id, majorText));
        }

        dispose();
    }

    private void onCancel() {
        dispose();
    }
}
