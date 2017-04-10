import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GameRules {

	public static void main(String[] args) throws IOException {
		
        try {
            BufferedImage bufferedImage = ImageIO.read(GameRules.class.getResource("/img/GameRules.png"));
            JLabel labelImage = new JLabel(new ImageIcon(bufferedImage));
            JOptionPane.showMessageDialog(null, labelImage, "Guess The Word - Rules ver. 1.0", JOptionPane.PLAIN_MESSAGE);
            
        } catch (IOException e) {
            e.printStackTrace();
        }      
	}
}
