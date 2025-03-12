package logic;

import entity.Entity;
import main.GamePanel;

public class CollisionChecker {
    GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    public void detectEntityDirection(Entity entity) {
        switch (entity.direction) {
            case "jump":
                break;
            case "left":
                break;
            case "right":
                break;
            case "down":
                break;
            default:
                break;
        }
    }
}
