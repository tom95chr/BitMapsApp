package com.example.tomek.bitmapsapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView obraz;
    private TextView napis;
    private Bitmap bmp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        obraz = (ImageView) findViewById(R.id.imageView1);
        napis = (TextView) findViewById(R.id.textView1);
        Bitmap temp = BitmapFactory.decodeResource(getResources(), R.drawable.room);
        bmp=temp.copy(Bitmap.Config.ARGB_8888, true);
    }
    public void alibaba(View v){
        Bitmap temp = BitmapFactory.decodeResource(getResources(), R.drawable.ali);
        bmp=temp.copy(Bitmap.Config.ARGB_8888, true);
        kliknij(v);
    }
/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }*/
    public void kliknij( View v)
    {
        rysuj();
        obraz.setImageBitmap(bmp);
        napis.setText( obraz.getWidth() + " x " + obraz.getHeight() +
                " / " + bmp.getWidth() + " x " + bmp.getHeight());
    }
    private void rysuj()
    {
        int szer = bmp.getWidth(), wys = bmp.getHeight();
        int kolor, r, g, b;
        Canvas c = new Canvas(bmp);
        Paint p = new Paint();
        for( int x = 0; x < szer; x ++)
        {
            for( int y = 0; y < wys; y ++)
            {
                kolor = bmp.getPixel(x, y);
                r = Color.red( kolor);
                g = Color.green(kolor);
                b = Color.blue(kolor);
                bmp.setPixel(x, y, Color.rgb( b, g, r));
            }
        }
        p.setColor(Color.WHITE);
        p.setStyle(Paint.Style.STROKE);
        c.drawRect(0, 0, szer-1, wys-1, p);
    }
    public void kliknij_kolka( View v)
    {
        rysuj_kolka();
        obraz.setImageBitmap(bmp);
        napis.setText( obraz.getWidth() + " x " + obraz.getHeight() +
                " / " + bmp.getWidth() + " x " + bmp.getHeight());
    }
    private void rysuj_kolka()
    {
        int ile = 1000;
        int szer = bmp.getWidth(), wys = bmp.getHeight();
        int x, y, kolor;
        Canvas c = new Canvas(bmp);
        Paint p = new Paint();
        p.setStyle(Paint.Style.STROKE);
        Random rand = new Random();
        for( int i = 0; i < ile; i ++)
        {
            x = rand.nextInt( szer);
            y = rand.nextInt( wys);
            kolor = bmp.getPixel(x, y);
            p.setColor( kolor);
            c.drawCircle( x,  y, 10, p);
        }
        p.setColor(Color.WHITE);
        p.setStyle(Paint.Style.STROKE);
        c.drawRect(0, 0, szer-1, wys-1, p);
    }
    public void kliknij_kreski( View v)
    {
        rysuj_kreski();
        obraz.setImageBitmap(bmp);
        napis.setText( obraz.getWidth() + " x " + obraz.getHeight() +
                " / " + bmp.getWidth() + " x " + bmp.getHeight());
    }
    private void

    rysuj_kreski()
    {
        int ile = 1000;
        int szer = bmp.getWidth(), wys = bmp.getHeight();
        int x, y, kolor, r, g, b;
        int d = 20;
        Canvas c = new Canvas(bmp);
        Paint p = new Paint();
        p.setStyle(Paint.Style.STROKE);
        Random rand = new Random();
        for( int i = 0; i < ile; i ++)
        {
            x = rand.nextInt( szer);
            y = rand.nextInt( wys);
            kolor = bmp.getPixel(x, y);
            p.setColor( kolor);
            r = Color.red( kolor);
            g = Color.green(kolor);
            b = Color.blue(kolor);
            c.drawLine( x-d, y-d, x+d, y+d, p);
            c.drawLine( x-d, y+d, x+d, y-d, p);
        }
        p.setColor(Color.WHITE);
        p.setStyle(Paint.Style.STROKE);
        c.drawRect(0, 0, szer-1, wys-1, p);
    }
}




