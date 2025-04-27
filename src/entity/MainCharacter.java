package entity;

import java.awt.Color;
import java.awt.Graphics2D;

import logic.KeyHandler;
import main.GamePanel;

public class MainCharacter extends Entity {
    int collisionGap = (gp.tileSize - collisionBox.width) / 2;
    int clock = 0;
    int delay = 0;

    void setDefaultValue() {
        screenX = gp.screenWidth / 2;
        screenY = gp.screenHeight / 2;
        worldX = gp.tileSize * 5 + collisionGap;
        worldY = 48 * 11 + 40;
        speedX = 0;
        speedY = 0;
    }

    public MainCharacter(GamePanel gp) {
        super(gp);
        setDefaultValue();
    }

    private void handleMovementInput(KeyHandler keyH) {
        if (keyH.upPressed && collisionOn[2] == true && delay > 5) {
            speedY = -20;
            delay = 0;
        }

        if (keyH.leftPressed) {
            speedX = -5;
        } else if (keyH.rightPressed) {
            speedX = 5;
        }

        if (speedY < 0 && collisionOn[1] == true) {
            speedY = 0;
            worldY = (collisionTile[1] + 1) * gp.tileSize + 1;
        }

        if (!keyH.leftPressed && !keyH.rightPressed) {
            speedX = 0;
        }else{
            if (collisionOn[4] == true) {
                worldX = (collisionTile[4] - 1) * gp.tileSize + collisionGap - 6;
            } else if (collisionOn[3] == true) {
                worldX = collisionTile[3] * gp.tileSize - collisionGap + 6;
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
            worldY = (collisionTile[2] - 1) * gp.tileSize;
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
        collisionBox.x = worldX + collisionGap;
        collisionBox.y = worldY + gp.tileSize - collisionBox.height - 1;
        gp.collisionChecker.checkTile(this);
        falling();
        // System.out.println(worldX + "\t" + worldY);
        // System.out.println("Collision on: " + collisionOn[1] + "\t" + collisionOn[2]
        // + "\t" + collisionOn[3] + "\t" + collisionOn[4] + "\t" + speedX);
        // System.out.println("SpeedX: " + speedX + "\tSpeedY: " + speedY);
        handleMovementInput(keyH);

    }
}
