
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class CharacterPanel implements ActionListener{
    GamePanel gp;
    JButton fire, water, earth;
    //boolean startGame;
    public CharacterPanel(GamePanel gp){
        this.gp=gp;
        gp.setLayout(null);

        fire = new JButton();
        water = new JButton();
        earth = new JButton();

        fire.setBounds(100,100,50,50);
        water.setBounds(200,100,50,50);
        earth.setBounds(300,100,50,50);

        // fire.addActionListener(this);
        // water.addActionListener(this);
        // earth.addActionListener(this);

        // gp.add(fire);
        // gp.add(water);
        // gp.add(earth);
    }
    public void paint(Graphics g){
        g.setColor(Color.blue);
        g.fillRect(0, 0, gp.screenWidth, gp.screenLength);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == fire || e.getSource() == water || e.getSource() == earth){
            gp.keyH.characterScreen = false;
        }
    }
}
