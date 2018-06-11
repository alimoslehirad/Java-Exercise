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
public class BomberMan extends MovingObject {

    private Integer width = 50;
    private Integer height = 50;
    Image bombermanCircle =Toolkit.getDefaultToolkit().getImage("circle.png");



    public void draw(PlayGround P , Graphics2D g){
        g.drawImage(this.bombermanCircle, xPos, yPos, P);

    }
}
