package fr.lefebvre.exercicetd1c;

import static fr.lefebvre.exercicetd1c.ApplicationDemo.CHANNEL_ID;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class IncidentActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Button btvalider;
    private int notificationId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incident);

        findViewById(R.id.incident).setAlpha(0f);
        findViewById(R.id.Parametre).setAlpha(0f);
        findViewById(R.id.valider).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotificationOnChannel(CHANNEL_ID, NotificationCompat.PRIORITY_DEFAULT);
            }

            private void sendNotificationOnChannel(String channelId, int priority) {
                NotificationCompat.Builder notification = new NotificationCompat.Builder(getApplicationContext(), channelId)
                        .setSmallIcon(R.drawable.logo)
                        .setContentTitle( "Confirmation de Déclaration d'incident")
                        .setContentText("Votre déclaration d'incident a été pris en compte")
                        .setPriority(priority);

                ApplicationDemo.getNotificationManager().notify(++notificationId, notification.build());
            }
        });

        bottomNavigationView = findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.incident);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.restaure:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.incident:
                        return true;

                    case R.id.Parametre:
                        startActivity(new Intent(getApplicationContext(), ParametreActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }

                return false;
            }
        });
    }
}