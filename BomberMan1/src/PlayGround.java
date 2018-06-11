import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
//import java.util.Timer;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.JTextField;
import java.awt.geom.*;
public class PlayGround extends JFrame implements KeyListener{
    ObjectPool v =new ObjectPool();
    boolean initFlag=false;
    public void playGroung_make(){

        JPanel panel =new JPanel();




    }

    public PlayGround(String title) {

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 700, 730);
        setVisible(true);
        playGroundMask_init(v.frameMask);
        v.bombNum=0;
        addKeyListener(this);
        initFlag=true;
        repaint();



    }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == v.RightKey) {
            if(moveRight_permition(v.obs,v.p1)) {
                v.p1.move_right();

                repaint();
            }

        }
        else if(e.getKeyCode()==v.LeftKey){
            if(moveLeft_permition(v.obs,v.p1)) {
                v.p1.move_left();
                repaint();
            }
        }
        else if(e.getKeyCode()==v.DownKey){
            if(moveDown_permition(v.obs,v.p1)) {
                v.p1.move_down();
                repaint();
            }
        }
        else if(e.getKeyCode()==v.UpKey){
            if(moveUp_permition(v.obs,v.p1)) {
                v.p1.move_up();
                repaint();
            }
        }
        else if (e.getKeyCode()==66 && v.bombNum!=9){    // b


            v.b1[v.bombNum].xPos=v.p1.xPos;
            v.b1[v.bombNum].yPos=v.p1.yPos;
            v.b1[v.bombNum].indexi=v.p1.indexi;
            v.b1[v.bombNum].indexj=v.p1.indexj;

            v.b1[v.bombNum].state=v.BreadytToFire;
            v.obs[v.p1.indexi][v.p1.indexj]=v.b1[v.bombNum];

        }
        else if(e.getKeyCode()==88)   {       //x


            if(v.b1[v.bombNum].state==v.BreadytToFire){
                int indexi=v.b1[v.bombNum].indexi;
                int indexj=v.b1[v.bombNum].indexj;
               if(indexi<13){
                    if(v.obs[indexi+1][indexj].getToFireAction()) {
                        v.obs[indexi + 1][indexj] = new Blank_c(v.obs[indexi + 1][indexj].getxPos(), v.obs[indexi + 1][indexj].getyPos());
                    }
               }
                if(indexi>0) {
                    if (v.obs[indexi - 1][indexj].getToFireAction()) {
                        v.obs[indexi - 1][indexj] = new Blank_c(v.obs[indexi - 1][indexj].getxPos(), v.obs[indexi - 1][indexj].getyPos());
                    }
                }
                if(indexj<13) {
                    if (v.obs[indexi][indexj + 1].getToFireAction()) {
                        v.obs[indexi][indexj + 1] = new Blank_c(v.obs[indexi][indexj + 1].getxPos(), v.obs[indexi][indexj + 1].getyPos());
                    }
                }
                if(indexj>0) {
                    if (v.obs[indexi][indexj - 1].getToFireAction()) {
                        v.obs[indexi][indexj - 1] = new Blank_c(v.obs[indexi][indexj - 1].getxPos(), v.obs[indexi][indexj - 1].getyPos());
                    }
                }

                v.obs[v.b1[v.bombNum].indexi][v.b1[v.bombNum].indexj]  =new Blank_c(v.obs[v.b1[v.bombNum].indexi][v.b1[v.bombNum].indexj].getxPos(), v.obs[v.b1[v.bombNum].indexi][v.b1[v.bombNum].indexj].getyPos());
                repaint();

            }


        }
        //System.out.println(e.getKeyCode());
    }
    public void keyReleased(KeyEvent e) {

    }
    public void playGroundMask_init(int[][] mask){
        try {
             v.fileName = "PlayGroundMap.txt";
            FileReader fileReader = new FileReader(v.fileName);
            v.bufferedReader = new BufferedReader(fileReader);

        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            v.fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + v.fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }


        int BocCnt=0;


        BocCnt=0; boolean boxNum_flag=false; String[] strArray;int BoxIndex=0,WallIndex=28,BlankIndex=28+49;
        for(int i=0;i<14;i++) {
            try {
              String  line = v.bufferedReader.readLine();

                if (line == null) v.bufferedReader.close();
                strArray=line.split(" ");
//                System.out.println(i);
                for(int j=0;j<14;j++){
//                    System.out.println("j= "+j);
                    mask[i][j]=Integer.parseInt(strArray[j]);
                    if(mask[i][j]==v.BoxID){
                        v.obs[i][j]=new Box_c();
                        v.obs[i][j].setPos(j*50,i*50+30);

                    }
                     if(mask[i][j]==v.wallID){
                         v.obs[i][j]=new Wall_c();
                        v.obs[i][j].setPos(j*50,i*50+30);
                        WallIndex++;
                    }
                    if(mask[i][j]==v.Blank){
                        v.obs[i][j]=new Blank_c(j*50,i*50+30);


                    }

                }

            } catch (FileNotFoundException ex) {
                System.out.println(
                        "Unable to open file '" +
                                v.fileName + "'");
            } catch (IOException ex) {
                System.out.println(
                        "Error reading file '"
                                + v.fileName + "'");
                // Or we could just do this:
                // ex.printStackTrace();
            }

        }
       v.p1.indexi=0; v.p1.indexj=0;




    }
    public void keyTyped(KeyEvent e) {}
     public void keylistener( KeyEvent e){


    }
     public void paint(Graphics g) {
        if(initFlag) {
            Graphics2D g2 = (Graphics2D) g;
            for (int i = 0; i < 14; i++) {
                for(int j=0;j<14;j++) {
                    //System.out.println("graphic part i= "+ i);
                    v.obs[i][j].draw(this, g2);
                }

            }
            v.p1.draw(this,g2);

        }

    }

     public boolean moveRight_permition(Obstacle[][] d, MovingObject m){

         boolean permition=false;
         if(m.indexj!=13) {
             if (d[m.indexi][m.indexj + 1].getID() == v.Blank) {
                 permition = true;
             } else {
                 permition = false;
             }
         }

         return permition;
     }



    boolean  moveLeft_permition(Obstacle[][] d, MovingObject m){
        boolean permition=false;
        if(m.indexj!=0) {
            if (d[m.indexi][m.indexj - 1].getID() == v.Blank) {
                permition = true;
            } else {
                permition = false;
            }
        }

        return permition;

    }

    boolean  moveUp_permition(Obstacle[][] d, MovingObject m){
        boolean permition=false;
        if(m.indexi!=0) {
            if (d[m.indexi-1][m.indexj].getID() == v.Blank) {
                permition = true;
            } else {
                permition = false;
            }
        }

        return permition;
    }

    boolean  moveDown_permition(Obstacle[][] d, MovingObject m){
        boolean permition=false;
        if(m.indexi!=13) {
            if (d[m.indexi+1][m.indexj].getID() == v.Blank) {
                permition = true;
            } else {
                permition = false;
            }
        }

        return permition;
    }




}
