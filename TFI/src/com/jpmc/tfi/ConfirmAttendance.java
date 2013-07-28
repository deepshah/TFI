package com.jpmc.tfi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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

import android.app.ListActivity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ConfirmAttendance extends ListActivity {

	DBManager db;
	List<Attendance> list=MainActivity.students;
	String cid=MainActivity.cid;
	HttpClient httpclient=null;
	HttpPost httppost=null;
	ResponseHandler <String> res=null;
	TextView responseView=null;
	String response=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_attendance);

        ListView lv=(ListView)findViewById(android.R.id.list);
		db=new DBManager(getApplicationContext());
		db.open();
	    ArrayAdapter<Attendance> adapter = new InteractiveArrayAdapter(this,
	            list);
	    lv.setAdapter(adapter);
	    
	    Button present=(Button)findViewById(R.id.confirm);
		present.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				if(isOnline())
					submit();
				else
					Toast.makeText(getApplicationContext(), "No internet connection.", Toast.LENGTH_LONG).show();
			}
		});
	}
	
	public void submit()
	{

		Iterator<Attendance> itr=list.iterator();
		Attendance student=null;
		String query=MainActivity.cid+"#"+MainActivity.uidValue+"#"+MainActivity.passwordValue;

		
		String url="http://54.254.124.171/android/parse.jsp";
		while(itr.hasNext())
		{
			student=itr.next();
			if(!student.getAttendance())
			{
				query+="#"+student.getSID();
			}
		}

		//send attendance to server
		httpclient = new DefaultHttpClient();
        httppost = new HttpPost(url);
        res=new BasicResponseHandler();

		try {
			// Add your data
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
			nameValuePairs.add(new BasicNameValuePair("Body", query));     
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
		
		if(response.equals("true"))
		{
	        Toast.makeText(getApplicationContext(), "Submitted successfully.", Toast.LENGTH_LONG).show();
			finish();
		}
		
		else
		{
			System.out.println("f"+response);
			responseView=(TextView)findViewById(R.id.response);
			responseView.setText("Submission failed, try again.");
		}

	}

	public class networkThread implements Runnable
	{
		
		public void run()
		{
			try {
				response=httpclient.execute(httppost,res).toString().trim();
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
		getMenuInflater().inflate(R.menu.confirm_attendance, menu);
		return true;
	}

}
