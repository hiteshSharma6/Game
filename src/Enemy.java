import javax.swing.ImageIcon;

public class Enemy extends Sprite {
	
	public Enemy(int number) {
		this.height = this.width = GameConstants.DIMENSION;
		this.x = 50 + number*100;
		this.y = GameConstants.MIN_Y;
		setImage(number);
	}
	
	private void setImage(int number) {
		if(number == 2) {
			this.object = GameConstants.ENEMY_LEADER;
			this.image = new ImageIcon(Enemy.class.getResource("EnemyLeader.png")).getImage();
			this.health = 70;
		}
		else {
			this.object = GameConstants.ENEMY_SMALL;
			this.image = new ImageIcon(Enemy.class.getResource("EnemySmall.png")).getImage();
			this.health = 40;
		}
	}
	
	public void fire() {
		if(this.object == GameConstants.ENEMY_LEADER) {
			this.bullet = new Bullet(GameConstants.ENEMY_LEADER, this.x + GameConstants.ENEMY_CENTER_WIDTH, this.y + GameConstants.ENEMY_CENTER_HEIGHT);
		}
		else {
			this.bullet = new Bullet(GameConstants.ENEMY_SMALL, this.x + GameConstants.ENEMY_CENTER_WIDTH, this.y + GameConstants.ENEMY_CENTER_HEIGHT);
		}
	}

}
