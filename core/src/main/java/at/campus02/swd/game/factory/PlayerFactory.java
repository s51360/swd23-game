package at.campus02.swd.game.factory;

import at.campus02.swd.game.gameobjects.*;

public class PlayerFactory extends Factory {
    public PlayerFactory() {
        super(FactoryType.Player);
    }

    @Override
    public FactoryType getType() {
        return this.type;
    }

    @Override
    public Player create() {
        return new Player();
    }

    @Override
    public void initialize() {}

    @Override
    public GameObject[] getObjects() {
        return new GameObject[0];
    }
}
