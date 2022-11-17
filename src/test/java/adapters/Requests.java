package adapters;

public final class Requests {
    private static Requests instance;

    private Requests() {
    }

    public static Requests getInstance(String value) {
        if (instance == null) {
            instance = new Requests();
        }
        return instance;
    }

    public void get() {

    }
}
