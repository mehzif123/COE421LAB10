import java.util.Random;

public class Friend implements Observer {
    private final String name;
    private final UI ui;
    private final Random rnd = new Random();

    public Friend(String name, UI ui, Eren eren) {
        this.name = name;
        this.ui = ui;
        eren.register(this);
        ui.log(name, "Watching out for Eren.");
    }

    @Override
    public void onErenTransform(int currentEnergy) {
        if (rnd.nextBoolean()) {
            ui.log(name, "Eren, be safe!");
        }
        if (currentEnergy < 20) {
            ui.log(name, "Rage, rage against the dying of the light");
        }
    }
}
