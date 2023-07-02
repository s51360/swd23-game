package at.campus02.swd.game.factory;

import at.campus02.swd.game.gameobjects.Enemy;
import at.campus02.swd.game.gameobjects.GameObject;
import at.campus02.swd.game.strategy.PlayerBehaviorEnemyDefault;

public class EnemyFactory extends Factory {

//    private PlayerBehaviorStrategy strategy;

    // hier die Strategy speicher private attribut
    // im Constructor eine erstellen

    public EnemyFactory() {
        super(FactoryType.Enemy);
//        setStrategy(strategy);
    }

//    public void setStrategy(PlayerBehaviorStrategy strategy) {
//        this.strategy = strategy;
//    }

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
