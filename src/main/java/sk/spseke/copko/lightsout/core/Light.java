package sk.spseke.copko.lightsout.core;

public class Light {
    private boolean on;

    public Light(){
        on = false;
    }

    public void toggle(){
        this.on = !this.on;
    }

    public boolean isOn() {
        return this.on;
    }
}
