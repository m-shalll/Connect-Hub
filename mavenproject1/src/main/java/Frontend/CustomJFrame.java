
package Frontend;
import javax.swing.*;
import java.awt.*;

public class CustomJFrame extends JPanel{
    private static final String backgroundPhoto = "Images\\JFrameBackground2.jpg";
    public CustomJFrame(javax.swing.JFrame frame){
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setLayout(null);
        JPanel backgroundPanel = new JPanel() {
            Image backgroundImage = new ImageIcon(backgroundPhoto).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, frame.getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setBounds(0, 0, frame.getWidth(), frame.getHeight()); 
        layeredPane.add(backgroundPanel, Integer.valueOf(0));
        frame.getContentPane().add(backgroundPanel);

    }
}
