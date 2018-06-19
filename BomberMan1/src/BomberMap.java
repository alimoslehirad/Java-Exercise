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
public class BomberMap extends JFrame implements KeyListener {
    ObjectPool v =new ObjectPool();
    //    BomberMan p1 =new BomberMan("player1.png");
//    BomberMan p2 =new BomberMan("player2.png");
    BomberMan[] player = new BomberMan[4];
    GameController g =new GameController();


    boolean initFlag=false;
    public void playGroung_make(){

        JPanel panel =new JPanel();




    }

    public BomberMap(String title) {

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 700, 700+v.y0);
        setVisible(true);
        BomberMapMask_init(v.frameMask);
        addKeyListener(this);
        player[0]=new BomberMan("player1.png",0,0);
        player[1]=new BomberMan("player2.png",0,13);
        player[2]=new BomberMan("player1.png",13,0);
        player[3]=new BomberMan("player1.png",13,13);
        for(int i=0;i<4;i++){
            player[i].setPosition();
        }



        initFlag=true;
        repaint();
    }

    public void BomberMapMask_init(int[][] mask){
        try {
            v.fileName = "BomberMap.txt";
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
                        v.obs[i][j]=new Blank_c(j*50,i*50+v.y0,1);


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
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 700, 730);
            for (int i = 0; i < 14; i++) {
                for(int j=0;j<14;j++) {
                    //System.out.println("graphic part i= "+ i);
                    v.obs[i][j].draw(this, g2);
                }

            }
            for(int i=0;i<4;i++) {
                player[i].draw(g2, this);
            }

        }

    }

    public void keyPressed(KeyEvent e) {
        g.keyPressedAct(e.getKeyCode(),v.obs,this);
        repaint();
    }
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }
}