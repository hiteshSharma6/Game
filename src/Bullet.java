import java.awt.Image;

import javax.swing.ImageIcon;

public class Bullet {
	private int x;
	private int y;
	private int height;
	private int width;
	private Image image;
	private int damage;
	
	Bullet(int object, int x, int y) {
		this.x = x;
		this.y = y;
		this.height = GameConstants.BULLET_HEIGHT;
		this.width = GameConstants.BULLET_WIDTH;
		bulletDamage(object);
		bulletImage(object);
	}
	
	private void bulletImage(int object) {
		if(object == GameConstants.PLAYER) {
			this.image = new ImageIcon(Bullet.class.getResource("MissileMediumUp.png")).getImage();
		}
		else {
			this.image = new ImageIcon(Bullet.class.getResource("MissileMediumDown.png")).getImage();
		}
		
	}

	public void moveBullet(int object) {
		if(object == GameConstants.PLAYER) {
			this.y--;
		}
		else {
			this.y++;
		}
	}
	
	private void bulletDamage(int object) {
		if(object == GameConstants.PLAYER) {
			this.damage = 10;
		}
		else if(object == GameConstants.ENEMY_SMALL) {
			this.damage = 20;
		}
		else if(object == GameConstants.ENEMY_LEADER) {
			this.damage = 30;
		}
		else if(object == GameConstants.ENEMY_BOSS) {
			this.damage = 50;
		}
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Image getImage() {
		return image;
	}
	
	public void setImage(Image image) {
		this.image = image;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

}
