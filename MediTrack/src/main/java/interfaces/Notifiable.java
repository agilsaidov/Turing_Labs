package interfaces;

public interface Notifiable {

    void sendNotification(String message);

    default void notifyWithPrefix(String message) {
        System.out.println("MediTrack Alert: " + message);
    }

    String SYSTEM_NAME = "MediTrack";

}
