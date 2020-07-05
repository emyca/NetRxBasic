package ua.kh.em.netrxbasic.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import ua.kh.em.netrxbasic.R;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    FrameLayout fragmentPost;
    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupToolbar();
        initViews();
        updateFragment(PostFragment.newInstance());
        handleFragmentNav();
    }

    private void setupToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void initViews() {
        fragmentPost = findViewById(R.id.fragment_posts);
        bottomNav = findViewById(R.id.bottom_nav);
    }

    private void handleFragmentNav() {
        bottomNav.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.bn_item_post:
                    updateFragment(PostFragment.newInstance());
                    break;
                case R.id.bn_item_photo:
                    fragmentPost.setVisibility(View.GONE);
                    updateFragment(PhotoFragment.newInstance());
                    break;
                case R.id.bn_item_user:
                    fragmentPost.setVisibility(View.GONE);
                    updateFragment(UserFragment.newInstance());
                    break;
            }
            return true;
        });
    }

    private void updateFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.bnav_frame_container,fragment).commit();
    }
}