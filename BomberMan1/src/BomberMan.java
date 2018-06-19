import javax.swing.*;
import java.awt.*;
import java.util.*;
//import java.util.Timer;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.JTextField;
public class BomberMan extends MovingObject  {

    private Integer width = 50;
    private Integer height = 50;
    public int rightKey;
    public int leftKey;
    public int upKey;
    public int downKey;
    public int bombingKey;
    public int bombingFlame;

    Bomb b;
    ObjectPool v=new ObjectPool();

    Image bombermanCircle ;
    public BomberMan(String s , int indexi, int indexj){

        this.indexi=indexi;
        this.indexj=indexj;
        bombingFlame=1;
        bombermanCircle=Toolkit.getDefaultToolkit().getImage(s);

    }

    public void setPosition(){
        xPos=indexj*50;
        yPos=indexi*50+30;
    }


   


    public void react(int cmd,Obstacle[][] obs, BomberMap P){
        if(cmd==0){
            move_up();
            if(obs[indexi][indexj].content==2) {
                bombingFlame=2;
                obs[indexi][indexj].content=1;
            }
        }
        else if(cmd==1){
            move_down();
            if(obs[indexi][indexj].content==2) {
                bombingFlame=2;
                obs[indexi][indexj].content=1;
            }
        }
        else if(cmd==2){
            move_left();
            if(obs[indexi][indexj].content==2) {
                bombingFlame=2;
                obs[indexi][indexj].content=1;
            }
        }
        else if(cmd==3){
            move_right();
            if(obs[indexi][indexj].content==2) {
                bombingFlame=2;
                obs[indexi][indexj].content=1;
            }
        }
        else if(cmd==4){
            bombing(obs,P);
            if(obs[indexi][indexj].content==2) {
                bombingFlame=2;
                obs[indexi][indexj].content=1;
            }
        }

    }


    public void bombing(Obstacle[][] obs, BomberMap P){
        b=new Bomb();
        b.xPos=this.xPos;
        b.yPos=this.yPos;
        b.indexi=indexi;
        b.indexj=indexj;
        b.bombFlame=bombingFlame;
        b.state=v.BreadytToFire;
        obs[indexi][indexj]=b;
        b.BombTimer_start(obs,P);
    }






    public void draw( Graphics2D g , BomberMap P){
        g.drawImage(this.bombermanCircle, xPos, yPos, P);

    }
}
