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
        else if (e.getKeyCode()==66 && v.bombNum==9){    // b
            System.out.println("Bomb");

            v.frameMask[v.p1.xPos][v.p1.yPos] = v.BombID;

            v.b1[v.bombNum].xPos=v.p1.xPos;
            v.b1[v.bombNum].yPos=v.p1.yPos;
            v.b1[v.bombNum].state=v.BreadytToFire;
            //repaint();
        }
        else if(e.getKeyCode()==88)   {       //x


            if(v.b1[v.bombNum].state==v.BreadytToFire){
                if(v.frameMask[v.b1[v.bombNum].xPos+1][v.b1[v.bombNum].yPos]!=v.wallID){
                    v.frameMask[v.b1[v.bombNum].xPos+1][v.b1[v.bombNum].yPos]=v.Blank;
                }
                if(v.frameMask[v.b1[v.bombNum].xPos][v.b1[v.bombNum].yPos+1]!=v.wallID){
                    v.frameMask[v.b1[v.bombNum].xPos][v.b1[v.bombNum].yPos+1]=v.Blank;
                }
                if(v.frameMask[v.b1[v.bombNum].xPos-1][v.b1[v.bombNum].yPos]!=v.wallID){
                    v.frameMask[v.b1[v.bombNum].xPos-1][v.b1[v.bombNum].yPos]=v.Blank;
                }
                if(v.frameMask[v.b1[v.bombNum].xPos][v.b1[v.bombNum].yPos-1]!=v.wallID){
                    v.frameMask[v.b1[v.bombNum].xPos][v.b1[v.bombNum].yPos-1]=v.Blank;
                }
                v.frameMask[v.b1[v.bombNum].xPos][v.b1[v.bombNum].yPos]=v.Blank;
                v.b1[v.bombNum].state=v.BFired;
                v.bombNum++;
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
                System.out.println(i);
                for(int j=0;j<14;j++){
                    System.out.println("j= "+j);
                    mask[i][j]=Integer.parseInt(strArray[j]);
                    if(mask[i][j]==v.BoxID){
                        v.obs[i][j]=new Box_c();
                        v.obs[i][j].setPos(i*50+30,j*50);

                    }
                     if(mask[i][j]==v.wallID){
                         v.obs[i][j]=new Wall_c();
                        v.obs[i][j].setPos(i*50+30,j*50);
                        WallIndex++;
                    }
                    if(mask[i][j]==v.Blank){
                        v.obs[i][j]=new Blank_c();
                        v.obs[i][j].setPos(i*50+30,j*50);

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
       v.p1.setPos(0,30);




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
        Obstacle ob;
        boolean flag1=false,flag2=false;
        boolean permition=false;
        int indexi=0,indexj=0;
         for(int i=0; i<14;i++){
             for(int j=0;j<14;j++) {
                 if (((m.getxTopRight() + m.getStep()) >= d[i][j].xPos) && ((m.getxTopRight() + m.getStep()) <= (d[i][j].xPos + d[i][j].width)) && (m.getyTopRight() >= d[i][j].yPos) && (m.getyTopRight() <= (d[i][j].yPos + d[i][j].height))) {
                     if (d[i][j].getID() == v.Blank) {
                         permition = true;
                     }

                 }
                 if (((m.getxDownRight() + m.getStep()) >= d[i][j].xPos) && ((m.getxDownRight() + m.getStep()) <= (d[i][j].xPos + d[i][j].width)) && (m.getyDownRight() >= d[i][j].yPos) && (m.getyDownRight() <= (d[i][j].yPos + d[i][j].height))){
                     if (d[i][j].getID() == v.Blank) {
                         permition = true;
                     } else permition = false;


                 }
             }
         }

      return permition;
     }



    boolean  moveLeft_permition(Obstacle[][] d, MovingObject m){
        Obstacle b=new Blank_c();
        System.out.println(findAdjacent_left(d,m).getID());
        if(findAdjacent_left(d,m).getID()==v.Blank){
            return true;
        }
        else return false;
    }
    public Obstacle findAdjacent_left(Obstacle[][] d, MovingObject m){
        Obstacle ob;
        int indexi=0,indexj=0;
        indexj=(int)(m.xPos-m.getWidth())/50;

        for(int i=0;i<14;i++){
            if(m.yPos+m.getHeight()<=i*50+80) {indexi=i;break;}
        }

        System.out.println("index i= "+ indexi+"  index J= "+indexj);

        return d[indexi][indexj];
    }


    boolean  moveUp_permition(Obstacle[][] d, MovingObject m){
        Obstacle b=new Blank_c();
        System.out.println(findAdjacent_up(d,m).getID());
        if(findAdjacent_up(d,m).getID()==v.Blank){
            return true;
        }
        else return false;
    }
    public Obstacle findAdjacent_up(Obstacle[][] d, MovingObject m){
        Obstacle ob;
        int indexi=0,indexj=0;
        indexj=(int)(m.xPos+m.getWidth())/50;

        for(int i=0;i<14;i++){
            if(m.yPos+m.getHeight()/2<=i*50) {indexi=i;break;}
        }

        System.out.println("index i= "+ indexi+"  index J= "+indexj);

        return d[indexi][indexj];
    }


    boolean  moveDown_permition(Obstacle[][] d, MovingObject m){
        Obstacle b=new Blank_c();
        System.out.println(findAdjacent_down(d,m).getID());
        if(findAdjacent_down(d,m).getID()==v.Blank){
            return true;
        }
        else return false;
    }
    public Obstacle findAdjacent_down(Obstacle[][] d, MovingObject m){
        Obstacle ob;
        int indexi=0,indexj=0;
        indexj=(int)(m.xPos+m.getWidth())/50;

        for(int i=0;i<14;i++){
            if(m.yPos+m.getHeight()<=i*50+80) {indexi=i;break;}
        }

        System.out.println("index i= "+ indexi+"  index J= "+indexj);

        return d[indexi][indexj];
    }



}
