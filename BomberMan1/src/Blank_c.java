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
    private boolean crossPermition=true;
    public boolean isCrossPermition(){
        return crossPermition;
    }
    public  int getID(){
        return this.ID;
    }
    public Blank_c(int x, int y ){
        this.xPos=x;
        this.yPos=y;
       probability=.5;
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

            g.setColor(Color.WHITE);
            g.fillRect(xPos, yPos, 50, 50);

    }

}