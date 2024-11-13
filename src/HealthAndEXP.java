
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public final class HealthAndEXP {
    BufferedImage[]health;
    BufferedImage[]stamina;
    BufferedImage temp;
    public HealthAndEXP(){
        int y = 0;
        int y2 = 0;
        try {
            temp = ImageIO.read(getClass().getResourceAsStream("/Images/Health and XP.png"));
            health = new BufferedImage[23];
            for(int i = 0;i<health.length;i++){
                health[i] = temp.getSubimage(0,y*6,270,18);
                y+=4;
            }
            stamina = new BufferedImage[22];
            for(int i = 0;i<stamina.length;i++){
                stamina[i] = temp.getSubimage(50*6,y2*6,246,18);
                y2+=4;
            }
        } catch (IOException e) {}
    }
}
//SpriteSheet 
// https://stackoverflow.com/questions/9183617/isolating-sprite-sheet-subimages-for-animation-and-display