package logic;

import entity.Entity;
import main.GamePanel;

public class CollisionChecker {
    GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    public void checkTile(Entity entity) {
        // Initialize collision states: 0 = no collision
        for (int i = 0; i < 5; i++) {
            entity.collisionOn[i] = false;
        }
        int entityX = entity.collisionBox.x;
        int entityY = entity.collisionBox.y;
        int entityXend = entityX + entity.collisionBox.width;
        int entityYend = entityY + entity.collisionBox.height;
        
        int entityLeftCol = entityX / gp.tileSize;
        int entityRightCol = entityXend / gp.tileSize;
        int entityTopRow = entityY / gp.tileSize;
        int entityBottomRow = entityYend / gp.tileSize;
        
        int tileNum1;
        int tileNum2;
        
        // Upward collision check
        if (entity.speedY < 0) {
            entityTopRow = (entityY - gp.mainCharacter.speedY) / gp.tileSize - 1;

            if (entityTopRow < 0) {
                entity.collisionOn[1] = true;
                entity.collisionTile[1] = 1;
            } else {
                tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityTopRow];
                if (gp.tileManager.tile[tileNum1].isSolid || gp.tileManager.tile[tileNum2].isSolid) {
                    entity.collisionOn[1] = true;
                    entity.collisionTile[1] = entityTopRow;
                }
            }
            entityTopRow = entityY / gp.tileSize;
        }
        
        // Downward collision check
        if (entity.speedY >= 0) {
            entityBottomRow = (entityYend + gp.mainCharacter.speedY + 1) / gp.tileSize;
            if (entityBottomRow >= gp.tileManager.mapTileNum[0].length) {
                entity.collisionOn[2] = true;
                entity.collisionTile[2] = gp.tileManager.mapTileNum[0].length;
            } else {
                tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileManager.tile[tileNum1].isSolid || gp.tileManager.tile[tileNum2].isSolid) {
                    entity.collisionOn[2] = true;
                    entity.collisionTile[2] = entityBottomRow;
                }
            }
            entityBottomRow = entityYend / gp.tileSize;
        }

        // Leftward collision check
        if (entity.speedX < 0) {
            if (entityX < 0) {
                entity.collisionOn[3] = true;
                entity.collisionTile[3] = 0;
            } else {
                entityLeftCol = (entityX + gp.mainCharacter.speedX) / gp.tileSize;

                tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
                if (gp.tileManager.tile[tileNum1].isSolid || gp.tileManager.tile[tileNum2].isSolid) {
                    entity.collisionOn[3] = true;
                    entity.collisionTile[3] = entityLeftCol + 1;
                }

                entityLeftCol = entityX / gp.tileSize;
            }
        }

        // Rightward collision check
        if (entity.speedX > 0) {
            entityRightCol = (entityXend + gp.mainCharacter.speedX) / gp.tileSize;
            if (entityRightCol >= gp.tileManager.mapTileNum.length) {
                entity.collisionOn[4] = true;
                entity.collisionTile[4] = gp.tileManager.mapTileNum.length;
            } else {
                tileNum1 = gp.tileManager.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileManager.tile[tileNum1].isSolid || gp.tileManager.tile[tileNum2].isSolid) {
                    entity.collisionOn[4] = true;
                    entity.collisionTile[4] = entityRightCol;
                }
            }
            entityRightCol = entityXend / gp.tileSize;
        }


    }
}
