package me.carleslc.signalsfrommars.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import me.carleslc.signalsfrommars.R;

public class MainActivity extends AppCompatActivity {

    private EditText mNameField;
    private Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameField = (EditText) findViewById(R.id.nameEditText);
        mStartButton = (Button) findViewById(R.id.startButton);

        checkForNameListener(); // Disable start button until name is set

        mStartButton.setOnClickListener((view) -> { startStory(mNameField.getText().toString()); });
    }

    private void startStory(final String name) {
        Intent intent = new Intent(this, StoryActivity.class);
        intent.putExtra(getString(R.string.key_name), name);
        startActivity(intent);
    }

    private void checkForNameListener() {
        mStartButton.setEnabled(false);
        mNameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable e) {
                mStartButton.setEnabled(!mNameField.getText().toString().trim().isEmpty());
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });
    }
}
