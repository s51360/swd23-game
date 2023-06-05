package at.campus02.swd.game.gameobjects;

import at.campus02.swd.game.AssetRepository;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player implements GameObject {

    private Texture image;
    private Texture image2;
    private Sprite sprite;
    private Sprite sprite2;
    private AssetRepository assetRepository = AssetRepository.getInstance();

    public Player() {
        image = assetRepository.getTexture("sprites/Ship parts/hullSmall (1).png");
        sprite = new Sprite(image);

        image2 = assetRepository.getTexture("sprites/Ship parts/sailLarge (2).png");
        sprite2 = new Sprite(image2);
    }
    @Override
    public void act(float delta) {}

    @Override
    public void setPosition(float x, float y) {
        sprite.setPosition(x, y);
        sprite2.setPosition(x-13, y+20);
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
        sprite2.draw(batch);
    }
}
