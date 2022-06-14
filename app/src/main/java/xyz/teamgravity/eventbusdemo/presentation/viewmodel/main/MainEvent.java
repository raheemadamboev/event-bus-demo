package xyz.teamgravity.eventbusdemo.presentation.viewmodel.main;

public class MainEvent {

    private final String message;

    public MainEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
