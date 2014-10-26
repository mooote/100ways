package com.example.randomcheerup;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

@SuppressLint("NewApi")
public class MainActivity extends Activity {
	// add constructor include private to be available only within this
	// mainActivity
	private CheerUps mCheerSeries = new CheerUps();
	private Colors mColorSeries = new Colors();
	public String count = "";
	int i = 1;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// declare necessary items
		final RelativeLayout container = (RelativeLayout) findViewById(R.id.container);
		// typeface implement
		Typeface tfTitle = Typeface.createFromAsset(getAssets(),
				"Roboto-Black.ttf");
		final TextView title = (TextView) findViewById(R.id.title);
		title.setTypeface(tfTitle);
		// screen size resizable work around
		title.setText("100 WAYS");
		title.setTextSize(64 * getResources().getDisplayMetrics().density);

		final TextView numberDisplay = (TextView) findViewById(R.id.number);
		final TextView cheersentence = (TextView) findViewById(R.id.sentence);
		final Button button = (Button) findViewById(R.id.button);
		cheersentence.setText(mCheerSeries.getcheer());

		android.app.ActionBar actionBar = getActionBar();
		actionBar.hide();
		View.OnClickListener listener = new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// set random facts on text view
				String sentence = mCheerSeries.getcheer();
				cheersentence.setText(sentence);
				int actualColor = mColorSeries.getColor();
				container.setBackgroundColor(actualColor);
				button.setTextColor(actualColor);
				// number increment
				i++;
				if (i == 101) {
					i = 1;
				}
				count = Integer.toString(i);
				// set number on text view
				numberDisplay.setText(count);
			}

		};
		// setting button to clickListner
		button.setOnClickListener(listener);

	}
}