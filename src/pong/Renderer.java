package pong;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;


public class Renderer extends JPanel {
    @Override
    protected void paintComponent(Graphics g){
        //super.paintComponent(g);
     Pong.pong.render(g);
    }
}
