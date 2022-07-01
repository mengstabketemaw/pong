package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class ball {

public static int x,y;
public int motionX,motionY,speed=0;    
Random s;
public ball(){
   s= new Random(); 
 restart();
}
public void update(paddle player1,paddle player2){
    if(x<250){
   if(checkColl(player1,player2)==1)
   {
       motionX=7+ ++speed/2;
       motionY=-2+s.nextInt(10);
   }
    }
    else{
if(checkColl(player1,player2)==1)
   {
       motionX= (-7) - (++speed/2);
       motionY=s.nextInt(10)* (int)Math.pow(-1, s.nextInt(10));
       
   } }
   
   if(checkColl(player1,player2)==3){
       motionY=(-1) * motionY;
   }
    x+=motionX;
    y+=motionY;
}
public int checkColl(paddle sd,paddle sd2){
    if((x<45)){//player 1 paddle place
    
    if((sd.y<y+11&&sd.y+102>y))
        return 1;//hit
    else
    {
    speed=2;
    sd2.score++;
    restart();    
    return 2;//wall
    }
    }
    
    else if((x>685)){ //player 2 paddle place
        
    if((sd2.y<y+11 && sd2.y+102>y))
        return 1;//hit
    else
    {
    speed=2;
    sd.score++;
    restart();
    return 2;//wall
    }
    }
        
    if(y>450 ||y<0)
     return 3;
     return 0; //miss
        
    }

public void render(Graphics s){
    s.setColor(Color.WHITE);
    s.fillOval(x, y, 20, 20);
}

 private void restart() {
   x=750/2-10;
   y=500/2-30;
   motionY=s.nextInt(4)*(int)Math.pow((-1),s.nextInt(4));

   if(s.nextBoolean())
   {
       motionX=4;
   }
   else
       motionX=-4;       
    }
    
}
