package xyz.teamgravity.eventbusdemo.presentation.viewmodel.second;

public class SecondEvent {

    private final String message;

    public SecondEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
