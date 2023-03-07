package com.vnc.randomdog.Home;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.vnc.randomdog.api.ApiService;
import com.vnc.randomdog.model.Dog;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeLogic {

    Context context;

    HomeEvent homeEvent;

    String message;

    public HomeLogic(Context context, HomeEvent homeEvent) {
        this.context = context;
        this.homeEvent = homeEvent;
    }

    void callApi(){

   ApiService.service.getDogImage().enqueue(new Callback<Dog>() {
       @Override
       public void onResponse(Call<Dog> call, Response<Dog> response) {

           Toast.makeText(context, "ok", Toast.LENGTH_SHORT).show();

           message = response.body().getMessage();
           homeEvent.onShowImageSuccess(message);
       }

       @Override
       public void onFailure(Call<Dog> call, Throwable t) {
            homeEvent.onShowImageFail();
       }
   });

    }

    public interface HomeEvent {
        void onShowImageSuccess(String message);

        void onShowImageFail();
    }
}
