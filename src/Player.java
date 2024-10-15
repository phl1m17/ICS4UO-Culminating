
import java.awt.Color;
import java.awt.Graphics;

public class Player {
    GamePanel gp;
    String choice;
    String player;
    public Player(GamePanel gp){
        this.gp = gp;
    }
    public void paint(Graphics g){
        g.setColor(Color.yellow);
        g.fillRect(0, 0,gp.screenWidth, gp.screenLength);
        switch (choice) {
            case "fire":
                g.setColor(Color.red);
                player = "Charizard";
                break;
            case "water":
                g.setColor(Color.cyan);
                player = "Squirtle";
                break;
            case "earth":
                g.setColor(Color.green);
                player = "EarthDude";
                break;
        }
        g.fillRect(96, 240, 120, 120);
    }
}
