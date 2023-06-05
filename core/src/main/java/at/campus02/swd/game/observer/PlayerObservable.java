package at.campus02.swd.game.observer;

public interface PlayerObservable {
    void registerObserver(PlayerObserver observer);

    // ToDo: Wo genau die removeObserver aufrufen??
    void removeObserver(PlayerObserver observer);

    // ToDo: eventuell über eine BenachrichtigeAlleObserver Methode zu implementieren??
    // void notifyObservers();
}
