package BomberGame;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import java.util.Timer;
import java.util.TimerTask;

public class BomberMap extends JFrame implements KeyListener {
    ObjectPool v =new ObjectPool();

    BomberMan[] player = new BomberMan[4];
    GameController g =new GameController();
    Timer timer,timer1;
    public int well_cnt;

    boolean initFlag=false;
    public void playGroung_make(){
        JPanel panel =new JPanel();
    }

    public BomberMap(String title , int x, int y) {

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, x*50, y*50+30);
        setVisible(true);
        BomberMapMask_init(v.frameMask);
        addKeyListener(this);
        player[0]=new BomberMan("pics/player1.png",0,0);
        player[1]=new BomberMan("pics/player2.png",0,13);
        player[2]=new BomberMan("pics/player1.png",13,0);
        player[3]=new BomberMan("pics/player1.png",13,13);
        for(int i=0;i<4;i++){
            player[i].setPosition();
        }


        initFlag=true;
        repaint();
        timer = new Timer();
        timer.schedule(new RemindTask(),160*1000);
        well_cnt=0;
    }
    class RemindTask extends TimerTask {
        public void run() {
            System.out.println("Game Time's up!");
            wellGenerator();
            timer.cancel(); //Terminate the timer thread
        }
    }

    class RemindTask2 extends TimerTask {
        public void run() {
            System.out.println("Well generator Time's up!");
            if(well_cnt<50) {
                wellGenerator();
            }
            else {
                timer1.cancel(); //Terminate the timer thread
            }
        }
    }
    public void wellGenerator(){
        timer1 = new Timer();
        timer1.schedule(new RemindTask2(),3*1000);
        int indexi=(int)(Math.random()*13);
        int indexj=(int)(Math.random()*13);
        v.obs[indexi][indexj]=new Well_c( v.obs[indexi][indexj].xPos, v.obs[indexi][indexj].yPos);
        well_cnt++;
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
                        v.obs[i][j]=new Box_c(j*50,i*50+v.y0);

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
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 700, 730);
            for (int i = 0; i < 14; i++) {
                for(int j=0;j<14;j++) {
                    //System.out.println("graphic part i= "+ i);
                    v.obs[i][j].draw(this, g2);
                }

            }
//            for (int i = 0; i < 14; i++) {
//                for(int j=0;j<14;j++) {
//                    //System.out.println("graphic part i= "+ i);
//                    v.obs2[i][j].draw(this, g2);
//                }
//
//            }
            for(int i=0;i<4;i++) {
                if(player[i].isAlive())
                    player[i].draw(g2, this);
            }

        }

    }

    public void keyPressed(KeyEvent e) {
        g.keyPressedAct(e.getKeyCode(),v.obs,player,this);
        repaint();
    }
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }
}
