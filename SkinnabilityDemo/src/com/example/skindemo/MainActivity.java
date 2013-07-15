package com.example.skindemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		final int id = getIntent().getIntExtra("theme", R.style.Theme_Blue);
		setTheme(id);
		
		setContentView(R.layout.activity_main);
		
		Spinner s = (Spinner) findViewById(R.id.price_filter);
		String[] prices = { ">30000", " 20000-30000", "10000-20000" };
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this
			, R.layout.spinner_row, R.id.price_text, prices );
		s.setAdapter(adapter);
		
		findViewById(R.id.Theme_Blue).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(id!= R.style.Theme_Blue) {
					Intent intent = new Intent(MainActivity.this, MainActivity.class);
					intent.putExtra("theme", R.style.Theme_Blue);
					startActivity(intent);
					finish();
				}
			}
		});
		
		findViewById(R.id.Theme_Green).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(id!= R.style.Theme_Green) {
					Intent intent = new Intent(MainActivity.this, MainActivity.class);
					intent.putExtra("theme", R.style.Theme_Green);
					startActivity(intent);
					finish();
				}
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
