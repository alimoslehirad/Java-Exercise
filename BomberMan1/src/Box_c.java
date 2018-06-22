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
public class Box_c extends Obstacle {
    //public int content;
    private boolean crossPermition=false;
    Bomb b;
    double rand;
    public boolean isCrossPermition(){
        return crossPermition;
    }
    public Obstacle[] con;
    private int ID=2;
    public Box_c(int x, int y){

        con=new Obstacle[4];

        this.xPos=x;
        this.yPos=y;

        con[0]=new Well_c(this.xPos,this.yPos);
        con[1]=new Bomb(this.xPos,this.yPos);
        con[2]=new Flame(this.xPos,this.yPos);
        con[3]=new Blank_c(this.xPos,this.yPos);
        rand=Math.random();
        System.out.println(rand);
        double sum=0;
        for(int i=0;i<4;i++) {
            sum+=con[i].probability;
            if (rand <sum){
                this.content=con[i];
                break;
            }
        }


    }
    @Override
    public void bombReaction(){
        changeToBlank_flag=true;
    }

    @Override
    public boolean getToFireAction() {
        return true;
    }
    @Override
    public  int getID(){
        return this.ID;
    }

    private Integer lato = 20;
    public Image img = Toolkit.getDefaultToolkit().getImage("WoodenBox.png");

    @Override
    public void draw(BomberMap P , Graphics2D g){
    g.drawImage(this.img, xPos, yPos, P);

    }

}