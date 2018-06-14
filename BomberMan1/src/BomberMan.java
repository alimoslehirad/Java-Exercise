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


    Bomb b=new Bomb();
    ObjectPool v=new ObjectPool();

    Image bombermanCircle ;
    public BomberMan(String s , int indexi, int indexj){

        this.indexi=indexi;
        this.indexj=indexj;

        bombermanCircle=Toolkit.getDefaultToolkit().getImage(s);

    }

    public void setPosition(){
        xPos=indexj*50;
        yPos=indexi*50+30;
    }


   


    public void react(int cmd,Obstacle[][] obs, PlayGround P){
        if(cmd==0){
            move_up();
        }
        else if(cmd==1){
            move_down();
        }
        else if(cmd==2){
            move_left();
        }
        else if(cmd==3){
            move_right();
        }
        else if(cmd==4){
            bombing(obs,P);
        }

    }


    public void bombing(Obstacle[][] obs, PlayGround P){
        b.xPos=this.xPos;
        b.yPos=this.yPos;
        b.indexi=indexi;
        b.indexj=indexj;
        b.state=v.BreadytToFire;
        obs[indexi][indexj]=b;
        b.BombTimer_start(obs,P);
    }






    public void draw( Graphics2D g , PlayGround P){
        g.drawImage(this.bombermanCircle, xPos, yPos, P);

    }
}
