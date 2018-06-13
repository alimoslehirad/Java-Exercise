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
    public byte content;
    private int ID=0;
    public  int getID(){
        return this.ID;
    }
    public Blank_c(int x, int y){
        this.xPos=x;
        this.yPos=y;

    }
    @Override
    public void bombReaction(){

    }


    private Integer lato = 20;
    Image woodenBox_img = Toolkit.getDefaultToolkit().getImage("WoodenBox.png");
    @Override
    public boolean getToFireAction() {
        return false;
    }


    public void draw(PlayGround P , Graphics2D g){
        g.setColor(Color.WHITE);
        g.fillRect(xPos, yPos,50,50);

    }

}