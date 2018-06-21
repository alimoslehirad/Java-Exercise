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
public class BlankL2 extends Layer2 {

    private int ID=0;
    public int boxContent;
    public  int getID(){
        return this.ID;
    }

    @Override
    public void bombReaction(){

    }


    private Integer lato = 20;

    @Override
    public boolean getToFireAction() {
        return false;
    }


    public void draw(BomberMap P , Graphics2D g){

    }

}