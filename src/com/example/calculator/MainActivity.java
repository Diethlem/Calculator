package com.example.calculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.lang.Math;

public class MainActivity extends Activity {

	TextView disp;
	int opClicked;
	double input1, input2, product;
	
	@Override
	protected void on  {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
		
	}
	
	public void numClick(View sender){
		
		disp=(TextView)getCurrentFocus();
		Button clicked = (Button)sender;
		
		disp.append(clicked.getText());
		
	}
	
	public void resetOpColors(View Sender){
		
		Button divide = (Button)findViewById(R.id.ButtonDivide);
		Button multiply = (Button)findViewById(R.id.ButtonMultiply);
		Button subtract = (Button)findViewById(R.id.ButtonSubtract);
		Button add = (Button)findViewById(R.id.ButtonAdd);
		Button squareroot = (Button)findViewById(R.id.ButtonExponent);
		
		divide.setTextColor(-1);
		multiply.setTextColor(-1);
		subtract.setTextColor(-1);
		add.setTextColor(-1);
		squareroot.setTextColor(-1);
		
	}
	
	public void clear(View sender){
		
		disp=(TextView)findViewById(R.id.input1);
		disp.setText("");
		
		disp=(TextView)findViewById(R.id.input2);
		disp.setText("");
		
	}
	
	public void opClick(View sender){
		
		Button op = (Button)sender;
		String buttonText = op.getText().toString();
		resetOpColors(sender);
		
		op.setTextColor(-65281);
		
		if(buttonText.equals("/"))
			opClicked = 1;
		
		else if(buttonText.equals("*"))
			opClicked = 2;
		
		else if(buttonText.equals("-"))
			opClicked = 3;
		
		else if(buttonText.equals("+"))
			opClicked = 4;
		
		else if(buttonText.equals("^"))
			opClicked = 5;
		
		
	}

	public void enterClick(View sender){
		
		resetOpColors(sender);
		
		disp=(TextView)findViewById(R.id.input1);
		input1 = Double.parseDouble(disp.getText().toString());
		
		disp=(TextView)findViewById(R.id.input2);
		input2 = Double.parseDouble(disp.getText().toString());
		
		switch(opClicked){
		
			case 1: product = (input1 / input2);
				break;
				
			case 2: product = (input1 * input2);
				break;
			
			case 3: product = (input1 - input2);
				break;
			
			case 4: product = (input1 + input2);
				break;
			
			case 5: product = (Math.pow(input1, input2));
				break;
		
			default: break;
				
		}
		
		disp=(TextView)findViewById(R.id.result);
		disp.setText(String.valueOf(product));
		
	}
	
}
