package at.campus02.swd.game;

import at.campus02.swd.game.factory.TileFactory;
import at.campus02.swd.game.factory.TileType;
import at.campus02.swd.game.gameobjects.Player;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import at.campus02.swd.game.gameobjects.GameObject;
import at.campus02.swd.game.input.GameInput;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
	private SpriteBatch batch;

	private ExtendViewport viewport = new ExtendViewport(480.0f, 480.0f, 480.0f, 480.0f);
	private GameInput gameInput = new GameInput();

	private Array<GameObject> gameObjects = new Array<>();

    private GameObject[][] matrix = new GameObject[10][10];

	private final float updatesPerSecond = 60;
	private final float logicFrameTime = 1 / updatesPerSecond;
	private float deltaAccumulator = 0;
	private BitmapFont font;

    private TileFactory tileFactory = new TileFactory();


    // Mit diesem zweidimensionales Array von TileType bauen wir unser Muster wie die Fläche aussehen könnte.
    // Mit den enum typen befüllen wir diese dann. Hier an der Stelle wird nur die Vorlage, befüllen passiert in der create() Methode.
    TileType[][] tileTypes = new TileType[][]{
        {TileType.Grass, TileType.Grass, TileType.Grass, TileType.Grass, TileType.Grass, TileType.Grass, TileType.Grass, TileType.Grass, TileType.Grass, TileType.Grass},
        {TileType.Grass, TileType.Bush, TileType.Bush, TileType.Bush, TileType.Bush, TileType.Bush, TileType.Bush, TileType.Bush, TileType.Bush, TileType.Grass},
        {TileType.Grass, TileType.Bush, TileType.Water, TileType.Water, TileType.Water, TileType.Water, TileType.Water, TileType.Water, TileType.Bush, TileType.Grass},
        {TileType.Grass, TileType.Bush, TileType.Water, TileType.Water, TileType.Water, TileType.Water, TileType.Water, TileType.Water, TileType.Bush, TileType.Grass},
        {TileType.Grass, TileType.Bush, TileType.Water, TileType.Water, TileType.Water, TileType.Water, TileType.Water, TileType.Water, TileType.Bush, TileType.Grass},
        {TileType.Grass, TileType.Bush, TileType.Water, TileType.Water, TileType.Water, TileType.Water, TileType.Water, TileType.Water, TileType.Bush, TileType.Grass},
        {TileType.Grass, TileType.Bush, TileType.Water, TileType.Water, TileType.Water, TileType.Water, TileType.Water, TileType.Water, TileType.Bush, TileType.Grass},
        {TileType.Grass, TileType.Bush, TileType.Water, TileType.Water, TileType.Water, TileType.Water, TileType.Water, TileType.Water, TileType.Bush, TileType.Grass},
        {TileType.Grass, TileType.Bush, TileType.Bush, TileType.Bush, TileType.Bush, TileType.Bush, TileType.Bush, TileType.Bush, TileType.Bush, TileType.Grass},
        {TileType.Grass, TileType.Grass, TileType.Grass, TileType.Grass, TileType.Grass, TileType.Grass, TileType.Grass, TileType.Grass, TileType.Grass, TileType.Grass},
    };


	@Override
	public void create() {
		batch = new SpriteBatch();

        // erster Ansatz bevor jener unten umgestzt worden ist - zweckes Doku lasse ich noch drin!

//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                GameObject o = tileFactory.create(TileType.Water);
//                o.setPosition(64*i, 64*j);
//                gameObjects.add(o);
//            }
//        }

        // ACHTUNG: da zweidimensionales Array, somit Spiegelverkehrt
        // Besonderheit hier in o.setPosition x und y werte vertauscht
        // und bei GameObject o ... ganz hinten statt nur i auf "tileTypes.length - i - 1" geändert!
        // erst mit den zwei wesentlichen Anpassungen ist die map/fläche/matrix sowie oben im Muster definiert ersichtlich
        for (int i = 0; i < tileTypes.length; i++) {
            for (int j = 0; j < tileTypes[i].length; j++) {
                GameObject o = tileFactory.create(tileTypes[tileTypes.length - i - 1][j]);
                o.setPosition(64*j, 64*i);
                gameObjects.add(o);
            }
        }

		font = new BitmapFont();
		font.setColor(Color.WHITE);
		Gdx.input.setInputProcessor(this.gameInput);

	}

	private void act(float delta) {
		for(GameObject gameObject : gameObjects) {
			gameObject.act(delta);
		}
	}

	private void draw() {

        // die Zeile 93 auskommentiert, da der viewport in der mitte, das kalkulieren und setzen der tiles erschwert!

		//batch.setProjectionMatrix(viewport.getCamera().combined);
		batch.begin();

		for(GameObject gameObject : gameObjects) {
            gameObject.draw(batch);
		}

        // nur temporär, wenn wir den Spieler bewegen müssen, dann müssen wir dem die Struktur mitgeben - denke ich!
        Player player = new Player();
        player.setPosition(256,256);
        player.draw(batch);

//		font.draw(batch, "Hello Game", 220, 220);

		batch.end();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0.15f, 0.15f, 0.2f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		float delta = Gdx.graphics.getDeltaTime();
		deltaAccumulator += delta;
		while(deltaAccumulator > logicFrameTime) {
			deltaAccumulator -= logicFrameTime;
			act(logicFrameTime);
		}
		draw();
	}

	@Override
	public void dispose() {
		batch.dispose();
	}

	@Override
	public void resize(int width, int height){
		viewport.update(width,height);
	}
}
