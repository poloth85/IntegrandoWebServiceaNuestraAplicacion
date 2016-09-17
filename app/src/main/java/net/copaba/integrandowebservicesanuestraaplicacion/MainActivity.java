package net.copaba.integrandowebservicesanuestraaplicacion;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import net.copaba.integrandowebservicesanuestraaplicacion.adapter.PageAdapter;

import net.copaba.integrandowebservicesanuestraaplicacion.view.fragment.PerfilViewFragment;
import net.copaba.integrandowebservicesanuestraaplicacion.view.fragment.RecyclerViewFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.MiActionBar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();
        ImageButton imageButton = (ImageButton) toolbar.findViewById(R.id.btnFav);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PageAdapter pageAdapter = (PageAdapter) viewPager.getAdapter();
                Fragment fragment = pageAdapter.getItem(0);
                RecyclerViewFragment recyclerViewFragment = (RecyclerViewFragment) fragment;
                recyclerViewFragment.irActivity2(view);
            }
        });
        /*

*/
        if(toolbar != null){
            setSupportActionBar(toolbar);
        }

    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilViewFragment());

        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_doghose);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_dogface);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mContacto:
                Intent intentContacto = new Intent(this,ActivityContacto.class);
                startActivity(intentContacto);
                break;
            case R.id.mAbaut:
                Intent intentAbout = new Intent(this, ActivityAbout.class);
                startActivity(intentAbout);
                break;
            case R.id.mConfig:
                Intent intentConfig = new Intent(this, ActivityConfiguraCuenta.class);
                startActivity(intentConfig);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

