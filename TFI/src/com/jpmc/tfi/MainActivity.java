package com.jpmc.tfi;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	static String cid=null;
	EditText uid=null;
	EditText password=null;
	TextView error=null;
	static List<Attendance> students=null;
	static String uidValue="";
	static String passwordValue="";
	HttpClient httpclient=null;
	HttpPost httppost=null;
	ResponseHandler <String> res=null;
	String response[]=null;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        uid=(EditText)findViewById(R.id.uidInput);
        password=(EditText)findViewById(R.id.passwordInput);
	    Button present=(Button)findViewById(R.id.login);
		present.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				try {
					if(isOnline())
						submit();
					else
				        Toast.makeText(getApplicationContext(), "No internet connection.", Toast.LENGTH_LONG).show();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	
	public void submit() throws UnsupportedEncodingException, IOException
	{

		uidValue=uid.getText().toString();
		passwordValue=password.getText().toString();

		//send attendance to server
		String url="http://54.254.124.171/android/login.jsp";

		httpclient = new DefaultHttpClient();
        httppost = new HttpPost(url);
        res=new BasicResponseHandler();
		try {
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
			nameValuePairs.add(new BasicNameValuePair("uid", uidValue));     
			nameValuePairs.add(new BasicNameValuePair("password", passwordValue));     
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			
			try {
				networkThread nt=new networkThread();
				Thread t=new Thread(nt);
				t.start();
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
		}    		



		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(response[0].equals("true"))
		{
			cid=response[1];
			int i=2;
			students = new ArrayList<Attendance>();
			while(i<response.length)
			{
				students.add(new Attendance(response[i++],response[i++]));
			}

			Intent mark=new Intent(getApplicationContext(),MarkAttendance.class);
			startActivity(mark);
			finish();
		}
		else
		{
			error=(TextView)findViewById(R.id.error);
			error.setText("Login failed, try again.");
		}    		
	}

    public class networkThread implements Runnable
    {
    	public void run()
    	{
			try {
				response=httpclient.execute(httppost,res).toString().trim().split("#");
				System.out.println(response[0]);

			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
    
    public boolean isOnline() {
        ConnectivityManager cm =
            (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
