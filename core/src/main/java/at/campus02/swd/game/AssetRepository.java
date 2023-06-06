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

        // um die Tiles vorzuladen
        preloadAssets();
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
    private void preloadAssets() {
        this.textureMap = new HashMap<String, Texture>() {{
            put("tiles\\mapTile_017.png",new Texture("tiles\\mapTile_017.png"));
            put("tiles\\mapTile_188.png",new Texture("tiles\\mapTile_188.png"));
            put("tiles\\mapTile_022.png",new Texture("tiles\\mapTile_022.png"));
            put("sprites/Ship parts/hullSmall (1).png",new Texture("sprites/Ship parts/hullSmall (1).png"));
            put("sprites/Ship parts/sailLarge (2).png",new Texture("sprites/Ship parts/sailLarge (2).png"));
        }};
    }

    public void dispose() {
        for (Texture texture : textureMap.values()) {
            texture.dispose();
        }
    }
}
