
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddStudentGUI extends JFrame implements ActionListener {

    private JTextField txtName, txtMatric;
    private JButton btnAdd, btnList;
    private JTextArea txtStudents;

    public AddStudentGUI() {

        setTitle("Add Student Info");
        setSize(420, 320);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        Container pane = getContentPane();
        pane.setLayout(new BorderLayout(10, 10));

        // Student information
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));

        inputPanel.add(new JLabel("Name:"));
        txtName = new JTextField(15);
        inputPanel.add(txtName);

        inputPanel.add(new JLabel("Matric:"));
        txtMatric = new JTextField(15);
        inputPanel.add(txtMatric);

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());

        btnAdd = new JButton("Add");
        btnList = new JButton("List");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnList);

        // Top panel
        JPanel topPanel = new JPanel(new BorderLayout());

        topPanel.add(inputPanel, BorderLayout.CENTER);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);

        pane.add(topPanel, BorderLayout.NORTH);

        // Student list
        JPanel listPanel = new JPanel(new BorderLayout());

        listPanel.add(new JLabel("Students:"), BorderLayout.NORTH);

        txtStudents = new JTextArea(8, 30);
        txtStudents.setEditable(false);

        listPanel.add(new JScrollPane(txtStudents),
                BorderLayout.CENTER);

        pane.add(listPanel, BorderLayout.CENTER);

        // Register events
        btnAdd.addActionListener(this);
        btnList.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnAdd) {

            String name = txtName.getText().trim();
            String matric = txtMatric.getText().trim();

            if (name.isEmpty() || matric.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter student name and matric!");
                return;
            }

            for (Student s : BorrowData.students) {
                if (s.getMatric().equalsIgnoreCase(matric)) {
                    JOptionPane.showMessageDialog(
                            this,
                            "This matric number is already registered!");
                    return;
                }
            }

            Student student = new Student(name, matric);

            BorrowData.students.add(student);

            JOptionPane.showMessageDialog(
                    this,
                    "Student added successfully!");

            txtName.setText("");
            txtMatric.setText("");
        }

        else if (e.getSource() == btnList) {

            txtStudents.setText("");

            for (Student s : BorrowData.students) {

                txtStudents.append(
                        "Name : " + s.getName()
                        + " (" + s.getMatric() + ")\n");
            }
        }
    }

    public static void main(String[] args) {
        new AddStudentGUI();
    }
}
