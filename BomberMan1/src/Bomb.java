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
public class Bomb extends Obstacle{

    public int indexi;
    public int indexj;
    byte state;
    public Image Bomb_img = Toolkit.getDefaultToolkit().getImage("Bomb.jpg");
    private int ID=5;
    public  int getID(){
        return this.ID;
    }


    @Override
    public boolean getToFireAction() {
        return true;
    }

    public void draw(PlayGround P , Graphics2D g){
        g.drawImage(this.Bomb_img, this.xPos, this.yPos, P);

    }

}
