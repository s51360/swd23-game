package at.campus02.swd.game.gameobjects;

import at.campus02.swd.game.AssetRepository;
import at.campus02.swd.game.strategy.PlayerBehaviorStrategy;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Enemy implements GameObject {

    private Texture image;
    private Sprite sprite;
    private AssetRepository assetRepository = AssetRepository.getInstance();

    private PlayerBehaviorStrategy strategy;

    public Enemy() {
        image = assetRepository.getTexture("sprites/mapTile_094.png");
        sprite = new Sprite(image);
    }

    public void setStrategy(PlayerBehaviorStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void act(float delta) {
        strategy.move();
    }

    @Override
    public void setPosition(float x, float y) {
        sprite.setPosition(x, y);
    }

    public float getX() {
        return sprite.getX();
    }

    public float getY() {
        return sprite.getY();
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }

}
