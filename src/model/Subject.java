package model;

import model.Observer;

/**
 * Subject interface for the Observer pattern.
 */
public interface Subject {
    /**
     * Register an observer.
     * @param observer the observer to register
     */
    void registerObserver(Observer observer);

    /**
     * Remove an observer.
     * @param observer the observer to remove
     */
    void removeObserver(Observer observer);

    /**
     * Notify all observers.
     */
    void notifyObservers();
}
