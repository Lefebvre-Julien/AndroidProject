package fr.lefebvre.exercicetd1a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;

import fr.lefebvre.exercicetd1a.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         //findViewById(R.id.imageview1).setAlpha(0.5f);

        

        binding = ActivityMainBinding.inflate((getLayoutInflater()));
        setContentView(binding.getRoot());
        replaceFragment(new HistoriqueFragment());

        binding.bottomnavigationview.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.restaure:
                    replaceFragment(new HistoriqueFragment());
                    break;
                case R.id.incident:
                    replaceFragment(new IncidentFragment());
                    break;
                case R.id.Parametre:
                    replaceFragment(new ParametreFragment());
                    break;
            }

            return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout, fragment);
        fragmentTransaction.commit();

    }
}
