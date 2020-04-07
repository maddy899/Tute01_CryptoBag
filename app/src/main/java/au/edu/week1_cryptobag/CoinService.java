package au.edu.week1_cryptobag;

import au.edu.week1_cryptobag.Entities.CoinLoreResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CoinService {
    @GET("/api/tickers/")
    Call<CoinLoreResponse> getCoins();

}
