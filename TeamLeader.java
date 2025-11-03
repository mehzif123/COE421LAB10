public class TeamLeader implements Observer {
    private final String name;
    private final UI ui;
    private int patience;
    private boolean done = false;

    public TeamLeader(String name, int patience, UI ui, Eren eren) {
        this.name = name;
        this.patience = patience;
        this.ui = ui;
        eren.register(this);
        ui.log(name, "On watch. Patience=" + patience);
    }

    @Override
    public void onErenTransform(int currentEnergy) {
        if (done) return;
        patience = Math.max(0, patience - 5);
        ui.log(name, "Saw transform. Patience now " + patience);

        if (patience == 10) ui.log(name, "My patience is waning!");
        if (patience == 5)  ui.log(name, "Is this entertaining?");
        if (patience == 0) {
            ui.log(name, "Omae wa mou shindeiru");
            done = true;
        }
    }
}
