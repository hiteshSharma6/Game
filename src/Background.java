import java.awt.Image;

import javax.swing.ImageIcon;

public class Background {
	private Image background;
	
	Background() {
		background = new ImageIcon(Background.class.getResource("Background.jpg")).getImage();
	}

	public Image getBackground() {
		return background;
	}

	public void setBackground(Image image) {
		this.background = image;
	}

}
