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
public class Bomb extends Obstacle{
    Obstacle[][] obs;
    public int indexi;
    public int indexj;
    private int secound=3;
    public  final byte BreadytToFire=1;
    public  final byte BFired=0;
    public PlayGround gameMap;
    Timer timer;
    byte state;
    public void BombTimer_start(Obstacle[][] obs1 , PlayGround P){
        timer = new Timer();
        timer.schedule(new RemindTask(),secound*1000);
        this.obs=obs1;
        this.gameMap=P;
    }


    class RemindTask extends TimerTask {
        public void run() {
            System.out.println("Time's up!");
            bombـexplosion(88,obs);
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

    public void draw(PlayGround P , Graphics2D g){
        g.drawImage(this.Bomb_img, this.xPos, this.yPos, P);

    }

    public void bombـexplosion(int keyCode , Obstacle[][] obs){
       if(keyCode==88) {       //x


            if (this.state == BreadytToFire) {

                if (indexi < 13) {
                    if (obs[indexi + 1][indexj].getToFireAction()) {
                        obs[indexi + 1][indexj] = new Blank_c(obs[indexi + 1][indexj].getxPos(), obs[indexi + 1][indexj].getyPos());
                    }
                }
                if (indexi > 0) {
                    if (obs[indexi - 1][indexj].getToFireAction()) {
                        obs[indexi - 1][indexj] = new Blank_c(obs[indexi - 1][indexj].getxPos(), obs[indexi - 1][indexj].getyPos());
                    }
                }
                if (indexj < 13) {
                    if (obs[indexi][indexj + 1].getToFireAction()) {
                        obs[indexi][indexj + 1] = new Blank_c(obs[indexi][indexj + 1].getxPos(), obs[indexi][indexj + 1].getyPos());
                    }
                }
                if (indexj > 0) {
                    if (obs[indexi][indexj - 1].getToFireAction()) {
                        obs[indexi][indexj - 1] = new Blank_c(obs[indexi][indexj - 1].getxPos(), obs[indexi][indexj - 1].getyPos());
                    }
                }

                obs[indexi][indexj] = new Blank_c(obs[indexi][indexj].getxPos(), obs[indexi][indexj].getyPos());


            }
         state=BFired;
        }

    }

}
