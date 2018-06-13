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

    public void bombing(){

    }
    public BomberMan(String s){

        indexi=0; indexj=0;
        repaint();
        rightKey=39;
        leftKey=37;
        upKey=38;
        downKey=40;
        bombingKey=10;
        bombermanCircle=Toolkit.getDefaultToolkit().getImage(s);

    }
    public void setPos(){
        xPos=indexj*50;
        yPos=indexi*50+30;
    }

    public void keyPressed1Act(int KeyCode , Obstacle[][] obs,PlayGround P) {
        if (KeyCode ==rightKey) {
            if(moveRight_permition(obs,this)) {
                move_right();
                System.out.println("right");
                repaint();
            }

        }
        else if(KeyCode==leftKey){
            if(moveLeft_permition(obs,this)) {
                move_left();

            }
        }
        else if(KeyCode==downKey){
            if(moveDown_permition(obs,this)) {
                move_down();

            }
        }
        else if(KeyCode==upKey){
            if(moveUp_permition(obs,this)) {
                move_up();

            }
        }
        else if (KeyCode==bombingKey ){
            bombing(obs,P);


        }

        //System.out.println(e.getKeyCode());
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
    public boolean moveRight_permition(Obstacle[][] d, MovingObject m){

        boolean permition=false;
        if(m.indexj!=13) {
            if (d[m.indexi][m.indexj + 1].getID() == v.Blank) {
                permition = true;
            } else {
                permition = false;
            }
        }

        return permition;
    }



    boolean  moveLeft_permition(Obstacle[][] d, MovingObject m){
        boolean permition=false;
        if(m.indexj!=0) {
            if (d[m.indexi][m.indexj - 1].getID() == v.Blank) {
                permition = true;
            } else {
                permition = false;
            }
        }

        return permition;

    }

    boolean  moveUp_permition(Obstacle[][] d, MovingObject m){
        boolean permition=false;
        if(m.indexi!=0) {
            if (d[m.indexi-1][m.indexj].getID() == v.Blank) {
                permition = true;
            } else {
                permition = false;
            }
        }

        return permition;
    }

    boolean  moveDown_permition(Obstacle[][] d, MovingObject m){
        boolean permition=false;
        if(m.indexi!=13) {
            if (d[m.indexi+1][m.indexj].getID() == v.Blank) {
                permition = true;
            } else {
                permition = false;
            }
        }

        return permition;
    }




    public void draw( Graphics2D g , PlayGround P){
        g.drawImage(this.bombermanCircle, xPos, yPos, P);

    }
}
