package com.example.android.miwok;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Numbers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // List of words
        final ArrayList<Word> words = new ArrayList<>();

        words.add(new Word("lutti", "one", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("otiki", "two", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("tolookosu", "three", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("oyyisa", "four", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("massokka", "five", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("temmokka", "six", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("kenekaku", "seven", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("kawinta", "eight", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("wo'e", "nine", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("na'aacha", "ten", R.drawable.number_ten, R.raw.number_ten));

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

        final WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);

        final ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final MediaPlayer mp;
                mp = MediaPlayer.create(getApplicationContext(), words.get(i).getAudioFileId());
                mp.start();

                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayer.release();
                    }
                });

            }
        });
    }
}
