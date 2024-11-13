
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BattlePanel implements ActionListener{
    GamePanel gp;
    Image overlay, healthPlayer, healthComputer, staminaPlayer, staminaComputer;
    Player player;
    Computer computer;
    JButton special, attack;
    HealthAndEXP hXP;

    int pHealthIndex = 0;
    int pStaminaIndex = 0;
    int cHealthIndex = 0;
    int cStaminaIndex = 0;
    int damage;
    int delay = 0;

    boolean playerTurn = true;

    public BattlePanel(GamePanel gp,Player player, Computer computer){
        hXP = new HealthAndEXP();
        this.gp = gp;
        this.player = player;
        this.computer = computer;
        overlay = new ImageIcon(getClass().getResource("/Images/Battle Overlay.png")).getImage();
        healthPlayer = hXP.health[pHealthIndex];
        staminaPlayer = hXP.stamina[pStaminaIndex];
        healthComputer = hXP.health[cHealthIndex];
        staminaComputer = hXP.stamina[cStaminaIndex];

        special = new JButton();
        attack = new JButton();

        special.setBounds(56,444,282,96);
        attack.setBounds(428,444,282,96);

        special.setOpaque(false);
        special.setContentAreaFilled(false);
        special.setBorderPainted(false);

        attack.setOpaque(false);
        attack.setContentAreaFilled(false);
        attack.setBorderPainted(false);

        special.addActionListener(this);
        attack.addActionListener(this);

        special.setFocusable(false);
        attack.setFocusable(false); 
    }
    public void paint(Graphics g){
        g.drawImage(overlay,0,0,gp.screenWidth,gp.screenLength, null);
        g.drawImage(healthPlayer, 24, 60,44*6,3*6,null);
        g.drawImage(staminaPlayer, 30,78,44*6,3*6,null);

        g.drawImage(healthComputer, 480, 324,44*6,3*6,null);
        g.drawImage(staminaComputer, 486,342,44*6,3*6,null);

        g.setColor(Color.BLACK);
        g.setFont(gp.c.font5);
        g.drawString(player.player, 30, 54);
        g.drawString(computer.computer, 486, 318);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(playerTurn){
            if(e.getSource() == special){
                damage = 10;
                pStaminaIndex += damage;
                cHealthIndex += damage;
                staminaPlayer = hXP.stamina[pStaminaIndex];
                healthComputer = hXP.health[cHealthIndex];
                playerTurn = false;
            }
            if(e.getSource() == attack){
                damage = 3;
                pStaminaIndex+=damage;
                cHealthIndex+=damage;
                staminaPlayer = hXP.stamina[pStaminaIndex];
                healthComputer = hXP.health[cHealthIndex];
                playerTurn = false;
            }
        }
        update();
    }
    public void update(){
        if(!playerTurn){
            delay++;
            if(delay == 20){
                if(randomInt() == 3){
                    damage = 10;
                    cStaminaIndex += damage;
                    pHealthIndex += damage;
                    staminaComputer = hXP.stamina[cStaminaIndex];
                    healthPlayer = hXP.health[pHealthIndex];
                    playerTurn = true;
                }
                else{
                    damage = 3;
                    cStaminaIndex += damage;
                    pHealthIndex += damage;
                    staminaComputer = hXP.stamina[cStaminaIndex];
                    healthPlayer = hXP.health[pHealthIndex];
                    playerTurn = true;
                }
                delay = 0;
            }
        }
    }
    public int randomInt(){
        return (int) (Math.random() * 5 + 1);
    }
}
// Invisible Buttons
// https://stackoverflow.com/questions/5654208/making-a-jbutton-invisible-but-clickable
