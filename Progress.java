package com.example.ejerlab03vf;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;

public class Progress extends Fragment {
    protected static final int TIMER_RUNTIME = 10000;
    protected boolean nbActivo;
    protected ProgressBar nProgressBar;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Thread timerThread = new Thread(){
            @Override
            public void run(){
                nbActivo = true;
                try{
                    int espera1 = 0;
                    while(nbActivo && (espera1 < TIMER_RUNTIME)){
                        sleep(100);
                        if(nbActivo){
                            espera1 += 100;
                            actualizarProgress(espera1);
                        }
                    }
                } catch(InterruptedException e){
                } finally{
                    onContinuar();
                }
            }
        };
        timerThread.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =   inflater.inflate(R.layout.fragment_progress,container,false);
        nProgressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_progress, container, false);
    }
    public void actualizarProgress(final int timePassed){
        if(null != nProgressBar){
            final int progress = nProgressBar.getMax() * timePassed
                    /TIMER_RUNTIME;
            nProgressBar.setProgress(progress);
        }
    }
    public void onContinuar(){
        startActivity(new Intent("com.example.MONEDA"));
    }


}

