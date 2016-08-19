package me.carleslc.signalsfrommars.model;

import android.content.Context;

import me.carleslc.signalsfrommars.R;

public class Story {
    private Page[] mPages;

    public Story(Context context) {
        mPages = new Page[7];

        mPages[0] = new Page(
                R.drawable.page0,
                context.getString(R.string.page0_text),
                new Choice(context.getString(R.string.page0_choice1), 1),
                new Choice(context.getString(R.string.page0_choice2), 2));

        mPages[1] = new Page(
                R.drawable.page1,
                context.getString(R.string.page1_text),
                new Choice(context.getString(R.string.page1_choice1), 3),
                new Choice(context.getString(R.string.page1_choice2), 4));

        mPages[2] = new Page(
                R.drawable.page2,
                context.getString(R.string.page2_text),
                new Choice(context.getString(R.string.page2_choice1), 4),
                new Choice(context.getString(R.string.page2_choice2), 6));

        mPages[3] = new Page(
                R.drawable.page3,
                context.getString(R.string.page3_text),
                new Choice(context.getString(R.string.page3_choice1), 4),
                new Choice(context.getString(R.string.page3_choice2), 5));

        mPages[4] = new Page(
                R.drawable.page4,
                context.getString(R.string.page4_text),
                new Choice(context.getString(R.string.page4_choice1), 5),
                new Choice(context.getString(R.string.page4_choice2), 6));

        mPages[5] = new Page(
                R.drawable.page5,
                context.getString(R.string.page5_text));

        mPages[6] = new Page(
                R.drawable.page6,
                context.getString(R.string.page6_text));
    }

    public Page getPage(int pageNumber) {
        return mPages[pageNumber];
    }
}