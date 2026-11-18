
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BorrowBookGUI extends JFrame implements ActionListener {

    private JComboBox<Student> cmbStudent;
    private JComboBox<Book> cmbBook;
    private JButton btnBorrow;
    private JLabel lblBorrowInfo, lblResult;

    public BorrowBookGUI() {

        setTitle("Borrow Book");
        setSize(360, 190);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        Container pane = getContentPane();
        pane.setLayout(new BorderLayout(5, 5));

        // Student and Book selection
        JPanel selectionPanel = new JPanel(new GridLayout(2, 2, 5, 5));

        selectionPanel.add(new JLabel("Student Name & Matric:"));

        cmbStudent = new JComboBox<Student>();

        for (Student s : BorrowData.students) {
            cmbStudent.addItem(s);
        }

        selectionPanel.add(cmbStudent);

        selectionPanel.add(new JLabel("Book Title & Author:"));

        cmbBook = new JComboBox<Book>();

        for (Book b : BorrowData.books) {
            cmbBook.addItem(b);
        }

        selectionPanel.add(cmbBook);

        // Borrow button
        JPanel buttonPanel = new JPanel(new FlowLayout());

        btnBorrow = new JButton("Borrow");
        buttonPanel.add(btnBorrow);

        // Top panel
        JPanel topPanel = new JPanel(new BorderLayout());

        topPanel.add(selectionPanel, BorderLayout.CENTER);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);

        pane.add(topPanel, BorderLayout.NORTH);

        // Borrow information
        JPanel infoPanel = new JPanel(new GridLayout(2, 1));

        lblBorrowInfo = new JLabel("Borrow Information :");
        lblResult = new JLabel("");

        infoPanel.add(lblBorrowInfo);
        infoPanel.add(lblResult);

        pane.add(infoPanel, BorderLayout.CENTER);

        // Register event
        btnBorrow.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnBorrow) {

            Student student =
                (Student) cmbStudent.getSelectedItem();

            Book book =
                    (Book) cmbBook.getSelectedItem();

            if (student != null && book != null)  {

                lblResult.setText(
                    student.getName()
                    
                    + " with matric number "
                    + student.getMatric()
                    + " has borrow a book with title "
                    + book.getTitle() + "."
                );
            }
        }
    }
}

