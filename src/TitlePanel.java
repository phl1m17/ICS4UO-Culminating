import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

public class TitlePanel {
    GamePanel gp;
    Font font, font1;

    public TitlePanel(GamePanel gp){
        this.gp=gp;
    }
    public void paint(Graphics g){
        g.setColor(Color.green);
        g.fillRect(0, 0, gp.screenWidth, gp.screenLength);
        try{
            font = Font.createFont(Font.TRUETYPE_FONT, new File("src/Pokemon Solid.ttf")).deriveFont(50f);
            font1 = Font.createFont(Font.TRUETYPE_FONT, new File("src/Pokemon Hollow.ttf")).deriveFont(50f);
        }
        catch(FontFormatException | IOException e){

        }
        g.setFont(font);
        g.setColor(Color.BLUE);
        g.drawString("Pokemon Battle", gp.screenWidth/2-190, 80);
        g.setFont(font1);
        g.setColor(Color.YELLOW);
        g.drawString("Pokemon Battle", gp.screenWidth/2-190, 80);

    }
}

// CUSTOM FONT
//https://www.youtube.com/watch?v=43duJsYmhxQ&t=234s