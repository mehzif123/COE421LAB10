import java.util.Random;

public class Titan implements Observer {
    private final String name;
    private final UI ui;
    private final Random rnd = new Random();

    public Titan(String name, UI ui, Eren eren) {
        this.name = name;
        this.ui = ui;
        eren.register(this);
        ui.log(name, "Hunting Eren...");
    }

    @Override
    public void onErenTransform(int currentEnergy) {
        if (rnd.nextBoolean()) {
            ui.log(name, "Attacks Eren!");
            if (currentEnergy > 40) {
                ui.log(name, "Now we got problems, and I don't think we can solve 'em");
            }
        } else {
            ui.log(name, "Lurks, waiting...");
        }
    }
}
