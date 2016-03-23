package com.goodcodeforfun.minimaldatabindingexample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.goodcodeforfun.minimaldatabindingexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    User user;
    Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        user = new User();
        binding.setUser(user);
        binding.nameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                user.name.set(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.showMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessage();
            }
        });
    }

    public void showMessage() {
        if (null != mToast)
            mToast.cancel();
        String message = String.format(
                getString(R.string.message_pattern),
                user.name.get(),
                user.messageCount
        );
        mToast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        mToast.show();
        user.messageCount++;
    }
}
