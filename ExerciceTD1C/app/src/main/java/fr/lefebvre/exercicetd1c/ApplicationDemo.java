package fr.lefebvre.exercicetd1c;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import java.util.Objects;

public class ApplicationDemo extends Application {
    public static final String CHANNEL_ID = "channel1"; //Constante privée

    public static NotificationManager getNotificationManager() { //Accesseur
        return notificationManager;
    }

    private static NotificationManager notificationManager;  //Attribut privé

    private void createNotificationChannel(String name, String description, int importance) {
        //Pour API 26+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance); //Déclarer la notification
            channel.setDescription(description);//Affecter une description
            //Possibilité de modifier 1 seule fois
            notificationManager = getSystemService(NotificationManager.class);  //MAJ
            Objects.requireNonNull(notificationManager).createNotificationChannel(channel);
        }
    }

    @Override
    public void onCreate(){
        super.onCreate();
        createNotificationChannel("channel", "Channel pour l'application Zebulon", NotificationManager.IMPORTANCE_DEFAULT);
    }

}
