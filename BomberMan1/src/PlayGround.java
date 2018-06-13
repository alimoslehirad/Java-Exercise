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
public class PlayGround extends JFrame implements KeyListener {
    ObjectPool v =new ObjectPool();
    BomberMan p1 =new BomberMan("player1.png");
    BomberMan p2 =new BomberMan("player2.png");



    boolean initFlag=false;
    public void playGroung_make(){

        JPanel panel =new JPanel();




    }

    public PlayGround(String title) {

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 700, 700+v.y0);
        setVisible(true);
        playGroundMask_init(v.frameMask);




        addKeyListener(this);
        p2.indexi=0;
        p2.indexj=13;
        p2.rightKey=68;
        p2.leftKey=65;
        p2.downKey=83;
        p2.upKey=87;
        p2.bombingKey=81;
        initFlag=true;
        p1.setPos();
        p2.setPos();
        repaint();
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
                        v.obs[i][j].setPos(j*50,i*50+v.y0);

                    }
                    if(mask[i][j]==v.wallID){
                        v.obs[i][j]=new Wall_c();
                        v.obs[i][j].setPos(j*50,i*50+v.y0);
                        WallIndex++;
                    }
                    if(mask[i][j]==v.Blank){
                        v.obs[i][j]=new Blank_c(j*50,i*50+v.y0);


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
            p1.draw(g2 , this);
            p2.draw(g2,this);

        }

    }

    public void keyPressed(KeyEvent e) {
       p1.keyPressed1Act(e.getKeyCode(),v.obs,this);
       p2.keyPressed1Act(e.getKeyCode(),v.obs,this);
      // p1.b.bombـexplosion(e.getKeyCode(),v.obs);
     //  p2.b.bombـexplosion(e.getKeyCode(),v.obs);
        //System.out.println(e.getKeyCode());
        repaint();
    }
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }
}
