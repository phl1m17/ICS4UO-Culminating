
import java.awt.Color;
import java.awt.Graphics;

public class Player {
    GamePanel gp;
    String choice;
    public Player(GamePanel gp){
        this.gp = gp;
    }
    public void paint(Graphics g){
        g.setColor(Color.yellow);
        g.fillRect(0, 0,gp.screenWidth, gp.screenLength);
        switch (choice) {
            case "fire":
                g.setColor(Color.red);
                break;
            case "water":
                g.setColor(Color.cyan);
                break;
            case "earth":
                g.setColor(Color.green);
                break;
        }
        g.fillRect(100, 200, 200, 400);
    }
}
