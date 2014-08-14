package skuuz.ui;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Terms extends Activity {

	private CheckBox mcheck;
	private Button button1;
	private Button button2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.terms);

		mcheck=(CheckBox) findViewById(R.id.checkBox1);
		button1=(Button) findViewById(R.id.button1);
		button2=(Button) findViewById(R.id.Button01);

		WebView wv = (WebView) findViewById(R.id.webIntro);
        wv.loadUrl("file:///android_asset/license.html");
        button1.setOnClickListener(new OnClickListener() {
    		@Override
    		public void onClick(View arg0) {
    			if(mcheck.isChecked())
    	    	{
    	    		Intent target = new Intent(arg0.getContext(), About_Me.class);
    	    		startActivity(target);
    	    	}
    	    	else
    	    	{
    	    		Toast.makeText(getApplicationContext(), "Please Confirm Your Acceptance", Toast.LENGTH_LONG).show();
    	    			
    	    		
    	    	}
    		}
    	});
        
        button2.setOnClickListener(new OnClickListener() {
    		@Override
    		public void onClick(View arg0) {
    			Intent intent = new Intent(Intent.ACTION_MAIN);
    			intent.addCategory(Intent.CATEGORY_HOME);
    			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        		startActivity(intent);
        		
    		}
    	});
		
	}

	
	
	
	/*public void next3(View view)
    {
    	if(mcheck.isChecked())
    	{
    		Intent target = new Intent(this, About.class);
    		startActivity(target);
    	}
    	else
    	{
    		Toast.makeText(this, "Please Confirm Your Acceptance", Toast.LENGTH_LONG).show();
    			
    		
    	}
        
    }
	
	

	public void exit()
    {
		finish();
		System.exit(0);
    }*/
}
