import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel {
	JLabel lblNewLabel;
	JLabel lblNewLabel_1;
	private Timer timer;
	private Player player;
	private Enemy enemy[];
	private Background background;
	private Graphics2D twoD;
	private int playerFireTimer;
	private int enemyFireTimer;
	private ArrayList<Bullet> playerBullets;
	private ArrayList<Bullet> enemyBullets;
	Random random;

	/**
	 * Create the panel.
	 */
	public Board() {
		setLayout(null);
		
		lblNewLabel = new JLabel("SCORE :");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(494, 11, 51, 25);
		add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("0");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(567, 8, 23, 31);
		add(lblNewLabel_1);
		drawBoard();
		
		background = new Background();
		player = new Player();
		enemy = new Enemy[GameConstants.ENEMY_NUMBER];
		playerBullets = new ArrayList<>();
		enemyBullets = new ArrayList<>();
		playerFireTimer = GameConstants.FIRE_DELAY;
		enemyFireTimer = GameConstants.FIRE_DELAY;
		random = new Random();
		for(int number = 0 ; number < GameConstants.ENEMY_NUMBER ; ++number) {
			enemy[number] = new Enemy(number);
		}

	}
	
	private void drawBoard() {
		setBounds(0,0,GameConstants.BOARD_WIDTH, GameConstants.BOARD_HEIGHT);
		setFocusable(true);
		timer = new Timer(GameConstants.DELAY, (e)-> {
			repaint();
		});
		timer.start();
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if(key == KeyEvent.VK_SPACE) {
					if(playerFireTimer == 0) {
						player.fire();
						playerBullets.add(player.getBullet());
						playerFireTimer = GameConstants.FIRE_DELAY;
					}
				}
				if(key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
					player.up();
				}
				else if(key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
					player.down();
				}
				else if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
					player.left();
				}
				else if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
					player.right();
				}
			}
		});
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		twoD = (Graphics2D) g;
		drawBackground();
		drawPlayer();
		int number;
		if(enemyFireTimer == 0) {
//			int used[] = new int[5];
			for(int i = 0; i < random.nextInt(GameConstants.ENEMY_NUMBER); ++i) {
				int num = random.nextInt(GameConstants.ENEMY_NUMBER);
//				for(int j : used) {
//					if(j == num) {
//						break;
//					}
//				}
				enemy[num].fire();
				enemyBullets.add(enemy[num].getBullet());
			}
			enemyFireTimer = GameConstants.FIRE_DELAY;
		}
		for(number = 0 ; number < GameConstants.ENEMY_NUMBER ; ++number) {
			drawEnemy(number);
		}
		for(number = 0 ; number < enemyBullets.size() ; ++number) {
			enemyBullets.get(number).moveBullet(GameConstants.ENEMY_SMALL);
			drawEnemyBullet(number);
		}
		for(number = 0 ; number < playerBullets.size() ; ++number) {
			playerBullets.get(number).moveBullet(GameConstants.PLAYER);;
			drawPlayerBullet(number);
		}
		Toolkit.getDefaultToolkit().sync();
		collide();
		if(playerFireTimer > 0) {
			--playerFireTimer;
		}
		if(enemyFireTimer > 0) {
			--enemyFireTimer;
		}
		else {
			
		}
	}

	private void collide() {
		
	}

	private void drawBackground() {
		twoD.drawImage(background.getBackground(), 0, 0, GameConstants.BOARD_WIDTH, GameConstants.BOARD_HEIGHT, null);
	}

	private void drawPlayer() {
		twoD.drawImage(player.getImage(), player.getX(), player.getY(), player.getWidth(), player.getHeight(), null);
	}

	private void drawEnemy(int number) {
		twoD.drawImage(enemy[number].getImage(), enemy[number].getX(), enemy[number].getY(), enemy[number].getWidth(), enemy[number].getHeight(), null);
	}

	private void drawPlayerBullet(int number) {
		twoD.drawImage(playerBullets.get(number).getImage(), playerBullets.get(number).getX(), playerBullets.get(number).getY(), playerBullets.get(number).getWidth(), playerBullets.get(number).getHeight(), null);
	}

	private void drawEnemyBullet(int number) {
		twoD.drawImage(enemyBullets.get(number).getImage(), enemyBullets.get(number).getX(), enemyBullets.get(number).getY(), enemyBullets.get(number).getWidth(), enemyBullets.get(number).getHeight(), null);
	}

}
