package jump;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
public class PhoneImagePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private Image image=null;

	@Override
	public void paint(Graphics g){
		try {
			Utils.screen();
			image = ImageIO.read(new File("D:\\jump.png"));
			g.drawImage(image, 0, 0, 540, 960, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
