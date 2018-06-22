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
    public boolean alive;
    public int bombingFlame;

    Bomb b;
    ObjectPool v=new ObjectPool();

    Image bombermanCircle ;
    public BomberMan(String s , int indexi, int indexj){

        this.indexi=indexi;
        this.indexj=indexj;
        bombingFlame=1;
        alive=true;
        bombermanCircle=Toolkit.getDefaultToolkit().getImage(s);

    }
    public boolean isAlive(){
        return alive;
    }
    public void setPosition(){
        xPos=indexj*50;
        yPos=indexi*50+30;
    }


   


    public void react(int cmd,Obstacle[][] obs,BomberMan[] player, BomberMap P) {
        if (cmd == 0) {
            move_up();
            if (obs[indexi][indexj].getID() == 10) {
                bombingFlame = 2;
                obs[indexi][indexj] = new Blank_c(obs[indexi][indexj].getxPos(), obs[indexi][indexj].getyPos());
            }
        } else if (cmd == 1) {
            move_down();
            if (obs[indexi][indexj].getID() == 10) {
                bombingFlame = 2;
                obs[indexi][indexj] = new Blank_c(obs[indexi][indexj].getxPos(), obs[indexi][indexj].getyPos());
            }
        } else if (cmd == 2) {
            move_left();
            if (obs[indexi][indexj].getID() == 10) {
                bombingFlame = 2;
                obs[indexi][indexj] = new Blank_c(obs[indexi][indexj].getxPos(), obs[indexi][indexj].getyPos());
            }
        } else if (cmd == 3) {
            move_right();
            if (obs[indexi][indexj].getID() == 10) {
                bombingFlame = 2;
                obs[indexi][indexj] = new Blank_c(obs[indexi][indexj].getxPos(), obs[indexi][indexj].getyPos());
            }
        } else if (cmd == 4) {
            bombing(obs,player, P);

        }

    }


    public void bombing(Obstacle[][] obs,BomberMan[] player, BomberMap P){
        b=new Bomb(this.xPos,this.yPos);
        b.indexi=indexi;
        b.indexj=indexj;
        b.bombFlame=bombingFlame;
        b.state=v.BreadytToFire;
        obs[indexi][indexj]=b;
        b.BombTimer_start(obs,player,P);
    }






    public void draw( Graphics2D g , BomberMap P){
        g.drawImage(this.bombermanCircle, xPos, yPos, P);

    }
}
