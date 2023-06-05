package at.campus02.swd.game.observer;

public interface PlayerObserver {
    public void onPlayerMovedLeft();
    public void onPlayerMovedRight();
    public void onPlayerMovedUp();
    public void onPlayerMovedDown();
}
