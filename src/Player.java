import javax.swing.ImageIcon;

public class Player extends Sprite{
	
	public Player() {
		this.height = this.width = GameConstants.DIMENSION;
		this.x = GameConstants.BOARD_WIDTH / 2;
		this.y = GameConstants.MAX_Y;
		this.health = 100;
		this.image = new ImageIcon(Player.class.getResource("Player.png")).getImage();
		this.object = GameConstants.PLAYER;
	}
	
	public void fire() {
		this.bullet = new Bullet(GameConstants.PLAYER, this.x + GameConstants.PLAYER_CENTER_WIDTH, this.y - GameConstants.PLAYER_CENTER_HEIGHT);
	}
	
	public void up() {
		if(this.y > GameConstants.MIN_Y) {
			--this.y;
		}
	}
	
	public void down() {
		if(this.y < GameConstants.MAX_Y) {
			++this.y;
		}
	}
	
	public void left() {
		if(this.x > GameConstants.MIN_X) {
			--this.x;
		}
	}
	
	public void right() {
		if(this.x < GameConstants.MAX_X) {
			++this.x;
		}
	}

}
