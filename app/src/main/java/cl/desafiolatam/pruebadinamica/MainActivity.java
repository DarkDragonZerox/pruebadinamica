package cl.desafiolatam.pruebadinamica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate: Creando la actividad");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: Ha iniciado la actividad");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: Pausada la actividad");

    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: Hemos vuelto a la actividad");

        Toast.makeText(getApplicationContext(),"onResume: Hemos vuelto a la actividad", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: Se detuvo la actividad");

        Toast.makeText(getApplicationContext(),"onStop: Se ha detenido la actividad", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: Se destruyó la actividad");
        
        
    }

}
