package at.campus02.swd.game.input;

import at.campus02.swd.game.gameobjects.Player;
import at.campus02.swd.game.observer.PlayerObserver;
import com.badlogic.gdx.Gdx;

public class MoveRightCommand implements Command {

    private Player player;

    public MoveRightCommand(Player p) {
        this.player = p;
    }

    @Override
    public void execute() {
        if (player.getX() <= 470) {
            player.setPosition((player.getX() + 200 * Gdx.graphics.getDeltaTime()), player.getY());
        } else {
            player.setPosition(470, player.getY());
        }

        for (PlayerObserver observer : player.getObservers()) {
            observer.onPlayerMovedRight();
        }

        player.setLastMovement("nach rechts");
    }
}
