package com.example.image;

import static com.squareup.picasso.Picasso.*;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;
public class MainActivity2 extends AppCompatActivity {
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ImageView ivPicture = (ImageView)
                findViewById(R.id.ivPicture2);
        String url =
                "https://cdn.discordapp.com/attachments/1108934342505398353/1111885062410084352/Tingyun01.jpg";
        if (url == null || url.equals("")) {
            Toast.makeText(MainActivity2.this, "Error",
                    Toast.LENGTH_LONG).show();
        }
        else {

            Picasso.with(MainActivity2.this).load(url).into(ivPicture);
        }
    } }