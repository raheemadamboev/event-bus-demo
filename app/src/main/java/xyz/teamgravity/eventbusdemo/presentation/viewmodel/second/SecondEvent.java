package xyz.teamgravity.eventbusdemo.presentation.viewmodel.second;

public class SecondEvent {

    private final String message;

    public SecondEvent(String message) {
        try {
            Thread.sleep(5_000);
        } catch (Exception ignored) {
        }
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
