
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
    int tileSize = 32*6;
    int screenWidth = tileSize*4;
    int screenLength = tileSize*3;

    TitlePanel tPanel = new TitlePanel(this);
    BattlePanel bPanel = new BattlePanel(this);
    CharacterPanel cPanel = new CharacterPanel(this);
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
        }
        if(keyH.backKey == true && keyH.tutorialScreen == true){
            keyH.tutorialScreen = false;
            keyH.backKey = false;
        }
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(keyH.characterScreen == false && keyH.tutorialScreen == false){
            tPanel.paint(g);
        }
        if(keyH.characterScreen == true){
            cPanel.paint(g);
        }
        if(keyH.tutorialScreen == true){
            toPanel.paint(g);
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
