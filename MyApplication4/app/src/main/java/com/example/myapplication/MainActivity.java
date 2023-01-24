package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;



    public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SectionsPagerAdapter pagerAdapter =  new SectionsPagerAdapter(this);
        ViewPager2 pager = (ViewPager2) findViewById(R.id.pager);
       // pager.setAdapter(pagerAdapter);
        //Attach the ViewPager to the TabLayout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        new TabLayoutMediator(tabLayout, pager, (tab, position) -> {
            tab.setText(getPageTitle(position));
            pager.setCurrentItem(position);
        }).attach();
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the app bar.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);

    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_create_order:
                Intent intent = new Intent(this, OrderActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }




        public class SectionsPagerAdapter extends FragmentStateAdapter {
        public SectionsPagerAdapter(FragmentActivity fa) {
            super(fa);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return new TopFragment();
                case 1:
                    return new StoreFragment();
                case 2:
                    return new PastaFragment();
                case 3:
                    return new PizzaFragment();
            }
            return null;
        }

        @Override
        public int getItemCount() {
            return 4;
        }

    }
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return getResources().getText(R.string.home_tab);
            case 1:
                return getResources().getText(R.string.pizza_tab);
            case 2:
                return getResources().getText(R.string.pasta_tab);
            case 3:
                return getResources().getText(R.string.store_tab);
        }
        return null;
    }
}
