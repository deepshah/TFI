package com.jpmc.tfi;

import java.util.Iterator;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MarkAttendance extends Activity {

	DBManager db;
	Cursor c_sid=null;
	TextView sidView;
	TextView snameView;
	String sid=null;
	String sname=null;
	List<Attendance> students=MainActivity.students;
	Iterator<Attendance> itr=null;
	Attendance student=null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark_attendance);
        
        sidView = (TextView) findViewById(R.id.studentid);
        snameView = (TextView) findViewById(R.id.sname);
		
        itr=students.iterator();

        if(itr.hasNext())
        {
        	student=itr.next();
        	sid=student.getSID();
        	sidView.setText(sid);
        	sname=student.getName();
        	snameView.setText(sname);
        }


    Button present=(Button)findViewById(R.id.present);
	present.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			student.setAttendance(true);
	        if(itr.hasNext())
	        {
	        	student=itr.next();
	        	sid=student.getSID();
	        	sidView.setText(sid);
	        	sname=student.getName();
	        	snameView.setText(sname);
	        }
	        
			else
			{
				Intent confirm=new Intent(getApplicationContext(),ConfirmAttendance.class);
				startActivity(confirm);
				finish();
			}
		}
	});
	
    Button absent=(Button)findViewById(R.id.absent);
	absent.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			student.setAttendance(false);
	        if(itr.hasNext())
	        {
	        	student=itr.next();
	        	sid=student.getSID();
	        	sidView.setText(sid);
	        	sname=student.getName();
	        	snameView.setText(sname);
	        }
	        
			else
			{
				Intent confirm=new Intent(getApplicationContext(),ConfirmAttendance.class);
				startActivity(confirm);
				finish();
			}
		}
	});

    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mark_attendance, menu);
		return true;
	}

}
