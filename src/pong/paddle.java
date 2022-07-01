package pong;

import java.awt.Color;
import java.awt.Graphics;

public class paddle {
public int x,y;
public int paddlenumber;
public int score;
public boolean bot = false;
public paddle(int xy){
    paddlenumber = xy;
    if(paddlenumber==1){
        x=20;
    }
    if(paddlenumber==2){
        x=750-40;
    }
    y=150;
}

public void render(Graphics g){
    g.setColor(Color.white);
    g.fillRect(x, y, 20,100 );
}

public void move(boolean b) {

if(bot){
    
    if(y+50>ball.y&&y>10)
        y-=3;
    else if(y+100<480)
        y+=3;
}
else{
    
    if(b){
    
    if((y)>0)
        y-=3;
    
}else{
    
   if((y)<370)
       y+=4;
}

}
}

    
}
