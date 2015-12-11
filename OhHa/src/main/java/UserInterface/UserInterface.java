package UserInterface;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

/**
 *
 * @author I
 */
public class UserInterface implements Runnable {
    
    private JFrame frame;
    private JTextArea area;
    
    public UserInterface() {
        this.area = new JTextArea();
        Font font = new Font("Monospaced", Font.BOLD, 15);
        area.setFont(font);
        area.setEditable(false);
    }
    
    @Override
    public void run() {
        frame = new JFrame("1st AND GOAL");
        frame.setPreferredSize(new Dimension(1000, 700));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    private void luoKomponentit(Container container) {
        container.add(area);
    }
    
    public void print(String string) {
        this.area.append(string + " ");
    }
    
    public void empty() {
        area.setText(null);
    }
    
}
