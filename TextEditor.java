import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class TextEditor extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JFileChooser fileChooser;
    int value=16;

    public TextEditor() {
        Container c = getContentPane();
        c.setBackground(Color.BLACK);
        setTitle("Text Editor");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create a file menu (Image)
        ImageIcon ig = new ImageIcon("Images/menu-burger.png");
        Image scaledImage = ig.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        //!Frame Icon (Image)
        Image scaledImage2 = Toolkit.getDefaultToolkit().getImage("Images/text.png");
        setIconImage(scaledImage2);

        JMenu fileMenu = new JMenu();
        fileMenu.setIcon(scaledIcon);

        // Create file menu items
        JMenuItem homeMenuItem = new JMenuItem("Home");
        JMenuItem openMenuItem = new JMenuItem("Open");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        JMenuItem fontMenuItem = new JMenuItem("FontSize");

        // Add action listeners to menu items
        homeMenuItem.addActionListener(this);
        openMenuItem.addActionListener(this);
        saveMenuItem.addActionListener(this);
        exitMenuItem.addActionListener(this);
        fontMenuItem.addActionListener(this);


        // Add file menu items to file menu
        fileMenu.add(homeMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(fontMenuItem);
        fileMenu.add(exitMenuItem);

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
            SwingUtilities.invokeLater(() -> new Home());
        } else if (command.equals("Open")) {
            openFile();
        } else if (command.equals("Save")) {
            saveFile();
        } else if (command.equals("Exit")) {
            System.exit(0);
        } else if (command.equals("FontSize")) {
            
            String m = JOptionPane.showInputDialog("Input size:", value);
            System.out.println(m);
            try {
                if(m.equals(null)){
                    throw new NullPointerException("Null value received");  
                }
                value = Integer.parseInt(m);
            } catch (NullPointerException ext) {
                return;
            } catch (NumberFormatException ext) {
                JOptionPane.showMessageDialog(super.getContentPane(), "Input valid number format!", "Warnig Message", JOptionPane.WARNING_MESSAGE);
            } catch(Exception ext) {
                JOptionPane.showMessageDialog(super.getContentPane(), ext.getMessage(), "Warnig Message", JOptionPane.WARNING_MESSAGE);
            }
            textArea.setFont(new Font("Courier New", Font.PLAIN, value));
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
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 2);
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
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 2);
            }
        }
    }

    public static void main(String[] args) {
        // SwingUtilities.invokeLater(() -> new TextEditor());
        TextEditor ob = new TextEditor();
    }
}