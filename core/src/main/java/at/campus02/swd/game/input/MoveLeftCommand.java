package at.campus02.swd.game.input;

import at.campus02.swd.game.gameobjects.Player;
import at.campus02.swd.game.observer.PlayerObserver;
import com.badlogic.gdx.Gdx;

public class MoveLeftCommand implements Command {

    private Player player;

    public MoveLeftCommand(Player p) {
        this.player = p;
    }

    @Override
    public void execute() {

        if (player.getX() >= 128) {
            player.setPosition((player.getX() - 200 * Gdx.graphics.getDeltaTime()), player.getY());
        } else {
            player.setPosition(128, player.getY());
        }

        for (PlayerObserver observer : player.getObservers()) {
            observer.onPlayerMovedLeft();
        }
    }
}
