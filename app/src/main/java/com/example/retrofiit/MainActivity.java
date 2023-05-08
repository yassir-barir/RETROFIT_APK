package com.example.retrofiit;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        @SuppressLint({"MissingInflatedId", "LocalSuppress"})  final TextView Posttitletv = findViewById(R.id.textv);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(GsonConverterFactory.create()).build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Call<List<POST>> call = apiInterface.getPost("1");

         call.enqueue(new Callback<List<POST>>() {
             @Override
             public void onResponse(Call<List<POST>> call, Response<List<POST>> response) {
                 Posttitletv.setText(response.body().get(0).toString());
             }

             @Override
             public void onFailure(Call<List<POST>> call, Throwable t) {
                 Posttitletv.setText(t.getMessage());
             }
         });
}
}