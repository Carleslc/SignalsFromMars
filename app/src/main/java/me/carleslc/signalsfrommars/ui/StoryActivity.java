package me.carleslc.signalsfrommars.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import me.carleslc.signalsfrommars.R;
import me.carleslc.signalsfrommars.model.Page;
import me.carleslc.signalsfrommars.model.Story;

public class StoryActivity extends AppCompatActivity {

    private Story mStory;
    private ImageView mImageView;
    private TextView mTextView;
    private Button mChoice1, mChoice2;
    private Page mCurrentPage;
    private String mName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        mStory = new Story(this);
        mName = intent.getStringExtra(getString(R.string.key_name));

        mImageView = (ImageView) findViewById(R.id.storyImageView);
        mTextView = (TextView) findViewById(R.id.storyTextView);
        mChoice1 = (Button) findViewById(R.id.choiceButton1);
        mChoice2 = (Button) findViewById(R.id.choiceButton2);

        loadPage(0);
    }

    private void loadPage(int pageNumber) {
        mCurrentPage = mStory.getPage(pageNumber);

        mImageView.setImageDrawable(ContextCompat.getDrawable(this, mCurrentPage.getImageId()));

        // Add the name if placeholder included. Won't add if no placeholder is found
        String pageText = String.format(mCurrentPage.getText(), mName);
        mTextView.setText(pageText);

        if (mCurrentPage.isFinal()) {
            mChoice1.setVisibility(View.INVISIBLE);
            mChoice2.setText(getString(R.string.end_game));
            mChoice2.setOnClickListener((view) -> { finish(); });
        }
        else {
            mChoice1.setText(mCurrentPage.getChoiceOne().getText());
            mChoice2.setText(mCurrentPage.getChoiceTwo().getText());

            mChoice1.setOnClickListener((view) -> { loadPage(mCurrentPage.getChoiceOne().getNextPage()); });
            mChoice2.setOnClickListener((view) -> { loadPage(mCurrentPage.getChoiceTwo().getNextPage()); });
        }
    }

}
