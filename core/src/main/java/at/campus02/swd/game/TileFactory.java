package at.campus02.swd.game;

import at.campus02.swd.game.gameobjects.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TileFactory extends Factory {
    public TileFactory() {
        super(FactoryType.Tile);
    }

    @Override
    public FactoryType getType() {
        return this.type;
    }

    @Override
    // ToDo: anstatt von GameObject returnen wir ein Tile -> aufpassen ob das geht!
    public Tile create() {
        return new Bush();
    }

    public Tile create(TileType tileType) {
        switch (tileType) {
            case Bush:
                return new Bush();
            case Grass:
                return new Grass();
            case Water:
            default: return new Water();

        }
    }

    @Override
    public void initialize() {

    }

    @Override
    public GameObject[] getObjects() {
        return new GameObject[0];
    }
}
