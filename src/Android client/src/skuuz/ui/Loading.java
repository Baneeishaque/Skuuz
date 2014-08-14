package skuuz.ui;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class Loading extends Activity {

	
	View v;
	ProgressBar Pb;

	int a[] = { 20, 40, 60, 80, 100 }, i;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.launch);
		
		Pb = (ProgressBar) findViewById(R.id.progressBar1);
		Pb.setProgress(0);
		
		new Thread(new Runnable() 
		{ 
			public void run() 
			{ 
				try 
				{
		  
					for(i=0;i<5;i++) 
					{
		  
						Thread.sleep(2000);
		  
						Pb.setProgress(a[i]); 
					} 
					next(v); 
				} 
				catch(InterruptedException e) 
				{
					e.printStackTrace(); 
				} 
			} 
		}).start();

	}

	
	public void next(View v) {
		Intent target = new Intent(this, Login.class);
		startActivity(target);
		finish();
	}

}
