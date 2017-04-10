import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GameRules {

	public static void main(String[] args) throws IOException {

		BufferedImage image = ImageIO.read(new File(("D:\\JAVA_programing\\workspace\\01_gra_odgaywanie_wymieszanych_slowek\\GameRules.jpg")));
		JLabel picLabel = new JLabel(new ImageIcon(image));
		JOptionPane.showMessageDialog(null, picLabel, "Guess The Word - Rules ver. 1.0", JOptionPane.PLAIN_MESSAGE);
	}
}
