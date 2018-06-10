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
public abstract class Obstacle extends JFrame{

    public Integer xPos;
    public Integer yPos ;
    private Integer lato = 30;
    public int width=50;
    public int height=50;

    public abstract int getID();
    public Integer getxPos() {
        return xPos;
    }
    public void setPos(int x, int y){
        this.yPos=y;
        this.xPos=x;
    }
    public Image img;
    public Integer getyPos() {
        return yPos;
    }

    public Integer getLato() {
        return lato;
    }

    public void setLato(Integer lato) {
        this.lato = lato;
    }


    abstract void   draw(PlayGround P , Graphics2D g);
}
