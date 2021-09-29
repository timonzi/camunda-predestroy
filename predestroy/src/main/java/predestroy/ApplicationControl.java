package predestroy;

import java.io.Serializable;

public class ApplicationControl implements Serializable {

    private static final long serialVersionUID = -4823211125287559312L;

    public enum Phase {
        BEFORE_STARTUP_COORDINATORS,
        AFTER_STARTUP_COORDINATORS,
        START_APPLICATION,
        SHUTDOWN_APPLICATION,
        BEFORE_SHUTDOWN_COORDINATORS,
        AFTER_SHUTDOWN_COORDINATORS,
    }

    private final Phase phase;


    public ApplicationControl(final Phase phase) {
        this.phase = phase;
    }


    public Phase getPhase() {
        return this.phase;
    }


    @Override
    public String toString() {
        return "ApplicationController{" +
               "phase=" + this.phase +
               '}';
    }

}
