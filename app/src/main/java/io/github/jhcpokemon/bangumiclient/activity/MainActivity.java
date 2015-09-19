package io.github.jhcpokemon.bangumiclient.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.github.jhcpokemon.bangumiclient.R;
import io.github.jhcpokemon.bangumiclient.dialog.GetIdDialog;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.tool_bar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        SharedPreferences sharedPreferences = getPreferences(MODE_APPEND);
        if (!sharedPreferences.getString(GetIdDialog.USER_ID,"").equals("")){
            //TODO Show block in Grid view
        }else {
            //TODO Hide block in Grid view
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.login_menu_item:
                GetIdDialog dialog = new GetIdDialog();
                dialog.show(getFragmentManager(),GetIdDialog.USER_ID);
                break;
            case R.id.setting_menu_item:
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
