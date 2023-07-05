import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class TextEditor extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JFileChooser fileChooser;

    public TextEditor() {
        setTitle("Text Editor");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create a file menu (Image)
        ImageIcon ig = new ImageIcon("Menu.jpg");
        Image scaledImage = ig.getImage().getScaledInstance(20, 15, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JMenu fileMenu = new JMenu();
        fileMenu.setIcon(scaledIcon);

        // Create file menu items
        JMenuItem homeMenuItem = new JMenuItem("Home");
        JMenuItem openMenuItem = new JMenuItem("Open");
        JMenuItem saveMenuItem = new JMenuItem("Save");

        // Add action listeners to menu items
        homeMenuItem.addActionListener(this);
        openMenuItem.addActionListener(this);
        saveMenuItem.addActionListener(this);

        // Add file menu items to file menu
        fileMenu.add(homeMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);

        // Add file menu to menu bar
        menuBar.add(fileMenu);

        // Set menu bar for the frame
        setJMenuBar(menuBar);

        // Create a text area
        textArea = new JTextArea();
        textArea.setFont(new Font("Courier New", Font.PLAIN, 12));

        // Create a scroll pane and add the text area to it
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);

        // Create a file chooser
        fileChooser = new JFileChooser();

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(command.equals("Home")) {
            setVisible(false);
            SwingUtilities.invokeLater(() -> new Test());
        } else if (command.equals("Open")) {
            openFile();
        } else if (command.equals("Save")) {
            saveFile();
        }
    }

    private void openFile() {
        int returnVal = fileChooser.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                textArea.read(reader, null);
                reader.close();
            } catch (IOException e) {
                String errorMssg = e.getMessage();
                JOptionPane.showMessageDialog(null, errorMssg, "Error", 2);
            }
        }
    }

    private void saveFile() {
        int returnVal = fileChooser.showSaveDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                textArea.write(writer);
                writer.close();
            } catch (IOException e) {
                String errorMssg = e.getMessage();
                JOptionPane.showMessageDialog(null, errorMssg, "Error", 2);
            }
        }
    }

    public static void main(String[] args) {
        // SwingUtilities.invokeLater(() -> new TextEditor());
        TextEditor ob = new TextEditor();
    }
}