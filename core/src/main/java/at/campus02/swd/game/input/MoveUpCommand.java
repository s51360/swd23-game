package at.campus02.swd.game.input;

import at.campus02.swd.game.gameobjects.Player;
import com.badlogic.gdx.Gdx;

public class MoveUpCommand implements Command {

    private Player player;

    public MoveUpCommand(Player p) {
        this.player = p;
    }

    @Override
    public void execute() {
        if (player.getY() <= 404) {
            player.setPosition(player.getX(), player.getY() + 200 * Gdx.graphics.getDeltaTime());
        } else {
            player.setPosition(player.getX(), 404);
        }
    }
}
