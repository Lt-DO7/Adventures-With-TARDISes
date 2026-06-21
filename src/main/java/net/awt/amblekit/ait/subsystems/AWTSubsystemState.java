package net.awt.amblekit.ait.subsystems;

public class AWTSubsystemState {
    private String id;
    private boolean connected;
    private boolean enabled;
    private int health;

    public AWTSubsystemState() {
    }

    public AWTSubsystemState(String id, int maxHealth) {
        this.id = id;
        this.health = maxHealth;
    }

    public String id() {
        return id;
    }

    public boolean connected() {
        return connected;
    }

    public void connected(boolean connected) {
        this.connected = connected;
    }

    public boolean enabled() {
        return enabled;
    }

    public void enabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int health() {
        return health;
    }

    public void health(int health) {
        this.health = health;
    }

    public boolean isBroken() {
        return health <= 0;
    }
}
