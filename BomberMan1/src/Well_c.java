import java.awt.*;
public class Well_c extends Layer2 {
    private int ID=7;
    public Well_c(int x, int y){
        this.xPos=x;
        this.yPos=y;
        probability=.075;
    }
    @Override
    public void bombReaction(){
        changeToBlank_flag=true;
    }

    @Override
    public boolean getToFireAction() {
        return true;
    }
    @Override
    public  int getID(){
        return this.ID;
    }
    public Image img = Toolkit.getDefaultToolkit().getImage("well.png");
    @Override
    public void draw(BomberMap P , Graphics2D g){
        g.drawImage(this.img, xPos, yPos, P);

    }
}
