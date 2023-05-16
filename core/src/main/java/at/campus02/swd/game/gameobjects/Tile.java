package at.campus02.swd.game.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Tile implements GameObject {

    private Texture image;
    private Sprite sprite;

    public Tile(String img_file) {
        image = new Texture(img_file);
        sprite = new Sprite(image);
    }

    public Tile() {}

    @Override
    public abstract void act(float delta);

    @Override
    public abstract void setPosition(float x, float y);

    @Override
    public abstract void draw(SpriteBatch batch);

}
