package skuuz.ui;


import skuuz.data.wbservice.Caller;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class Login extends Activity 
{	

   
	private EditText usernameText;
    private EditText passwordText;
    private Button cancelButton;
    double longitude;
    
   
	double latitude;
	private long UPDATE_INTERVAL = 30000;
	private long UPDATE_Distance = 30000;
	public static String rslt="";
	
	
	
	

	Location location;
	LocationManager locationm;
	//private Button help;
    private CheckBox register;
    private CheckBox forgot;

  
    public static final int SIGN_UP_ID = Menu.FIRST;
    public static final int EXIT_APP_ID = Menu.FIRST + 1;
   

   
   
    /** Called when the activity is first created. */	
	@Override
    public void onCreate(Bundle savedInstanceState) 
	{
        	super.onCreate(savedInstanceState);    

        
        	setContentView(R.layout.login_screen);
        	setTitle("Login");
         
        	Button loginButton = (Button) findViewById(R.id.login);
        	cancelButton = (Button) findViewById(R.id.cancel_login);
        	// help = (Button) findViewById(R.id.help);
        	usernameText = (EditText) findViewById(R.id.userName);
        	passwordText = (EditText) findViewById(R.id.password);        
        	register = (CheckBox) findViewById(R.id.checkregister);
        	forgot = (CheckBox) findViewById(R.id.checkforgot);
        
        	locationm=(LocationManager)getSystemService(Context.LOCATION_SERVICE);
        	locationm.requestLocationUpdates(LocationManager.GPS_PROVIDER, UPDATE_INTERVAL, UPDATE_Distance, new MyLocationListener());
       
         
    	
        	loginButton.setOnClickListener(new OnClickListener()
        	{
        		public void onClick(View arg0) 
        		{					
        			if(register.isChecked()) 
        			{
					
					
					
        				if((usernameText.length()>0)||(passwordText.length() >0))
        				{
        					Toast.makeText(getApplicationContext(),
								"Please Confirm Your selection", Toast.LENGTH_LONG)
								.show();
        				}
        				else
        				{
					
        					if(forgot.isChecked())
        					{
        						Toast.makeText(getApplicationContext(),
								"forgot not implemented", Toast.LENGTH_LONG)
								.show();

        					}
        					else
        					{
        						Intent i = new Intent(Login.this, SignUp.class);
        						startActivity(i);
        					}
        				}
        			}
        			else
        			{
        				if (usernameText.length() > 0 && 
							passwordText.length() > 0)
						{
							
							
									try 
									{
											rslt="START";	
											Caller c=new Caller();
											c.user=usernameText.getText().toString();
											c.pass=passwordText.getText().toString();
											c.join();
											c.start();
											while(rslt=="START")
							 		        {
							 		        	try
							 		        	{
							 		        		Thread.sleep(10);
							 		        		
							 		        	}
							 		        	catch(Exception ex)
							 		        	{
							 		        		Toast.makeText(getApplicationContext(),
															ex.getMessage()+" while error", Toast.LENGTH_LONG)
															.show();
							 		        	}
							 		        }
							 		       	if(rslt.equals("ok"))
							 		       	{
							 		       		Toast.makeText(getApplicationContext(),
													rslt+" rslt==ok", Toast.LENGTH_LONG)
													.show();
							 		       		
							 		       		Toast.makeText(getApplicationContext(),
													"login ok", Toast.LENGTH_LONG)
													.show();
							 	 			
							 		        }
							 		       	else
							 		       	{
							 		       		Toast.makeText(getApplicationContext(),
													rslt+" rslt!=ok", Toast.LENGTH_LONG)
													.show();
							 		       		/*if(rslt.equals("user ok"))
							 		       		{
							 		       			Toast.makeText(getApplicationContext(),
							 		       					"user ok", Toast.LENGTH_LONG)
							 		       					.show();
							 	 			
							 		       		}
							 		       		else
							 		       		{
							 		       			if(rslt.equals("pass ok"))
							 		       			{
							 		       				Toast.makeText(getApplicationContext(),
							 		       						"pass ok", Toast.LENGTH_LONG)
							 		       						.show();
								 	 			
							 		       			}
							 		       			else
							 		       			{*/
							 		       				if(rslt.equals("no"))
							 		       				{
							 		       					Toast.makeText(getApplicationContext(),
							 		       						"no ok", Toast.LENGTH_LONG)
							 		       						.show();
								 	 			
							 		       				}
							 		       			//}
							 		       		//}
							 		       	}
							 		       
							 		      
							 		       	
									}
									catch(Exception ex)
							 		{
												Toast.makeText(getApplicationContext(),
														"login error", Toast.LENGTH_LONG)
														.show();
												Toast.makeText(getApplicationContext(),
														ex.getMessage()+" try error", Toast.LENGTH_LONG)
														.show();
							 		        	
							 		}
												
										
										
						}
									
					}
				}
        	});
							
						
        	cancelButton.setOnClickListener(new OnClickListener()
        	{

        		public void onClick(View arg0) 
        		{					
        			
        			Intent intent = new Intent(Intent.ACTION_MAIN);
        			intent.addCategory(Intent.CATEGORY_HOME);
        			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        			startActivity(intent);

				
        		}
        	
        	});
        
     
        
        
    }
    
	@Override
	public void onBackPressed() 
	{

	}


	
   

	

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{		
		boolean result = super.onCreateOptionsMenu(menu);
		
		
		return result;
	}
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) 
	{
	    
		switch(item.getItemId()) 
	    {
	    	case SIGN_UP_ID:
	    		Intent i = new Intent(Login.this, SignUp.class);
	    		startActivity(i);
	    		return true;
	    	case EXIT_APP_ID:
	    		cancelButton.performClick();
	    		return true;
	    }
	       
	    return super.onMenuItemSelected(featureId, item);
	}
}

	
	
    
    
    
    
    
