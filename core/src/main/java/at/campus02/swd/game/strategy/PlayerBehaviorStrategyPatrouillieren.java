package at.campus02.swd.game.strategy;

import at.campus02.swd.game.gameobjects.Enemy;

import java.time.Duration;
import java.time.LocalDateTime;

public class PlayerBehaviorStrategyPatrouillieren implements PlayerBehaviorStrategy {

    private Enemy enemy;
    private int direction;
    private LocalDateTime start;

    public PlayerBehaviorStrategyPatrouillieren(Enemy e) {
        this.enemy = e;
        direction = 0;
    }

    @Override
    public void move() {
        if (start == null) {
           start = LocalDateTime.now();
        }

        // nach 10sek false und daher friert die Methode ein, sprich Enemies bewegen sich nimmer
        if (Duration.between(start,LocalDateTime.now()).getSeconds() < 10) {
            if (direction == 0) {
                // nach links
                if (enemy.getX() >= 128) {
                    enemy.setPosition((enemy.getX() - 15), enemy.getY());
                } else {
                    enemy.setPosition(128, enemy.getY());
                    direction = 1;
                }
            } else {
                // nach rechts
                if (enemy.getX() <= 470) {
                    enemy.setPosition((enemy.getX() + 15), enemy.getY());
                } else {
                    enemy.setPosition(470, enemy.getY());
                    direction = 0;
                }
            }
        }
    }
}
