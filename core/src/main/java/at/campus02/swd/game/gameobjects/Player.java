package at.campus02.swd.game.gameobjects;

import at.campus02.swd.game.AssetRepository;
import at.campus02.swd.game.observer.PlayerObservable;
import at.campus02.swd.game.observer.PlayerObserver;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class Player implements GameObject, PlayerObservable {

    private Texture image;
    private Texture image2;
    private Sprite sprite;
    private Sprite sprite2;
    private AssetRepository assetRepository = AssetRepository.getInstance();

    private ArrayList<PlayerObserver> observers = new ArrayList<>();

    private String lastMovement;

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

    public List<PlayerObserver> getObservers() {
        return observers;
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
        sprite2.draw(batch);
    }

    @Override
    public void registerObserver(PlayerObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(PlayerObserver observer) {
        observers.remove(observer);
    }

//    @Override
//    public void notifyObservers() {
//
//    }


    public String getLastMovement() {
        return lastMovement;
    }

    public void setLastMovement(String lastMovement) {
        this.lastMovement = lastMovement;
    }
}
