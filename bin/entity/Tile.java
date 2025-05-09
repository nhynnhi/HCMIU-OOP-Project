package entity;

import java.awt.Color;
import java.awt.Graphics2D;

import main.GamePanel;

public class Tile {
    GamePanel gp;
    private int tileNum;
    public boolean isSolid = false;

    public Tile(GamePanel gp, int tileNum) {
        this.gp = gp;
        this.tileNum = tileNum;
        if(tileNum == 1){
            isSolid = true;
        }
    }

    private void setColorTile(Graphics2D g2d) {
        switch (tileNum) {
            case 0:
                g2d.setColor(Color.BLUE);
                break;
            case 1:
                g2d.setColor(Color.white);
                break;
            default:
                break;
        }
    }

    public void draw(Graphics2D g2d, int x, int y) {
        setColorTile(g2d);
        g2d.drawRect(x, y, gp.tileSize, gp.tileSize);
    }

}
