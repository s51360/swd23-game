package at.campus02.swd.game;

import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;
import java.util.Map;

public class AssetRepository {
    private static AssetRepository instance;
    private Map<String, Texture> textureMap = new HashMap<>();

    private AssetRepository() {
        // Konstruktur private deklariert sodass außerhalb keine Instanziierung dieser Klasse möglich ist.
        // um AssetRepository jedoch zu verwenden greift man hier auf die Methode getInstance
    }

    public static AssetRepository getInstance() {
        if (instance == null) {
            instance = new AssetRepository();
        }
        return instance;
    }

    public Texture getTexture(String path) {
        if (!textureMap.containsKey(path)) {
            Texture texture = new Texture(path);
            textureMap.put(path, texture);
        }
        return textureMap.get(path);
    }

    // preloadAssets() zwar implementiert aber wo macht dies Sinn genau aufzurufen??
    public void preloadAssets() {
        Texture bushTexture = getTexture("tiles\\mapTile_017.png");
        Texture waterTexture = getTexture("tiles\\mapTile_188.png");
        Texture grassTexture = getTexture("tiles\\mapTile_022.png");
        Texture shipTexture = getTexture("sprites/Ship parts/hullSmall (1).png");
        Texture sailTexture = getTexture("sprites/Ship parts/sailLarge (2).png");
    }

    public void dispose() {
        for (Texture texture : textureMap.values()) {
            texture.dispose();
        }
    }

}
