
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

public class Constants {
    Font font1, font2, font3, font4, font5;
    public Constants(){
        try{
            font1 = Font.createFont(Font.TRUETYPE_FONT, new File("src/Pokemon Solid.ttf")).deriveFont(80f);
            font2 = Font.createFont(Font.TRUETYPE_FONT, new File("src/Pokemon Hollow.ttf")).deriveFont(80f);
        }
        catch(FontFormatException | IOException e){
        }
        font3 = new Font("Courier",Font.BOLD,30);
        font4 = new Font("Courier",Font.PLAIN,15);
        font5 = new Font("Courier",Font.PLAIN,25);
    }
}
