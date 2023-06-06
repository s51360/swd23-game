package at.campus02.swd.game.observer;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class UiPlayerObserver implements PlayerObserver {

    private SpriteBatch spriteBatch;
    private BitmapFont font;

    public UiPlayerObserver(SpriteBatch batch, BitmapFont font) {
        this.spriteBatch = batch;
        this.font = font;
    }

    @Override
    public void onPlayerMovedLeft() {
        this.font.draw(spriteBatch, "Spieler bewegt sich nach links.", 20, 20);
    }

    @Override
    public void onPlayerMovedRight() {
        this.font.draw(spriteBatch, "Spieler bewegt sich nach rechts.", 20, 20);
    }

    @Override
    public void onPlayerMovedUp() {
        this.font.draw(spriteBatch, "Spieler bewegt sich nach oben.", 20, 20);
    }

    @Override
    public void onPlayerMovedDown() {
        this.font.draw(spriteBatch, "Spieler bewegt sich nach unten.", 20, 20);
    }
}
