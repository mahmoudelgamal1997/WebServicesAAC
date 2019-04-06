package com.example2017.android.webservicesaac;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example2017.android.webservicesaac.ViewModel.UserViewModel;
import com.example2017.android.webservicesaac.model.UserData;


public class MainActivity extends AppCompatActivity {

    TextView txt;

    UserViewModel userViewModel;
    Button but;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        txt = (TextView) findViewById(R.id.text);
        but=(Button)findViewById(R.id.button);

        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);


        userViewModel.getLiveDataVal().observe(this, new Observer<UserData>() {
            @Override
            public void onChanged(@Nullable UserData userData) {
                Log.e("name",""+userData.getName()+"");

            }
        });





    }



}
