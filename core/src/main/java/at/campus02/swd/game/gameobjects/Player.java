package at.campus02.swd.game.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player implements GameObject {

    private Texture image;
    private Sprite sprite;

    public Player() {
        image = new Texture("C:\\Projects\\02_Semester\\Software_Design\\assets\\sprites\\Ship parts\\hullSmall (1).png");
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
