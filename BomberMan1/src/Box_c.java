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
    private int ID=2;
    public Box_c(){
        if(Math.random()>.95){
            this.content= 2;
        }
        else{
            this.content=1;
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