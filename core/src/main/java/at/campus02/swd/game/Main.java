package at.campus02.swd.game;

import at.campus02.swd.game.factory.EnemyFactory;
import at.campus02.swd.game.factory.PlayerFactory;
import at.campus02.swd.game.factory.TileFactory;
import at.campus02.swd.game.factory.TileType;
import at.campus02.swd.game.gameobjects.Enemy;
import at.campus02.swd.game.gameobjects.Player;
import at.campus02.swd.game.input.*;
import at.campus02.swd.game.observer.ConsolePlayerObserver;
import at.campus02.swd.game.observer.PlayerObserver;
import at.campus02.swd.game.observer.UiPlayerObserver;
import at.campus02.swd.game.strategy.PlayerBehaviorStrategyDefault;
import at.campus02.swd.game.strategy.PlayerBehaviorStrategyPatrouillieren;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

import at.campus02.swd.game.gameobjects.GameObject;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
	private SpriteBatch batch;

//	private ExtendViewport viewport = new ExtendViewport(480.0f, 480.0f, 480.0f, 480.0f);
	private GameInput gameInput = new GameInput();

	private Array<GameObject> gameObjects = new Array<>();

    private GameObject[][] matrix = new GameObject[10][10];

	private final float updatesPerSecond = 60;
	private final float logicFrameTime = 1 / updatesPerSecond;
	private float deltaAccumulator = 0;
	private BitmapFont font;

    private TileFactory tileFactory = new TileFactory();
    private PlayerFactory playerFactory = new PlayerFactory();
    private Player player;

    private EnemyFactory enemyFactory = new EnemyFactory();
    private Enemy enemy;
    private Enemy enemy2;

    private AssetRepository assetRepository;

    private PlayerObserver observerConsole = new ConsolePlayerObserver();

    private PlayerObserver observerUI;


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
        assetRepository = AssetRepository.getInstance();

//        erster Ansatz bevor jener unten umgestzt worden ist - zweckes Doku lasse ich noch drin!

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

        GameObject p = playerFactory.create();
        this.player = (Player) p;
        p.setPosition(256,256);
        gameObjects.add(p);

        GameObject e = enemyFactory.create();
        this.enemy = (Enemy) e;
        enemy.setStrategy(new PlayerBehaviorStrategyDefault(this.enemy));
        e.setPosition(156,156);
        gameObjects.add(e);

        GameObject e2 = enemyFactory.create();
        this.enemy2 = (Enemy) e2;
        enemy2.setStrategy(new PlayerBehaviorStrategyDefault(this.enemy2));
        e2.setPosition(456,456);
        gameObjects.add(e2);

        // erster Observer
        player.registerObserver(observerConsole);

        observerUI = new UiPlayerObserver(batch, font);

        // zweiten Observer aufnehmen
        player.registerObserver(observerUI);
	}

	private void act(float delta) {
		for(GameObject gameObject : gameObjects) {
			gameObject.act(delta);
		}
        enemy.act(delta);
        enemy2.act(delta);
	}

	private void draw() {
        // die Zeile 93 auskommentiert, da der viewport in der mitte, das kalkulieren und setzen der tiles erschwert!
		// batch.setProjectionMatrix(viewport.getCamera().combined);

		for(GameObject gameObject : gameObjects) {
            gameObject.draw(batch);
		}
	}

	@Override
	public void render() {
        batch.begin();

		Gdx.gl.glClearColor(0.15f, 0.15f, 0.2f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		float delta = Gdx.graphics.getDeltaTime();
		deltaAccumulator += delta;
		while(deltaAccumulator > logicFrameTime) {
			deltaAccumulator -= logicFrameTime;
			act(logicFrameTime);
		}

        draw();

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            MoveLeftCommand command = new MoveLeftCommand(player);
            command.execute();
        }

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            MoveRightCommand command = new MoveRightCommand(player);
            command.execute();
        }

        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            MoveUpCommand command = new MoveUpCommand(player);
            command.execute();
        }

        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            MoveDownCommand command = new MoveDownCommand(player);
            command.execute();
        }

        // D für Default
        if(Gdx.input.isKeyPressed(Input.Keys.D)) {
            enemy.setStrategy(new PlayerBehaviorStrategyDefault(enemy));
            enemy2.setStrategy(new PlayerBehaviorStrategyDefault(enemy2));
        }

        // P für Patrouillieren
        if(Gdx.input.isKeyPressed(Input.Keys.P)) {
            enemy.setStrategy(new PlayerBehaviorStrategyPatrouillieren(enemy));
            enemy2.setStrategy(new PlayerBehaviorStrategyPatrouillieren(enemy2));
        }

        batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();

        // .dispose aufrufen wenn die Ressourcen nicht mehr benötigt werden (z.B. wenn das Spiel beendet wird) um diese freizugeben.
        // sollte sich die Szene ändern z.B. andere Map so gehört .dispose eigentlich dort aufgerufen wo sich die Map ändert (render?)
        assetRepository.dispose();
	}

	@Override
	public void resize(int width, int height){
//		viewport.update(width,height);
	}
}
