package entity;

import java.awt.Color;
import java.awt.Graphics2D;

import logic.KeyHandler;
import main.GamePanel;

public class MainCharater extends Entity {
    int clock = 0;
    int delay = 0;

    void setDefaultValue() {
        screenX = gp.screenWidth / 2;
        screenY = gp.screenHeight / 2;
        worldX = 0;
        worldY = 48*11 + 40;
        speedX = 0;
        speedY = 0;
    }

    public MainCharater(GamePanel gp) {
        this.gp = gp;
        setDefaultValue();
    }

    private void handleMovementInput(KeyHandler keyH) {
        if (keyH.upPressed && collisionOn[2] == true && delay > 5) {
            speedY = -20;
            delay = 0;
        }
        
        if (keyH.leftPressed) {
            if (speedX > -5) {
                speedX -= 1;
            }
            direction = "left";
        } else {
            if (speedX < 0) {
                speedX += 1;
            }
        }
        if (keyH.rightPressed) {
            if (speedX < 5) {
                speedX += 1;
            }
            direction = "right";
        } else {
            if (speedX > 0) {
                speedX -= 1;
            }
        }
        worldY += speedY;
        worldX += speedX;
    }
    
    private void falling() {
        if (collisionOn[2] == false) {
            speedY += 1;
            delay = 0;
        } else if (collisionOn[2] == true) {
            speedY = 0;
            worldY = collisionTile[2] * gp.tileSize - collisionBox.height - 1;
            delay++;
        }
        

    }
    
    private void imageDisplayLogic(Graphics2D g2) {
        
    }
    
    public void draw(Graphics2D g2) {
        g2.setColor(Color.RED);
        g2.fillRect(screenX, screenY, gp.tileSize - 1, gp.tileSize - 1);
    }
    
    public void update(KeyHandler keyH) {
        collisionBox.x = worldX;
        collisionBox.y = worldY;
        gp.collisionChecker.checkTile(this);
        falling();
        
        // System.out.println("Collision on: " + collisionOn[1] + "\t" + collisionOn[2] + "\t" + collisionOn[3] + "\t" + collisionOn[4] + "\t" + speedY);
        // System.out.println("SpeedX: " + speedX + "\tSpeedY: " + speedY);
        handleMovementInput(keyH);

    }
}
