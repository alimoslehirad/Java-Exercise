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
    public int bombFlame;
    private int secound=3;
    public  final byte BreadytToFire=1;
    public  final byte BFired=0;
    public BomberMan[] player;
    public BomberMap gameMap;
    Timer timer;
    byte state;
    private boolean crossPermition=true;
    public boolean isCrossPermition(){
        return crossPermition;
    }
    public Bomb(int x,int y){
        this.xPos=x;
        this.yPos=y;
        probability=.125;

    }
    public void BombTimer_start(Obstacle[][] obs1,BomberMan[] player , BomberMap P){
        timer = new Timer();
        timer.schedule(new RemindTask(),secound*1000);
        this.obs=obs1;
        this.gameMap=P;
        this.player=player;
    }


    class RemindTask extends TimerTask {
        public void run() {
            System.out.println("Time's up!");
            bombـexplosion(88,obs,player);
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

    public void bombـexplosion(int keyCode , Obstacle[][] obs,BomberMan[] player){
       if(keyCode==88) {       //x


            if (this.state == BreadytToFire) {
                for (int k = 1; k <= bombFlame; k++) {
                    if (indexi < 13) {
                        if (obs[indexi + k][indexj].getToFireAction()) {
                            obs[indexi + k][indexj]=obs[indexi + k][indexj].content;
                        }
                        for(int i=0;i<4;i++){
                            if( (player[i].indexi==(indexi+k) ) && (player[i].indexj==indexj) ){
                                player[i].alive=false;
                            }

                        }
                    }
                    if (indexi > 0) {
                        if (obs[indexi - k][indexj].getToFireAction()) {
                            obs[indexi - k][indexj]=obs[indexi - k][indexj].content;

                        }
                        for(int i=0;i<4;i++){
                            if( (player[i].indexi==(indexi-k) ) && (player[i].indexj==indexj) ){
                                player[i].alive=false;
                            }

                        }
                    }
                    if (indexj < 13) {
                        if (obs[indexi][indexj + k].getToFireAction()) {
                            obs[indexi ][indexj+ k]= obs[indexi][indexj + k].content;
                        }
                        for(int i=0;i<4;i++){
                            if( (player[i].indexi==indexi) && (player[i].indexj==(indexj+k)) ){
                                player[i].alive=false;
                            }

                        }
                    }
                    if (indexj > 0) {
                        if (obs[indexi][indexj - k].getToFireAction()) {
                            obs[indexi ][indexj- k]=obs[indexi][indexj - k].content;
                        }
                        for(int i=0;i<4;i++){
                            if( (player[i].indexi==indexi) && (player[i].indexj==(indexj-k)) ){
                                player[i].alive=false;
                            }

                        }
                    }




                }
                obs[indexi][indexj] = new Blank_c(obs[indexi][indexj].xPos,obs[indexi][indexj].yPos);
                state = BFired;

            }
        }

    }


}
