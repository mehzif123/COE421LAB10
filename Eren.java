import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class Eren extends Thread implements Subject {
    private final UI ui;
    private final Random rnd = new Random();
    private final List<Observer> observers = new CopyOnWriteArrayList<>();
    private volatile boolean running = true;
    private int energy;

    public Eren(int startingEnergy, UI ui) {
        this.energy = startingEnergy;
        this.ui = ui;
        setName("Eren-Thread");
        setDaemon(false);
        start();
    }

    @Override
    public void run() {
        while (running && energy > 0) {
            try {
                int sleepSec = 5 + rnd.nextInt(6); // 5..10 seconds
                Thread.sleep(sleepSec * 1000L);
            } catch (InterruptedException ignored) {}

            ui.log("Eren", "TRANSFORM! (10s) | energy=" + energy);
            notifyObservers(energy);

            try {
                Thread.sleep(10_000L); // transformed for 10s
            } catch (InterruptedException ignored) {}

            energy = Math.max(0, energy - 5);
            ui.log("Eren", "Reverted. Energy now " + energy);

            if (energy == 0) {
                ui.log("Eren", "Exhausted. No more transformations.");
                running = false;
            }
        }
    }

    @Override
    public void register(Observer o) { observers.add(o); }

    @Override
    public void unregister(Observer o) { observers.remove(o); }

    @Override
    public void notifyObservers(int currentEnergy) {
        for (Observer o : observers) {
            try { o.onErenTransform(currentEnergy); }
            catch (Exception ex) { ui.log("System", "Observer error: " + ex.getMessage()); }
        }
    }

    public int getEnergy() { return energy; }
}
