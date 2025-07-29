package interfaces;

public interface Notifiable {

    void sendNotification(String message);

    default void notifyWithPrefix(String message) {
        System.out.println("MediTrack Alert: " + message);
    }

    static final String SYSTEM_NAME = "MediTrack";

}
