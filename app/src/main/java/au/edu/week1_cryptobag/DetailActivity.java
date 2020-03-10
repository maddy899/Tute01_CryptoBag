package au.edu.week1_cryptobag;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.net.Uri;
import java.text.NumberFormat;
import java.util.ArrayList;

import static au.edu.week1_cryptobag.Coin.searchCoin;


public class DetailActivity extends AppCompatActivity {
  private ImageView mSearch;
  private TextView mName;
    private TextView mSymbol;
    private TextView mValue;
    private TextView mChange1h;
    private TextView mChange24h;
    private TextView mChange7d;
    private TextView mMarketcap;
    private TextView mVolume;
    private Coin mCoin;

  private static final String TAG = "Detail Activity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        mName = findViewById(R.id.tvName);
        mSymbol = findViewById(R.id.tvSymbol);
        mValue = findViewById(R.id.tvValueField);
        mChange1h = findViewById(R.id.tvChange1hField);
        mChange24h = findViewById(R.id.tvChange24hField);
        mChange7d = findViewById(R.id.tvChange7dField);
        mMarketcap = findViewById(R.id.tvMarketcapField);
        mVolume = findViewById(R.id.tvVolume24hField);
        mSearch = findViewById(R.id.ivSearch);


        Intent intent = getIntent();
        int position = intent.getIntExtra(MainActivity.EXTRA_MESSAGE, 0);

        mCoin = Coin.getCoins().get(position);

        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        setTitle(mCoin.getName());
        mName.setText(mCoin.getName());
        mSymbol.setText(mCoin.getSymbol());
        mValue.setText(formatter.format(mCoin.getValue()));

        mChange1h.setText(String.valueOf(mCoin.getChange1h()) + "%");
        mChange24h.setText(String.valueOf(mCoin.getChange24h()) + "%");
        mChange7d.setText(String.valueOf(mCoin.getChange7d()) + "%");

        mMarketcap.setText(formatter.format(mCoin.getMarketcap()));
        mVolume.setText(formatter.format(mCoin.getVolume()));
        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchCoin(mCoin.getName());
            }
        });

    }
    private void searchCoin(String name) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=" + name));
        startActivity(intent);
    }
    }

