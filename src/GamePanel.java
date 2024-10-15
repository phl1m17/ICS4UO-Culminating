
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
    int tileSize = 32*6;
    int screenWidth = tileSize*4;
    int screenLength = tileSize*3;

    TitlePanel tPanel = new TitlePanel(this);
    Player player = new Player(this);
    Computer computer = new Computer(this);
    BattlePanel bPanel = new BattlePanel(this,player,computer);
    CharacterPanel cPanel = new CharacterPanel(this, player);
    TutorialPanel toPanel = new TutorialPanel(this);
    Constants c = new Constants();
    KeyHandler keyH = new KeyHandler();

    Thread gameThread;
    int FPS = 60;

    public GamePanel(){
        setPreferredSize(new Dimension(screenWidth, screenLength));
        addKeyListener(keyH);
        setFocusable(true);
    }
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    public void update(){
        if(keyH.backKey == true && keyH.characterScreen == true){
            keyH.characterScreen = false;
            keyH.backKey = false;
            remove(cPanel.fire);
            remove(cPanel.water);
            remove(cPanel.earth);
        }
        if(keyH.backKey == true && keyH.tutorialScreen == true){
            keyH.tutorialScreen = false;
            keyH.backKey = false;
            remove(cPanel.fire);
            remove(cPanel.water);
            remove(cPanel.earth);
        }
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(keyH.characterScreen == false && keyH.tutorialScreen == false && cPanel.startGame == false){
            tPanel.paint(g);
        }
        if(keyH.characterScreen == true){
            cPanel.paint(g);
            add(cPanel.fire);
            add(cPanel.water);
            add(cPanel.earth);
        }
        if(keyH.tutorialScreen == true){
            toPanel.paint(g);
        }
        if(cPanel.startGame == true){
            remove(cPanel.fire);
            remove(cPanel.water);
            remove(cPanel.earth);
            player.paint(g);
            computer.paint(g);
            bPanel.paint(g);
            add(bPanel.special);
            add(bPanel.attack);
        }
    }
    @Override
    public void run() {
        // DELTA GAME LOOP
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		
		while(gameThread != null) {
			currentTime = System.nanoTime();
			
			delta += (currentTime-lastTime)/drawInterval; // how much time has passed divided by how many times we want to draw per second
			lastTime = currentTime;
			
			if(delta>1) {
				update();
				repaint();
				delta--;
			}
		}
    }
}
