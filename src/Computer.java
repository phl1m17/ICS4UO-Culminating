
import java.awt.Color;
import java.awt.Graphics;

public class Computer {
    GamePanel gp;
    int choice;
    String computer;
    public Computer(GamePanel gp){
        this.gp=gp;
        choice = (int)(Math.random() * 3 + 1);
    }
    public void paint(Graphics g){
        switch (choice) {
            case 1:
                g.setColor(Color.red);
                computer = "Charizard";
                break;
            case 2:
                g.setColor(Color.cyan);
                computer = "Squirtle";
                break;
            case 3:
                g.setColor(Color.green);
                computer = "EarthDude";
                break;
        }
        g.fillRect(540, 90, 120, 120);
    }
}
