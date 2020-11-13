package cl.desafiolatam.pruebadinamica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import api.Api;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate: Creando la actividad");
        Api service = cl.desafiolatam.pruebadinamica.api.RetroFitClient.getRetrofitInstance().create(Api.class);
        Call<cl.desafiolatam.pruebadinamica.beans.PreguntasLista> call = service.getAllQuestions();
//Async
        call.enqueue(new Callback<cl.desafiolatam.pruebadinamica.beans.PreguntasLista>() {
            @Override
            public void onResponse(Call<cl.desafiolatam.pruebadinamica.beans.PreguntasLista> call,
                                   Response<cl.desafiolatam.pruebadinamica.beans.PreguntasLista> response) {
                if(response != null) {
                    Log.d(TAG, response.toString());
                    for(int x = 0; x < response.body().getResults().size();
                        x++) {
                        Log.d(TAG, "Pregunta:"+response.body().getResults().get(x).getQuestion());
                    }
                }
            }
            @Override
            public void onFailure(Call<cl.desafiolatam.pruebadinamica.beans.PreguntasLista> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error: no pudimos  recuperar los datos de opentdb", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: Ha iniciado la actividad");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: Pausada la actividad");

    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: Hemos vuelto a la actividad");

        Toast.makeText(getApplicationContext(),"onResume: Hemos vuelto a la actividad", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: Se detuvo la actividad");

        Toast.makeText(getApplicationContext(),"onStop: Se ha detenido la actividad", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: Se destruyó la actividad");
        
        
    }

}
