package at.campus02.swd.game;

import at.campus02.swd.game.gameobjects.GameObject;

public abstract class Factory {

    protected FactoryType type;

    public Factory(FactoryType factoryType){
        this.type = factoryType;
    };

    public abstract FactoryType getType();

    public abstract GameObject create();
    public abstract void initialize();
    public abstract GameObject[] getObjects();
}
