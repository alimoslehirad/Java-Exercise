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
public class Wall_c extends Obstacle {

    private Integer lato = 20;
    private int ID=3;
    public  int getID(){
        return this.ID;
    }

    public Image img = Toolkit.getDefaultToolkit().getImage("wall.png");


    public void draw(PlayGround P, Graphics2D g) {
        g.drawImage(this.img, yPos, xPos, P);

    }
}