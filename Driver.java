public class Driver {
    public static void main(String[] args) {
        UI ui = new UI();
        Eren e = new Eren(50, ui);
        TeamLeader Levi = new TeamLeader("Levi Ackerman", 20, ui, e);
        Friend Mikasa = new Friend("Mikasa", ui, e);
        Friend Armin  = new Friend("Armin",  ui, e);
        Titan Armor    = new Titan("Armored Titan", ui, e);
        Titan Colossal = new Titan("Colossal Titan", ui, e);
    }
}
