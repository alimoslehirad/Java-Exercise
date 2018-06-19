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
public class Blank_c extends Obstacle {

    private int ID=0;
    public int boxContent;
    public  int getID(){
        return this.ID;
    }
    public Blank_c(int x, int y , int content){
        this.xPos=x;
        this.yPos=y;
        this.content=content;
    }
    public Blank_c(){

    }
    @Override
    public void bombReaction(){

    }


    private Integer lato = 20;

    @Override
    public boolean getToFireAction() {
        return false;
    }

    Image img = Toolkit.getDefaultToolkit().getImage("flame.png");
    public void draw(BomberMap P , Graphics2D g){
        if(content==1) {
            g.setColor(Color.WHITE);
            g.fillRect(xPos, yPos, 50, 50);
        }
        if(content==2){
            g.drawImage(this.img, xPos, yPos, P);
        }

    }

}