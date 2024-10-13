
import javax.swing.JFrame;

public class Main extends JFrame{
    Main(){
        GamePanel gp = new GamePanel();
        add(gp);
        pack();

        gp.startGameThread();
        
        setTitle("Pokemon Game");
        setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setVisible(true);
    }
    public static void main(String[] args) {
        new Main();
    }
}
