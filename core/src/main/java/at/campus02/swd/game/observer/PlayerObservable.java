package at.campus02.swd.game.observer;

public interface PlayerObservable {
    void registerObserver(PlayerObserver observer);

    // ToDo: Wo genau die removeObserver aufrufen??
    void removeObserver(PlayerObserver observer);

    void notifyObservers(float x, float y);
}
