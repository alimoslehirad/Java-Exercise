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
    public Integer xPos;
    public Integer yPos = -20;
    private Integer lato = 20;

    public Image wall_img = Toolkit.getDefaultToolkit().getImage("wall.png");


    public void draw(PlayGround P, Graphics2D g) {
        g.drawImage(this.wall_img, yPos, xPos, P);

    }
}