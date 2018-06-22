package BomberGame;

import java.awt.*;
public class Blank_c extends MapCell {

    private int ID;
    public  int getID(){
        return this.ID;
    }
    public Blank_c(int x, int y ){
        this.xPos=x;
        this.yPos=y;
        probability=.5;
        ID=0;
        crossPermition=true;
        img = Toolkit.getDefaultToolkit().getImage("pics/blank.png");
    }
    @Override
    public boolean getToFireAction() {
        return false;
    }
    public void draw(BomberMap P , Graphics2D g){
        g.drawImage(this.img, this.xPos, this.yPos, P);

    }

}