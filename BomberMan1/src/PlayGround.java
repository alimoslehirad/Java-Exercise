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
import java.awt.geom.*;
public class PlayGround extends JFrame implements KeyListener{
    int[][] frameMask=new int[16][16];
    BomberMan p1=new BomberMan();
    int bombNum;
    private static final int BoxID=2;
    private  static final int wallID=3;
    private static final int BombID=1;
    private static final int BomberManID=4;
    private static final int Blank=0;
    private static final int RightKey=39;
    private static final int LeftKey=37;
    private static final int DownKey=40;
    private static final int UpKey=38;
    public void playGroung_make(){

        JPanel panel =new JPanel();




    }

    public PlayGround(String title) {

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 700, 720);
        setVisible(true);
        playGroundMask_init(frameMask);
        bombNum=0;
        addKeyListener(this);


    }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == RightKey) {
            if(p1.xPos<15 && frameMask[p1.xPos+1][p1.yPos]==Blank) {
                System.out.print("move Right");
                if(frameMask[p1.xPos][p1.yPos] != BombID){
                    frameMask[p1.xPos][p1.yPos] = Blank;
                }

                p1.xPos++;
                frameMask[p1.xPos][p1.yPos] = BomberManID;
                repaint();
            }
        }
        else if(e.getKeyCode()==LeftKey){
            if(p1.xPos>1 && frameMask[p1.xPos-1][p1.yPos]==Blank) {
                System.out.print("move Left");
                if(frameMask[p1.xPos][p1.yPos] != BombID){
                    frameMask[p1.xPos][p1.yPos] = Blank;
                }
                p1.xPos--;
                frameMask[p1.xPos][p1.yPos] = BomberManID;
                repaint();
            }
        }
        else if(e.getKeyCode()==DownKey){
            if(p1.yPos<15 && frameMask[p1.xPos][p1.yPos+1]==Blank) {
                System.out.print("move Down");
                if(frameMask[p1.xPos][p1.yPos] != BombID){
                    frameMask[p1.xPos][p1.yPos] = Blank;
                }
                p1.yPos++;
                frameMask[p1.xPos][p1.yPos] = BomberManID;
                repaint();
            }
        }
        else if(e.getKeyCode()==UpKey){
            if(p1.yPos>1 && frameMask[p1.xPos][p1.yPos-1]==Blank) {
                System.out.print("move Right");
                if(frameMask[p1.xPos][p1.yPos] != BombID){
                    frameMask[p1.xPos][p1.yPos] = Blank;
                }
                p1.yPos--;
                frameMask[p1.xPos][p1.yPos] = BomberManID;
                repaint();
            }
        }
        else if (e.getKeyCode()==66 && bombNum==0){    // b
            System.out.println("Bomb");
            bombNum++;
            frameMask[p1.xPos][p1.yPos] = BombID;
            Bomb b1 =new Bomb();
            b1.xPos=p1.xPos;
            b1.yPos=p1.yPos;
            //repaint();
        }
        else if(e.getKeyCode()==88)   {       //x
            if(bombNum!=0){
                bombNum=0;
                boolean bomb_flag=false;
                for(int i=1;i<15;i++){
                    for(int j=1;j<15;j++){
                        if(frameMask[i][j]==BombID){
                            if(frameMask[i+1][j]==BoxID){
                                frameMask[i+1][j]=Blank;
                            }
                             if(frameMask[i][j+1]==BoxID){
                                frameMask[i][j+1]=Blank;
                            }
                             if(frameMask[i-1][j]==BoxID){
                                frameMask[i-1][j]=Blank;
                            }
                             if(frameMask[i][j-1]==BoxID){
                                frameMask[i][j-1]=Blank;
                            }
                            frameMask[i][j]=Blank;
                            bomb_flag=true;
                            repaint();
                            break;
                        }
                    }
                    if(bomb_flag){bomb_flag=false; break;}
                }
            }


        }
        //System.out.println(e.getKeyCode());
    }
    public void keyReleased(KeyEvent e) {


    }
    public void playGroundMask_init(int[][] mask){
        int BocCnt=0;
        for(int i=2;i<15;i=i+2){
            for(int j=2;j<15;j=j+2){
                mask[i][j]=wallID;
                BocCnt++;
            }

        }

        BocCnt=0; boolean boxNum_flag=false;
        for(int i=1;i<15;i++) {
            for (int j = 1; j < 15; j++) {
                if( mask[i][j]!=wallID){
                    if(Math.random()>.6 && !boxNum_flag  ) {
                        BocCnt++;
                        mask[i][j] = BoxID;
                        if (BocCnt > 30) {
                            boxNum_flag = true;
                            BocCnt = 0;
                        }
                    }
                    else{
                        mask[i][j]=Blank;
                    }
                }

            }

        }
        mask[1][1]=BomberManID;

    }
    public void keyTyped(KeyEvent e) {}
     public void keylistener( KeyEvent e){
        while(true) {
            if (e.getKeyCode() == 39) {
                System.out.print("ali");
            }
            if (e.getKeyCode() == 37) break;
        }

    }
     public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
         Bomb bomb1=new Bomb();
         Wall_c wall=new Wall_c();
         Box_c box=new Box_c();
         g2.finalize();

         for(int i=1;i<15;i++){
             for(int j=1;j<15;j++){
                 if(frameMask[i][j]==wallID){
                     g2.drawImage(wall.wall_img, (i-1)*50, 30+(j-1)*50, this);
                 }
                 else if(frameMask[i][j]==BoxID){
                     g2.drawImage(box.woodenBox_img, (i-1)*50, 30+(j-1)*50, this);

                 }
                 else if(frameMask[i][j]==BomberManID){
                     g2.drawImage(p1.bombermanCircle,(i-1)*50, 30+(j-1)*50, this);
                 }
                 else if(frameMask[i][j]==BombID){
                     g2.drawImage(bomb1.Bomb_img, (i-1)*50, 30+(j-1)*50, this);
                 }
                 else{
                     g2.setColor(Color.WHITE);
                     g2.fillRect((i-1)*50, 30+(j-1)*50,50,50);
                 }

             }
         }
       for(int i=1;i<14;i++) {
           Line2D lin = new Line2D.Float(0, 50*i+30, 700, 50*i+30);
           g2.draw(lin);

           Line2D lin2 = new Line2D.Float(50*i, 0, 50*i, 720);
           g2.draw(lin2);
           g.drawOval(5, 35, 40, 40);
       }
    }




}
