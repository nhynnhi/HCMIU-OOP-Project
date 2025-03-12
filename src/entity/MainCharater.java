package entity;

import java.awt.Graphics2D;

import logic.KeyHandler;
import main.GamePanel;

public class MainCharater extends Entity {

    public MainCharater(GamePanel gp) {
        this.gp = gp;

    }
    
   

    private void handleMovementInput(KeyHandler keyH) {
        
    }

    private void imageDisplayLogic() {
        
    }


    public void draw(Graphics2D g2) {
       
    }

    public void update(KeyHandler keyH) {
        handleMovementInput(keyH);
        imageDisplayLogic();
    }
}
