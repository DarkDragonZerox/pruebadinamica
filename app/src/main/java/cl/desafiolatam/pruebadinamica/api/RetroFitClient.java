package cl.desafiolatam.pruebadinamica.api;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class RetroFitClient {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://opentdb.com/";
    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
//GSON converter//
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
