package co.jjsolarte.uno;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import co.jjsolarte.uno.extras.OnSwipeTouch;
import co.jjsolarte.uno.fragments.AyudaFragment;
import co.jjsolarte.uno.fragments.ConfigFragment;
import co.jjsolarte.uno.fragments.PerfilFragment;

public class ContainerActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;

    FrameLayout frameLayout;

    AyudaFragment ayudaFragment;
    ConfigFragment configFragment;
    PerfilFragment perfilFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        bottomNav = findViewById(R.id.container_nav);
        frameLayout = findViewById(R.id.containerFrame);

        ayudaFragment = new AyudaFragment();
        configFragment = new ConfigFragment();
        perfilFragment = new PerfilFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerFrame,configFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.menu_ayuda:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.containerFrame,ayudaFragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .commit();
                        menuItem.setChecked(true);
                        break;
                    case R.id.menu_perfil:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.containerFrame,perfilFragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .commit();
                        menuItem.setChecked(true);
                        break;
                    case R.id.menu_config:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.containerFrame,configFragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .commit();
                        menuItem.setChecked(true);
                        break;
                }
                return false;
            }
        });

        frameLayout.setOnTouchListener(new OnSwipeTouch(this){

            public void onSwipeRight() {
                Toast.makeText(ContainerActivity.this, "ok", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
