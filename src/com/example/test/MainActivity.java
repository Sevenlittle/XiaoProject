package com.example.test;

import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MainActivity extends ActionBarActivity {

	private ImageButton image1=null;
	private TextView text=null;
	private Button btn1=null;
	private Button btn2=null;
	private static final int MAX_PROGRASS=100;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.image1=(ImageButton)findViewById(R.id.image1);
		this.image1.setOnClickListener(new OnClickListenerImpl());
		this.text=(TextView)findViewById(R.id.text2);
		this.btn1=(Button)findViewById(R.id.btn1);
		
		this.btn1.setOnClickListener(new OnclickListenerImple());
		
		this.btn2=(Button)findViewById(R.id.btn2);
		this.btn2.setOnClickListener(new OnclickListenerImpl1());
	}

	public class OnclickListenerImpl1 implements OnClickListener
	{
		public void onClick(View v)
		{
			
		}
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
	
	public boolean onKeyDown(int keyCode,KeyEvent event)
	{
		if(keyCode==KeyEvent.KEYCODE_BACK)
		{
			this.exitDialog();
		}
		return false;
	}
	
	private class OnClickListenerImpl implements OnClickListener
	{
		public void onClick(View v)
		{
			MainActivity.this.exitDialog();
		}

	}
	
	private void exitDialog()
	{
		Dialog dialog=new AlertDialog.Builder(MainActivity.this).setIcon(R.drawable.test1).setTitle("are you sure?")
				.setMessage("are you sure to exit").setPositiveButton("Yes",new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						MainActivity.this.finish();
					}
				}).setNegativeButton("No",new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
					}
				}).create();
		dialog.show();
	}
	
	private class OnclickListenerImple implements OnClickListener
	{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Dialog dialog=new AlertDialog.Builder(MainActivity.this).setIcon(R.drawable.test1)
					.setTitle("choose your fruit").setPositiveButton("Yes",new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							//MainActivity.this.text.setText("your choose is:    "+MainActivity.this.getResources().getStringArray(R.array.friut_name)[0]);
						}
					}).setNegativeButton("no",new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							MainActivity.this.text.setText("your choose is:    ");
						}
					}).setSingleChoiceItems(R.array.friut_name,0,new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							MainActivity.this.text.setText("your choose is:    "+MainActivity.this.getResources().getStringArray(R.array.friut_name)[which]);
						}
					}).create();
			dialog.show();
		}
		
	}
}
