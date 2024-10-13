
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class TutorialPanel {
    GamePanel gp;
    public TutorialPanel(GamePanel gp){
        this.gp = gp;
    }
    public void paint(Graphics g){
        g.setColor(Color.green);
        g.fillRect(0, 0, gp.screenWidth, gp.screenLength);
        
        g.setFont(gp.c.font1);
        g.setColor(Color.BLUE);
        String title = "Pokemon Battle";
        FontMetrics metrics = g.getFontMetrics(gp.c.font1);
        g.drawString(title, (gp.getWidth()-metrics.stringWidth(title))/2, 120);

        g.setFont(gp.c.font2);
        g.setColor(Color.YELLOW);
        metrics = g.getFontMetrics(gp.c.font2);
        g.drawString(title, (gp.getWidth()-metrics.stringWidth(title))/2, 120);

        // Tutorial
        g.setColor(Color.BLACK);
        g.setFont(gp.c.font5);
        String info1 = "Beat the Opponent by doing"; 
        String info2 = "basic attacks or special attacks";
        String info3 = "special attacks take up more";
        String info4 = "energy so you have to be strategic";
        metrics = g.getFontMetrics(gp.c.font5);

        g.drawString(info1, (gp.getWidth()-metrics.stringWidth(info1))/2, 240);
        g.drawString(info2, (gp.getWidth()-metrics.stringWidth(info2))/2, 300);
        g.drawString(info3, (gp.getWidth()-metrics.stringWidth(info3))/2, 360);
        g.drawString(info4, (gp.getWidth()-metrics.stringWidth(info4))/2, 420);

        //Credits
        g.setFont(gp.c.font4);
        g.drawString("Credits: Phil Clarence Manag and William Kim", 10,565);
    }
}
