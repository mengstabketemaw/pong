package pong;
//all imports

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.Timer;

//main classs

public class Pong implements ActionListener,KeyListener {
//variable diclaration
    
public Renderer renderer;
public JFrame frame;
public static Pong pong;
public paddle player1;
public paddle player2; 
public boolean w,s,up,down;
public ball ball;
public static int gameStatus=0;
private boolean gamepause1=false;
private boolean gamepause2=false;
//constructure

public Pong(){
Timer timer = new Timer(20,this);
frame = new JFrame("pong");
renderer = new Renderer();

frame.setSize(750,500);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.add(renderer);
frame.setLocationRelativeTo(null);
frame.addKeyListener(this);
frame.setVisible(true);
ball = new ball();
start();
timer.start();
}

//main method
public static void main(String[] args) {
    pong = new Pong(); 
    System.out.println("--------------------");

}

//rendere
public void render(Graphics g) {
g.setColor(Color.black);
g.fillRect(0, 0, 750, 500);

if(gameStatus==0){
    g.setColor(Color.WHITE);
    
    g.setFont(new Font("Arial",0,50));
    g.drawString("PONG",300,70);
    
    g.setFont(new Font("Arial",0,30));
    g.drawString("press space to start with muliplayer",150,120);
    
    g.setFont(new Font("Arial",0,30));
    g.drawString("press shift to start with bot",150,150);
}

if(gameStatus==2||gameStatus==1){
    g.setColor(Color.white);
    g.drawLine(750/2, 0, 750/2, 500);
    g.drawOval(325, 180,100, 100);
    
    player1.render(g);
    player2.render(g);
    ball.render(g);
    
    g.setFont(new Font("Arial",0,20));
    g.drawString("Player1=:" + player1.score,30,25);
    g.drawString("Player2=:" + player2.score,645,25);
    
}

if(gameStatus==1){
    g.setColor(Color.WHITE);
    g.setFont(new Font("Arial",0,30));
    g.drawString("PAUSED",330,120);
}
if(gameStatus==15){
    g.setColor(Color.WHITE);
    g.setFont(new Font("ari",0,20));
if(    player1.score>player2.score)
  g.drawString("player 2 WIN!!!!player 3 is looser press space to continue",50,200);
else
  g.drawString("player 1 WIN!!!!player 3 is looser press space to continue",50,200);
    player1.score=0;
    player2.score=0;
}

}

public void actionPerformed(ActionEvent e) {
if(gameStatus==2){
update();
}
if(player1.score==7||player2.score==7&&!gamepause2)
{
    gameStatus=15;
}

if(player1.bot){
        player1.move(true);
    }
renderer.repaint();
}

//update
public void update() {
    
   if(!player1.bot){ if(w){
        player1.move(true);
    }
    if(s){
        player1.move(false);
    } }
   
    if(up){
        player2.move(true);
    }
    if(down){
        player2.move(false);
    } 
    
    ball.update(player1, player2);
    
}

//start
public void start(){
    player1 = new paddle(1);
    player2 = new paddle(2);    
}

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int id = e.getKeyCode();
        if(!player1.bot){
        if(id==KeyEvent.VK_W)
        {
            w=true;
        }
        if(id==KeyEvent.VK_S)
        {
            s=true;
        }}
        if(id==KeyEvent.VK_UP)
        {
            up=true;
        }
        if(id==KeyEvent.VK_DOWN)
        {
            down=true;
        }
        if(id==KeyEvent.VK_DOWN)
        {
            down=true;
        }
        if(id==KeyEvent.VK_SHIFT)
        {
            if(gameStatus==0){
            player1.bot = true;
            gameStatus=2;
            }
        }
        if(id==KeyEvent.VK_SPACE)
        {
            if(gameStatus==0){
            player1.bot = false;
            gameStatus=2;
            }
            else if(gameStatus==2){
            gameStatus=1 ;
            }
            else if(gameStatus==1){
            gameStatus=2 ;
            }
            if(gameStatus==15){
             gamepause2=true;
             gameStatus=0;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int id = e.getKeyCode();

        if(id==KeyEvent.VK_W)
        {
            w=false;
        }
        if(id==KeyEvent.VK_S)
        {
            s=false;
        }
        if(id==KeyEvent.VK_UP)
        {
            up=false;
        }
        if(id==KeyEvent.VK_DOWN)
        {
            down=false;
        }
    }
}
    

