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

    private Integer lato = 20;
    Image woodenBox_img = Toolkit.getDefaultToolkit().getImage("WoodenBox.png");


    public void draw(PlayGround P , Graphics2D g){
        g.setColor(Color.WHITE);
        g.fillRect(yPos, xPos,50,50);

    }

}