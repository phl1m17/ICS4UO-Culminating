import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class TitlePanel {
    GamePanel gp;

    public TitlePanel(GamePanel gp){
        this.gp=gp;
    }
    public void paint(Graphics g){
        // Title
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

        // Game Info
        g.setColor(Color.BLACK);
        g.setFont(gp.c.font3);
        String info1 = "Press Space to Start Game";
        String info2 = "Press T for Tutorial";
        metrics = g.getFontMetrics(gp.c.font3);

        g.drawString(info1, (gp.getWidth()-metrics.stringWidth(info1))/2, 280);
        g.drawString(info2, (gp.getWidth()-metrics.stringWidth(info2))/2, 350);

        //Credits
        g.setFont(gp.c.font4);
        g.drawString("Credits: Phil Clarence Manag and William Kim", 10,565);
    }
}

// CUSTOM FONT
//https://www.youtube.com/watch?v=43duJsYmhxQ&t=234s