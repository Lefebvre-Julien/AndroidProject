package fr.lefebvre.exercicetd1b;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottomnavigationview);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, new RestaureFragment()).commit();
        findViewById(R.id.valider).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
     //   findViewById(R.id.restaure).setAlpha(0f);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.restaure:
                            selectedFragment = new RestaureFragment();
                            break;
                        case R.id.incident:
                            selectedFragment = new IncidentFragment();
                            break;
                        case R.id.Parametre:
                            selectedFragment = new ParametreFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, selectedFragment).commit();
               return true;

                }
            };
}