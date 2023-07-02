package at.campus02.swd.game.strategy;

import at.campus02.swd.game.gameobjects.Enemy;

import java.util.Random;

public class PlayerBehaviorStrategyDefault implements PlayerBehaviorStrategy {

    private Enemy enemy;

    public PlayerBehaviorStrategyDefault(Enemy e) {
        this.enemy = e;
    }

    @Override
    public void move() {

        Random random = new Random();
        int direction = random.nextInt(100); // 0: oben, 1: unten, 2: links, 3: rechts

        switch (direction) {
            case 0: // oben
                if (enemy.getY() <= 404) {
                    enemy.setPosition(enemy.getX(), enemy.getY() + 15);
                } else {
                    enemy.setPosition(enemy.getX(), 404);
                }
                break;
            case 1: // unten
                if (enemy.getY() >= 128) {
                    enemy.setPosition(enemy.getX(), enemy.getY() - 15);
                } else {
                    enemy.setPosition(enemy.getX(), 128);
                }
                break;
            case 2: // links
                if (enemy.getX() >= 128) {
                    enemy.setPosition((enemy.getX() - 15), enemy.getY());
                } else {
                    enemy.setPosition(128, enemy.getY());
                }
                break;
            case 3: // rechts
                if (enemy.getX() <= 470) {
                    enemy.setPosition((enemy.getX() + 15), enemy.getY());
                } else {
                    enemy.setPosition(470, enemy.getY());
                }
                break;
            default:
                break;
        }
    }
}
