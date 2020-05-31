package com.example.stulance;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import org.w3c.dom.Text;

import java.util.zip.Inflater;




public class drawer_menu extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_menu);


        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                new MyJobsFragment()).commit();


        BottomNavigationView bottomNav=findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);


        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(final MenuItem menuItem) {
                Fragment selectedFragment=null;
                switch (menuItem.getItemId()) {
                    case R.id.nav_message_left:
                        selectedFragment=new MessagesFragment();
                        break;
                    case R.id.nav_profile_left:
                        selectedFragment=new ProfileFragment();
                        break;
                    case R.id.nav_chat_left:
                        selectedFragment=new MessagesFragment();
                        break;
                    case R.id.nav_share_left:
                        return true;
                    case R.id.nav_send_left:
                        return true;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, selectedFragment).commit();
                drawerLayout.closeDrawers();
                return true;
            }

        });


    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment=null;
                    switch (menuItem.getItemId()) {
                        case R.id.nav_myjobs:
                            selectedFragment=new MyJobsFragment();
                            break;
                        case R.id.nav_browse:
                            selectedFragment=new BrowseFragment();
                            break;
                        case R.id.nav_add:
                            selectedFragment=new PostJobFragment();
                            break;
                        case R.id.nav_message:
                            selectedFragment=new MessagesFragment();
                            break;
                        case R.id.nav_profile:
                            selectedFragment=new ProfileFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, selectedFragment).commit();
                    return  true;

                }
            };
}
