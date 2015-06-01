package demos.ness.com.materialdesigndemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @InjectView(R.id.topToolbar)
    Toolbar mTopToolbar;
    @InjectView(R.id.ivElevation)
    ImageView ivElavation;
    @InjectView(R.id.bottomToolbar)
    Toolbar mBottomToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        setSupportActionBar(mTopToolbar);
        mTopToolbar.setNavigationIcon(R.mipmap.ic_launcher);
        mTopToolbar.setLogoDescription("T");
        ViewCompat.setElevation(ivElavation, 60);
       // ViewCompat.setTranslationZ(ivElavation, 600);

     /*   ivElavation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivElavation.animate().translationX(ivElavation.getTranslationX()+200).setDuration(500).start();
            }
        });
*/
        mBottomToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return true;
            }
        });
        mBottomToolbar.inflateMenu(R.menu.menu_bottom);
    }


    @OnClick(R.id.ivElevation)
    public void gotoNext(View v) {
        Intent nextIntent = new Intent(this, NextActivity.class);
        startActivity(nextIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
