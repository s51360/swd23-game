package at.campus02.swd.game.strategy;

import at.campus02.swd.game.gameobjects.Enemy;
import com.badlogic.gdx.Gdx;

import java.util.Random;

public class PlayerBehaviorEnemyDefault implements PlayerBehaviorStrategy {

    private Enemy enemy;

    private float x;
    private float y;

    public PlayerBehaviorEnemyDefault(Enemy enemy) {
        this.enemy = enemy;
        this.x = enemy.getX();
        this.y = enemy.getY();
    }

    @Override
    public void move() {

        Random random = new Random();
        int direction = random.nextInt(4); // 0: oben, 1: unten, 2: links, 3: rechts

        switch (direction) {
            case 0: // oben
                //y -= 1;
                //enemy.setPosition(enemy.getX(), enemy.getY() - 5);
                if (enemy.getY() <= 404) {
                    enemy.setPosition(enemy.getX(), enemy.getY() + 15);
                } else {
                    enemy.setPosition(enemy.getX(), 404);
                }
                break;
            case 1: // unten
                //y += 1;
                //enemy.setPosition(enemy.getX(),enemy.getY() + 5);
                if (enemy.getY() >= 128) {
                    enemy.setPosition(enemy.getX(), enemy.getY() - 15);
                } else {
                    enemy.setPosition(enemy.getX(), 128);
                }
                break;
            case 2: // links
                //x -= 1;
                //enemy.setPosition(enemy.getX() - 5,enemy.getY());
                if (enemy.getX() >= 128) {
                    enemy.setPosition((enemy.getX() - 15), enemy.getY());
                } else {
                    enemy.setPosition(128, enemy.getY());
                }
                break;
            case 3: // rechts
                //x += 1;
                //enemy.setPosition(enemy.getX() + 5,enemy.getY());
                if (enemy.getX() <= 470) {
                    enemy.setPosition((enemy.getX() + 15), enemy.getY());
                } else {
                    enemy.setPosition(470, enemy.getY());
                }
                break;
            default:
                break;
        }
//        x = Math.max(0, Math.min(x, 9));
//        y = Math.max(0, Math.min(y, 9));
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}