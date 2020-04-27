package com.mario.alimenta_al_forneo;

import android.widget.Toast;

public class Modelo extends Thread{
    private int salud;
    private int felicidad;
    private int hambre;
    private long tiempo=10000;
    private final long createdMillis;

    public Modelo(int salud, int felicidad, int hambre){
      this.salud=salud;
      this.hambre=hambre;
      this.felicidad=felicidad;
        createdMillis = System.currentTimeMillis();
    }
    public void Temporizador(){

    }
    public int secondsCounter() {
        long nowMillis = System.currentTimeMillis();
        return (int)((nowMillis - this.createdMillis) / 1000);
    }

    @Override
    public void run() {
        super.run();
        while (true){
            if(secondsCounter() == 10){


            }
        }
    }
    }


