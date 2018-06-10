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

public abstract class MovingObject extends JFrame {
    public Integer xPos;
    public Integer yPos ;
    public int width = 50;
    public int height = 50;
    public int speed=1;


    public Integer getxPos() {
        return xPos;
    }
    public int getxTopLeft(){
        return this.xPos;
    }
    public int getxTopRight(){
        return this.xPos+this.width;
    }
    public int getxDownLeft(){
        return this.xPos;
    }
    public int getxDownRight(){
        return this.xPos+this.width;
    }
    public int getyDownRight(){return this.yPos+this.height;}
    public int getyTopRight(){return this.yPos;}

    public  boolean colisioncheck(int x , int y ){
        return true;
    }


    public Integer getyPos() {
        return yPos;
    }

    public void setPos(int x, int y){
        this.yPos=y;
        this.xPos=x;
    }

    public int getWidth() {
        return width;
    }
    public int getStep(){
        return this.speed*this.width/2;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void move_right() {

        xPos = xPos + getStep();
    }

    public void move_left() {
        xPos = xPos - getStep();
        if (xPos < 0) {
            xPos = 0;
        }
    }

    public void move_up() {
        yPos = yPos - getStep();
        if (yPos < 0) {
            yPos = 0;
        }
    }

    public void move_down() {
        yPos = yPos + getStep();

    }

    abstract void   draw(PlayGround P , Graphics2D g);

}
