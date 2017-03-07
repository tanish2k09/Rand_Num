package com.tanish2k09.rand_num;

import com.tanish2k09.rand_num.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //////////////////////////////////////////////////////////////////////
        
        Button ok=(Button)findViewById(R.id.ok);
        
        ok.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// Declarations
				EditText input_min=(EditText)findViewById(R.id.input_min);
				EditText input_max=(EditText)findViewById(R.id.input_max);
				TextView result=(TextView)findViewById(R.id.result);
				double lower,upper,rnum;
				// Initializations... Necessary for debug issues...
				if((input_min.length()==0)&&(input_max.length()==0))
				{
					input_min.setText("0");
					input_max.setText("0");
					result.setText("0");
					return;
				}
				else if((input_min.length()>5)||(input_max.length()>5))
				{
					result.setText("Only Upto 5 digits allowed...");
				}
				if(input_min.length()==0)
				{
					input_min.setText("0");
				}
				if(input_max.length()==0)
				{
					input_max.setText("0");
				}
				
				// Init done...
				
				// Now comes the real algorithm...
				
				lower=Double.parseDouble(input_min.getText().toString());
				upper=Double.parseDouble(input_max.getText().toString());
				if(lower==upper)
				{
					result.setText(""+lower);
				}
				else if(lower>upper)
				{
					double temp=lower;
					lower=upper;
					upper=temp;
				}
				rnum=Math.ceil(Math.random()*upper)+lower;
				if (rnum<0)
				{
					rnum*=(-1);
				}
				if(rnum<lower)
					rnum+=lower;
				if(rnum>upper)
					rnum=(rnum%lower)+lower;
				
				result.setText(""+(int)rnum);					
			}
		});
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
