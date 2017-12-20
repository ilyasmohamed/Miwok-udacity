package com.example.android.miwok;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Numbers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // List of words
        ArrayList<Word> words = new ArrayList<>();

        words.add(new Word("lutti", "one", R.drawable.number_one));
        words.add(new Word("lutti", "two", R.drawable.number_two));
        words.add(new Word("lutti", "three", R.drawable.number_three));
        words.add(new Word("lutti", "four", R.drawable.number_four));
        words.add(new Word("lutti", "five", R.drawable.number_five));
        words.add(new Word("lutti", "six", R.drawable.number_six));
        words.add(new Word("lutti", "seven", R.drawable.number_seven));
        words.add(new Word("lutti", "eight", R.drawable.number_eight));
        words.add(new Word("lutti", "nine", R.drawable.number_nine));
        words.add(new Word("lutti", "ten", R.drawable.number_ten));

        /*
        for (int i = 0; i <10 ; i++) {
            Log.v("NumbersActivity", "Word at index "+i+" :"+ words.get(i));
        }
        */
        // The Root View
//        LinearLayout rootView = (LinearLayout)findViewById(R.id.rootView);

        /*
        // Loop to add list items to Root view
        for (String word : words) {
            TextView wordView = new TextView(this, null, R.style.CategoryStyle);
            String str = word.toLowerCase();
            String strCap = str.substring(0, 1).toUpperCase() + str.substring(1);
            wordView.setText(strCap);
            rootView.addView(wordView);
        }
        */

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
    }
}
