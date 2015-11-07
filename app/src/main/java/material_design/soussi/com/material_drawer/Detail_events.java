package material_design.soussi.com.material_drawer;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Fade;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;
import material_design.soussi.com.material_drawer.model.Events;

public class Detail_events extends AppCompatActivity {

    public static final String MY_OBJECT = "MY_OBJECT";
    @InjectView(R.id.toolbar2)
    Toolbar toolbar;
    @InjectView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;

    @InjectView(R.id.backgroundImageView)
    ImageView backgroundImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_events);

        ButterKnife.inject(this);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setupWindowAnimations2(); //Exit animation
                finish();
            }
        });

        //animation
        setupWindowAnimations();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       Events myObject = (Events) getIntent().getParcelableExtra(MY_OBJECT);//get intent from recylerview fragment
        collapsingToolbar.setTitle(myObject.getText());

        supportPostponeEnterTransition();

        Picasso.with(this).load(myObject.getImageUrl()).centerCrop().fit().into(backgroundImageView, new Callback() {
            @Override
            public void onSuccess() {
                supportStartPostponedEnterTransition();
            }

            @Override
            public void onError() {

            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void setupWindowAnimations() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Fade fade = new Fade();
            getWindow().setReturnTransition(fade);
        }
    }

    private void setupWindowAnimations2() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Fade fade = new Fade();
            getWindow().setExitTransition(fade);
        }
    }

}
