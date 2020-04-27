package com.mario.alimenta_al_forneo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ActionMenuView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SlidingDrawer;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CostumeDialog.CostumeDialogInterface {
    private static ImageView foraneo;
    private ImageButton ajustes,inventario,otso,salud;
    private TextView dinero,felicidad,hambre,vida,nombre;
    private DrawerLayout mDrawerLayout;
    private NavigationView naviView;
    public SoundPool sp;
    public int flujoDeMusia = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Sonido
        sp = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        flujoDeMusia = sp.load(this,R.raw.click,1);
        //Navaigation Drawer
        naviView = findViewById(R.id.naviVew);
        mDrawerLayout  = findViewById(R.id.drawerLayout);

        /* images bottons */

        ajustes = findViewById(R.id.imgbtn_ajustes);
        ajustes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
        inventario = findViewById(R.id.img_btn_Inv);
        otso = findViewById(R.id.img_btn_otso);
        salud = findViewById(R.id.img_btn_farmacia);
        salud.setOnClickListener(this);

        /* txt views */
        nombre = findViewById(R.id.txt_v_nombre);
        dinero = findViewById(R.id.txt_view_dinero);
        felicidad = findViewById(R.id.txt_v_happy);
        hambre = findViewById(R.id.txt_v_comida);
        vida = findViewById(R.id.txt_v_vida);

        /* images */

        foraneo = findViewById(R.id.img_foraneo);

    }
    public static void setForaneo(int f){

        foraneo.setImageResource(f);
    }

    private void openDialog() {
        CostumeDialog costumeDialog = new CostumeDialog();
        costumeDialog.show(getSupportFragmentManager(),"Costume Dialog");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_btn_farmacia:
                play_sp();
                naviView.getMenu().clear();
                naviView.inflateMenu(R.menu.navigation_menu);
                naviView.removeHeaderView(naviView.getHeaderView(0));
                naviView.inflateHeaderView(R.layout.header_layout2);
                mDrawerLayout.openDrawer(naviView);
                break;
            case R.id.img_btn_Inv:
                play_sp();
                naviView.getMenu().clear();
                naviView.inflateMenu(R.menu.navigation_menu2);
                naviView.removeHeaderView(naviView.getHeaderView(0));
                naviView.inflateHeaderView(R.layout.header_layout3);
                mDrawerLayout.openDrawer(naviView);
                break;
            case R.id.img_btn_otso:
                play_sp();
                naviView.getMenu().clear();
                naviView.inflateMenu(R.menu.navigation_menu3);
                naviView.removeHeaderView(naviView.getHeaderView(0));
                naviView.inflateHeaderView(R.layout.header_layout);
                mDrawerLayout.openDrawer(naviView);
                break;
        }
    }

    private void play_sp(){
        sp.play(flujoDeMusia,1,1,0,0,1);
    }
    @Override
    public void apllytext(String Name) {
        nombre.setText(Name);

    }
}
