
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class BattlePanel {
    GamePanel gp;
    Image overlay;
    HealthAndEXP hXP;
    public BattlePanel(GamePanel gp){
        hXP = new HealthAndEXP();
        this.gp = gp;
        overlay = new ImageIcon(getClass().getResource("/Images/Battle Overlay.png")).getImage();
    }
    public void paint(Graphics g){
        g.drawImage(overlay,0,0,gp.screenWidth,gp.screenLength, null);
        //g.drawImage(hXP.temp, 0, 0,gp.screenWidth,gp.screenLength,null);
        g.drawImage(hXP.health[18], 24, 60,44*6,3*6,null);
        g.drawImage(hXP.stamina[8], 30,78,44*6,3*6,null);
    }
}
