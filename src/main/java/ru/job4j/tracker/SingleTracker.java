package ru.job4j.tracker;

public class SingleTracker {
    private static SingleTracker instance = null;
    private Store tracker = new MemTracker();

    private SingleTracker() {

    }

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    public Item add(Item item) {
        return SingleTracker.getInstance().add(item);
    }

    public Item[] findAll() {
        return SingleTracker.getInstance().findAll();
    }

    public Item[] findByName(String name) {
        return SingleTracker.getInstance().findByName(name);
    }

    public Item findById(int id) {
        return SingleTracker.getInstance().findById(id);
    }

    public boolean replace(int id, Item item) {
        return SingleTracker.getInstance().replace(id, item);
    }

    public boolean delete(int id) {
        return SingleTracker.getInstance().delete(id);
    }
}

