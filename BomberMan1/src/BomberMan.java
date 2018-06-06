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
    public Integer xPos = 1;
    public Integer yPos = 1;
    private Integer width = 20;
    private Integer height = 40;
    Image bombermanCircle =Toolkit.getDefaultToolkit().getImage("circle.png");

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

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void move_right() {
        if (xPos < 420)
            xPos = xPos + width;
    }

    public void move_left() {
        xPos = xPos - width;
        if (xPos < 0) {
            xPos = 0;
        }
    }
    public void moveRight(Graphics g){
        xPos += 50;
        draw_car(g);
    }
    public void draw_car(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(xPos, yPos, width, height);
    }
}
