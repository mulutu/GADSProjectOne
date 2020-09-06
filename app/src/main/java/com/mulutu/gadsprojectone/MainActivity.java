package com.mulutu.gadsprojectone;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.mulutu.gadsprojectone.adaptar.ViewPagerAdapter;


public class MainActivity extends AppCompatActivity {

    private ViewPagerAdapter viewPagerAdapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Button _btnOpenSubmitPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        prepareView();

        preparePage();
    }

    public void preparePage(){
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new FragmentLearningLeaders(), "Learning Leaders");
        viewPagerAdapter.addFragment(new FragmentSkillIQLeaders(), "Skill IQ Leaders");

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void prepareView() {
        _btnOpenSubmitPage = (Button) findViewById(R.id.btnOpenSubmitPage);
        _btnOpenSubmitPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSubmitPage();
            }
        });
    }

    private void openSubmitPage() {
        Intent intent = new Intent(MainActivity.this, ProjectSubmitActivity.class);
        //intent.putExtra("farmId", farm.getFarmId());
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();

        viewPagerAdapter.notifyDataSetChanged();
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // handle button activities
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }*/

}
