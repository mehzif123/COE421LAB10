import java.time.LocalTime;

public class UI {
    public synchronized void log(String who, String msg) {
        System.out.printf("[%s] %-18s | %s%n", LocalTime.now().withNano(0), who, msg);
    }
}
