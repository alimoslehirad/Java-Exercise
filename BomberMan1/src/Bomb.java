import javax.swing.*;
import java.awt.*;
import java.util.*;
//import java.util.Timer;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.*;
import javax.swing.JFrame;
//import javax.swing.Timer;
import javax.swing.JTextField;
import java.util.Timer;
import java.util.TimerTask;
public class Bomb extends Layer2{
    Obstacle[][] obs;
    Layer2[][] obs2;
    public int indexi;
    public int indexj;
    public int bombFlame;
    private int secound=3;
    public  final byte BreadytToFire=1;
    public  final byte BFired=0;
    public BomberMap gameMap;
    Timer timer;
    byte state;
    public Bomb(int x,int y){
        this.xPos=x;
        this.yPos=y;
        probability=.125;
    }
    public void BombTimer_start(Obstacle[][] obs1,Layer2[][] obs2 , BomberMap P){
        timer = new Timer();
        timer.schedule(new RemindTask(),secound*1000);
        this.obs=obs1;
        this.obs2=obs2;
        this.gameMap=P;
    }


    class RemindTask extends TimerTask {
        public void run() {
            System.out.println("Time's up!");
            bombـexplosion(88,obs,obs2);
            gameMap.repaint();
            timer.cancel(); //Terminate the timer thread
        }
    }
    public Image Bomb_img = Toolkit.getDefaultToolkit().getImage("Bomb.jpg");
    private int ID=5;
    public  int getID(){
        return this.ID;
    }
    @Override
    public void bombReaction(){
        changeToBlank_flag=true;
    }

    @Override
    public boolean getToFireAction() {
        return true;
    }

    public void draw(BomberMap P , Graphics2D g){
        g.drawImage(this.Bomb_img, this.xPos, this.yPos, P);

    }

    public void bombـexplosion(int keyCode , Obstacle[][] obs,Layer2[][] obs2){
       if(keyCode==88) {       //x


            if (this.state == BreadytToFire) {
                for (int k = 1; k <= bombFlame; k++) {
                    if (indexi < 13) {
                        if (obs[indexi + k][indexj].getToFireAction()) {
                            obs2[indexi + k][indexj] = obs[indexi + k][indexj].content;
                            obs[indexi + k][indexj]=new Blank_c( obs[indexi + k][indexj].getxPos(), obs[indexi + k][indexj].yPos);
                        }
                    }
                    if (indexi > 0) {
                        if (obs[indexi - k][indexj].getToFireAction()) {
                            obs2[indexi - k][indexj] =obs[indexi - k][indexj].content;
                            obs[indexi - k][indexj]=new Blank_c( obs[indexi - k][indexj].getxPos(), obs[indexi - k][indexj].yPos);

                        }
                    }
                    if (indexj < 13) {
                        if (obs[indexi][indexj + k].getToFireAction()) {
                            obs2[indexi][indexj + k] = obs[indexi][indexj + k].content;
                            obs[indexi ][indexj+ k]=new Blank_c( obs[indexi ][indexj+ k].getxPos(), obs[indexi ][indexj+ k].yPos);
                        }
                    }
                    if (indexj > 0) {
                        if (obs[indexi][indexj - k].getToFireAction()) {
                            obs2[indexi][indexj - k] = obs[indexi][indexj - k].content;
                            obs[indexi ][indexj- k]=new Blank_c( obs[indexi ][indexj- k].getxPos(), obs[indexi ][indexj- k].yPos);
                        }
                    }




                }
                obs2[indexi][indexj] = new BlankL2();
                state = BFired;
            }
        }

    }


}
