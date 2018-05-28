package com.example.android.mvp_app.ui;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.mvp_app.R;
import com.example.android.mvp_app.data.model.Attendee;
import com.example.android.mvp_app.ui.login.LoginContract;
import com.example.android.mvp_app.ui.login.LoginPresenter;
import com.example.android.mvp_app.utils.mvp.BaseView;
import com.example.android.mvp_app.utils.mvp.BaseViewActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseViewActivity implements LoginContract.View{

    @BindView(R.id.idEditText)
    EditText idEditText;

    @BindView(R.id.comEditText)
    EditText comEditText;

    @BindView(R.id.typeEditText)
    EditText typeEditText;

    @BindView(R.id.saveButton)
    Button saveButton;


    String comValue;
    String idValue;
    String typeValue;

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new LoginPresenter(this);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getId();
                getCom();
                getType();
                presenter.updateAttendeeList(idValue, comValue, typeValue);
            }
        });
    }

    public void getId()
    {
        idValue = idEditText.getText().toString();
        if(TextUtils.isEmpty(idValue))
        {
            idEditText.setError("Field cannot be left blank");
        }
    }

    public void getCom()
    {
        comValue = comEditText.getText().toString();
        if(TextUtils.isEmpty(comValue))
        {
            idEditText.setError("Field cannot be left blank");
        }
    }

    public void getType()
    {
        typeValue = typeEditText.getText().toString();
        if(TextUtils.isEmpty(typeValue))
        {
            idEditText.setError("Field cannot be left blank");
        }
    }


    @Override
    public void showMymessae(boolean value) {
        if(value == true)
            Toast.makeText(this, "ho gagya ",Toast.LENGTH_LONG ).show();
        else
            Toast.makeText(this, "nai gagya ",Toast.LENGTH_LONG ).show();
    }

    public void check(boolean b)
    {
        if (b == true) {
            Toast.makeText(getApplicationContext(), "updated", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_LONG).show();
        }
    }





    @Override
        public void showToastMessage(String message) {

        }

        @Override
        public void setProgressBar(boolean show) {

        }

        @Override
        public Context getContext() {
            return this;
        }

}

