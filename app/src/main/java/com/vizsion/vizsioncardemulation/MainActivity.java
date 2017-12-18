package com.vizsion.vizsioncardemulation;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.handleActivity(this);
    }

    private void handleActivity(Context c) {

        EditText accountNumber = (EditText)findViewById(R.id.cardNumber);

        accountNumber.setText(AccountStorage.GetAccount(getApplicationContext()));
        accountNumber.addTextChangedListener(new AccountUpdater());
    }

    private class AccountUpdater implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            // Not implemented.
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // Not implemented.
        }

        @Override
        public void afterTextChanged(Editable s) {
            String account = s.toString();
            AccountStorage.SetAccount(getApplicationContext(), account);
        }
    }
}
