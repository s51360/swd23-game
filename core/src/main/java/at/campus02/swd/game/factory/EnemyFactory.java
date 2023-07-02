package at.campus02.swd.game.factory;

import at.campus02.swd.game.gameobjects.Enemy;
import at.campus02.swd.game.gameobjects.GameObject;

public class EnemyFactory extends Factory {

    public EnemyFactory() {
        super(FactoryType.Enemy);
    }

    @Override
    public FactoryType getType() {
        return this.type;
    }

    @Override
    public Enemy create() {
        return new Enemy();
    }

    @Override
    public void initialize() {}

    @Override
    public GameObject[] getObjects() {
        return new GameObject[0];
    }
}
