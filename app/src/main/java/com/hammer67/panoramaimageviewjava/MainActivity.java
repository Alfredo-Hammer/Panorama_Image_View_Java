package com.hammer67.panoramaimageviewjava;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import co.gofynd.gravityview.GravityView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private GravityView gravityView;
    private boolean esSoportado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        if (esSoportado){
            this.gravityView.setImage(imageView, R.drawable.fondocelular).center();

        }
        else {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.fondocelular);
            imageView.setImageBitmap(bitmap);
        }
    }

    private void init() {
        this.imageView = findViewById(R.id.imageView);
        this.gravityView = GravityView.getInstance(getBaseContext());
        this.esSoportado = gravityView.deviceSupported();
    }

    @Override
    protected void onResume() {
        super.onResume();
        gravityView.registerListener();
    }

    @Override
    protected void onStop() {
        super.onStop();
        gravityView.unRegisterListener();
    }
}