package at.campus02.swd.game.input;

import at.campus02.swd.game.gameobjects.Player;
import at.campus02.swd.game.observer.PlayerObserver;
import com.badlogic.gdx.Gdx;

public class MoveDownCommand implements Command {

    private Player player;

    public MoveDownCommand(Player p) {
        this.player = p;
    }

    @Override
    public void execute() {
        if (player.getY() >= 128) {
            player.setPosition(player.getX(), player.getY() - 200 * Gdx.graphics.getDeltaTime());
        } else {
            player.setPosition(player.getX(), 128);
        }

        for (PlayerObserver observer : player.getObservers()) {
            observer.onPlayerMovedDown();
        }

        player.setLastMovement("nach unten");
    }
}
