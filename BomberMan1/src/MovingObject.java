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

public class MovingObject {
    private Integer xPos = 225;
    private Integer yPos = 220;
    private Integer width = 20;
    private Integer height = 40;

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

    public void move_up() {
        xPos = xPos - width;
        if (xPos < 0) {
            xPos = 0;
        }
    }

    public void move_down() {
        xPos = xPos - width;
        if (xPos < 0) {
            xPos = 0;
        }
    }

    public void draw_movingObj(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(xPos, yPos, width, height);
    }

}
