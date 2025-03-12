package logic;

import java.awt.Graphics2D;

import entity.Tile;
import main.GamePanel;

public class TileMangement {
    GamePanel gp;
    Tile[] tile;
    int[][] mapTileNum;

    public TileMangement(GamePanel gp) {
        this.gp = gp;
        loadMap("map.txt");
    }


    private void loadMap(String filename) {
        
    }

    public void draw(Graphics2D g2d) {
        
    }

}
