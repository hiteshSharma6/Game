import java.awt.Image;

public class Sprite {
	protected int object;
	protected int x;
	protected int y;
	protected int height;
	protected int width;
	protected Image image;
	protected int health;
	protected Bullet bullet;
	
	public int getObject() {
		return object;
	}
	public void setObject(int object) {
		this.object = object;
	}	
	public Bullet getBullet() {
		return bullet;
	}
	public void setBullets(Bullet bullet) {
		this.bullet = bullet;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
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
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}

}
