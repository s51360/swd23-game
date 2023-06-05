package at.campus02.swd.game.gameobjects;

import at.campus02.swd.game.AssetRepository;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Water extends Tile {

    private Texture image;
    private Sprite sprite;
    private AssetRepository assetRepository = AssetRepository.getInstance();

    public Water() {
        super();
        image = assetRepository.getTexture("tiles\\mapTile_188.png");
        sprite = new Sprite(image);
    }

    @Override
    public void act(float delta) {}

    @Override
    public void setPosition(float x, float y) {
        sprite.setPosition(x, y);
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }
}
