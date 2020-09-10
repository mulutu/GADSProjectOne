package com.mulutu.gadsprojectone;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.mulutu.gadsprojectone.util.ApiUtils;
import com.mulutu.gadsprojectone.util.GetDataService;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectSubmitActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();

    Toolbar toolbar;

    private EditText _firstName;
    private EditText _lastName;
    private EditText _email;
    private EditText _githubLink;
    private Button _btnSubmitFarm;

    private GetDataService getDataService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setFullScreenView();

        prepareToolbar();

        getDataService = ApiUtils.GetDataService();

        prepareView();
    }

    private void prepareToolbar() {
        setContentView(R.layout.activity_project_submit);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    protected void setFullScreenView(){
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_IMMERSIVE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            );
            getWindow().setStatusBarColor(Color.TRANSPARENT);
            getWindow().setNavigationBarColor(Color.TRANSPARENT);
        }
    }

    private void prepareView() {
        TextView txt = (TextView) findViewById(R.id.txtProjectSubmission);
        txt.setPaintFlags(txt.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        _firstName = (EditText) findViewById(R.id.firstName);
        _lastName = (EditText) findViewById(R.id.lastName);
        _email = (EditText) findViewById(R.id.email);
        _githubLink = (EditText) findViewById(R.id.githubLink);
        _btnSubmitFarm = (Button) findViewById(R.id.btnSubmitFarm);
        _btnSubmitFarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDecisionDialog();
            }
        });
    }

    private void showCustomAlertDialog() {
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(this).inflate(R.layout.my_dialog_red_alert, viewGroup, false);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void showCustomSuccessDialog() {
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(this).inflate(R.layout.my_dialog_tick_green, viewGroup, false);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void showCustomDecisionDialog() {
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(this).inflate(R.layout.my_dialog_you_sure, viewGroup, false);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);
        final AlertDialog alertDialog = builder.create();

        TextView _no = (TextView) dialogView.findViewById(R.id.txtclose);
        _no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        Button _yes = (Button) dialogView.findViewById(R.id.buttonOk);
        _yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitProject();
            }
        });
        alertDialog.show();
    }


    public void submitProject() {
        _firstName = (EditText) findViewById(R.id.firstName);
        _lastName = (EditText) findViewById(R.id.lastName);
        _email = (EditText) findViewById(R.id.email);
        _githubLink = (EditText) findViewById(R.id.githubLink);

        String firstName = _firstName.getText().toString();
        String lastName = _lastName.getText().toString();
        String email = _email.getText().toString();
        String githubLink = _githubLink.getText().toString();

        Map<String, String> params = new HashMap<String, String>();
        params.put("entry.1824927963", email);
        params.put("entry.1877115667", firstName);
        params.put("entry.2006916086", lastName);
        params.put("entry.284483984", githubLink);

        getDataService.savePost(params).enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
                if (response.isSuccessful()) {
                    showCustomSuccessDialog();
                    Log.i(TAG, "post submitted to API." + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {
                showCustomAlertDialog();
                Log.e(TAG, "Unable to submit post to API.");
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}