package todo.codekon.de.todo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import todo.codekon.de.todo.R;

public class SplashScreenActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_splash);
        imageView.setAnimation(animation);

        Handler handler =  new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
                finish();
            }
        }, 6000);
    }
}
