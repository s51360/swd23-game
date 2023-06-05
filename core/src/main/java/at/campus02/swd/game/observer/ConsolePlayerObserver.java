package at.campus02.swd.game.observer;

public class ConsolePlayerObserver implements PlayerObserver {
    @Override
    public void onPlayerMovedLeft() {
        System.out.println("Spieler bewegt sich nach links.");
    }

    @Override
    public void onPlayerMovedRight() {
        System.out.println("Spieler bewegt sich nach rechts.");
    }

    @Override
    public void onPlayerMovedUp() {
        System.out.println("Spieler bewegt sich nach oben.");
    }

    @Override
    public void onPlayerMovedDown() {
        System.out.println("Spieler bewegt sich nach unten.");
    }
}
