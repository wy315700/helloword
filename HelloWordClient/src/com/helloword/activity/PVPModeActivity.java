package com.helloword.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.helloword.R;
import com.helloword.service.GameService;
import com.helloword.service.NetworkService;

public class PVPModeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvp_mode);
    }

    public void goPVPGame() {
        Intent intent = new Intent(this, PVPGameActivity.class);
        startActivity(intent);
    }

    public void goCet4PK(View view) {
        NetworkService networkService = new NetworkService(this);
        if (networkService.isConnected()) {
            new GetPKGamesInBackground().execute("1");
        } else {
            Toast.makeText(getApplicationContext(),
                    "Please connect to the internet", Toast.LENGTH_SHORT)
                    .show();
        }
    }

    public void goCet6PK(View view) {
//        Toast.makeText(getApplicationContext(), "你就不能点四级的？", Toast.LENGTH_SHORT)
//                .show();
        // ===========test=========
            Intent intent = new Intent(this, PVPEndActivity.class);
            startActivity(intent);
        // =========================
    }

    public void goIeltsPK(View view) {
        Toast.makeText(getApplicationContext(), "你就不能点四级的？", Toast.LENGTH_SHORT)
                .show();
    }

    public void goToeflPK(View view) {
        Toast.makeText(getApplicationContext(), "你就不能点四级的？", Toast.LENGTH_SHORT)
                .show();
    }

    public void goGrePK(View view) {
        Toast.makeText(getApplicationContext(), "你就不能点四级的？", Toast.LENGTH_SHORT)
                .show();
    }

    public void goMorePK(View view) {
        Toast.makeText(getApplicationContext(), "你就不能点四级的？", Toast.LENGTH_SHORT)
                .show();
    }

    private class GetPKGamesInBackground extends
            AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            GameService gameService = new GameService(getApplication());
            return gameService.getPKPuzzles(params[0]);

        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            if (result.equals("success")) {
                goPVPGame();
            } else {
                Toast.makeText(getApplicationContext(), result,
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

}
