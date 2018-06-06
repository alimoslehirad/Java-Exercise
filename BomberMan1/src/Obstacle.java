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
public abstract class Obstacle {

    private Integer xPos;
    private Integer yPos = 100;
    private Integer lato = 30;

    public Integer getxPos() {
        return xPos;
    }

    public void setxPos(Integer xPos) {
        this.xPos = xPos;
    }

    public Integer getyPos() {
        return yPos;
    }

    public void setyPos(Integer yPos) {
        this.yPos = yPos;
    }

    public Integer getLato() {
        return lato;
    }

    public void setLato(Integer lato) {
        this.lato = lato;
    }

    /*public Obstacle(Integer xPos) {
        super();
        this.xPos = xPos;
    } */


    abstract void   draw(PlayGround P , Graphics2D g);
}
