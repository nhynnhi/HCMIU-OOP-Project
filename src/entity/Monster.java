package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import main.GamePanel;

public class Monster extends Entity{
    public boolean alive = true;
    int movingLength;
    int initialX;

    public void setDefaultValue() {
        worldX = 5 * 48; // depends on the map
        worldY = 10 * 48; // depends on the map
        speedX = 0;
    }

    public Monster(GamePanel gp) {
        super(gp);
        setDefaultValue();
        movingLength = 2 * gp.tileSize;
        initialX = worldX;
        this.collisionBox.width = 48; // Set the width of the collision box
        this.collisionBox.height = 48; // Set the height of the collision box
    }

    public void draw(Graphics2D monster) {
        screenX = worldX - gp.mainCharacter.worldX + gp.mainCharacter.screenX;
        screenY = worldY - gp.mainCharacter.worldY + gp.mainCharacter.screenY;
        monster.setColor(Color.WHITE);
        monster.fillRect(screenX, screenY, collisionBox.width, collisionBox.height);
    }

    public void update(){
        if (alive) {
            if (worldX >= initialX + movingLength) {
                speedX = -1; // Move left
            } else if (worldX <= initialX) {
                speedX = 1; // Move right
            }
            worldX += speedX;
        }
    }
}
