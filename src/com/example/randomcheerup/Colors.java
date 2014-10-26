package com.example.randomcheerup;

import java.util.Random;

import android.graphics.Color;

public class Colors {
		String[] mColors ={
				"#009989",
				"#FFAA00",
				"#FF00AA",
				"#AA00FF",
				"#00AAFF"			
		};
		public int getColor(){
		//updating text 
		String color ="";
		//create new random constructor
		Random randomColors = new Random();
		//combine w member
		int rendomNumber = randomColors.nextInt(mColors.length);
		color = mColors[rendomNumber];
		int colorAsInt = Color.parseColor(color);
		return colorAsInt;
	}
		

}
