package skuuz.data.wbservice;

import skuuz.ui.Login;

public class Caller  extends Thread 
{

	
	public CallSoap cs;
	
	
	public String user;
	public String pass;

	public void run()
	{
		try
		{
			cs=new CallSoap();	
			String resp=cs.Call(user, pass);
			Login.rslt=resp;
		}
		catch(Exception ex)
		{
			Login.rslt=ex.toString();	
		}

	
    }
}
