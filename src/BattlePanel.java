
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class BattlePanel {
    GamePanel gp;
    Image overlay;
    public BattlePanel(GamePanel gp){
        this.gp = gp;
        overlay = new ImageIcon(getClass().getResource("src/Images/Battle Overlay.png")).getImage();
    }
    public void paint(Graphics g){
        g.setColor(Color.yellow);
        g.fillRect(0, 0,gp.screenWidth, gp.screenLength);
        g.drawImage(overlay,0,0,gp.screenWidth,gp.screenLength, null);
    }
}
