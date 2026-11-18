
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddBookGUI extends JFrame implements ActionListener {

    private JTextField txtTitle, txtAuthor;
    private JButton btnAdd, btnList;
    private JTextArea txtBooks;

    public AddBookGUI() {

        setTitle("Add Book Info");
        setSize(420, 320);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        Container pane = getContentPane();
        pane.setLayout(new BorderLayout(10, 10));

        // Book information
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));

        inputPanel.add(new JLabel("Book Title:"));
        txtTitle = new JTextField(15);
        inputPanel.add(txtTitle);

        inputPanel.add(new JLabel("Author:"));
        txtAuthor = new JTextField(15);
        inputPanel.add(txtAuthor);

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

        // Book list
        JPanel listPanel = new JPanel(new BorderLayout());

        listPanel.add(new JLabel("Books:"), BorderLayout.NORTH);

        txtBooks = new JTextArea(8, 30);
        txtBooks.setEditable(false);

        listPanel.add(new JScrollPane(txtBooks),
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

            String title = txtTitle.getText().trim();
            String author = txtAuthor.getText().trim();

            if (title.isEmpty() || author.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter book title and author!");
                return;
            }

            Book book = new Book(title, author);

            BorrowData.books.add(book);

            JOptionPane.showMessageDialog(
                    this,
                    "Book added successfully!");

            txtTitle.setText("");
            txtAuthor.setText("");
        }

        else if (e.getSource() == btnList) {

            txtBooks.setText("");

            for (Book b : BorrowData.books) {

                txtBooks.append(
                        "Book title : " + b.getTitle()
                        + " (Author : " + b.getAuthor() + ")\n");
            }
        }
    }

    public static void main(String[] args) {
        new AddBookGUI();
    }
}

