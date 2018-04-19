package abhishekint.com.roundimageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import abhishekint.com.roundimage.RoundImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RoundImageView roundImageView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        roundImageView=(RoundImageView)findViewById(R.id.round_image);
        button=(Button)findViewById(R.id.btn);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        roundImageView.setCircleColor(getResources().getColor(R.color.colorPrimary));
        roundImageView.setCircleText("Button Clicked");
        roundImageView.setCircleTextColor(getResources().getColor(R.color.colorAccent));
    }
}
