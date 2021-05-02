package uygulama.observer;

public interface ISubject {
    public void registerObserver(IObServer o);
    public void removeObserver(IObServer o);
    public void notifyObservers();
}
