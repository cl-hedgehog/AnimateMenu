package com.ryg.animatemenu;

import java.security.Principal;
import java.security.acl.Group;
import java.util.Enumeration;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class MainActivity extends Activity
{

	public static final String TAG = "TEST";

	private AnimMenuButtons mAnimMenu;
	private RadioButton rdLeft;
	private RadioButton rdMiddle;
	private RadioButton rdRight;
	private RadioGroup rgType;

	private int type = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		Log.d("TAG", "onCreate 0");
		setContentView(R.layout.activity_main);
		Log.d("TAG", "onCreate 1");
		mAnimMenu = (AnimMenuButtons) findViewById(R.id.anim_menu);
		mAnimMenu.setOnButtonClickListener(listener);
		mAnimMenu.setType(0);
		rgType = (RadioGroup) findViewById(R.id.rg_type);
		rgType.setOnCheckedChangeListener(new OnCheckedChangeListener()
		{

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId)
			{
				switch (checkedId)
				{
				case R.id.rb_left:
					mAnimMenu.setType(0);
					break;
				case R.id.rb_middle:
					mAnimMenu.setType(1);
					break;
				case R.id.rb_right:
					mAnimMenu.setType(2);
					break;
				}
			}
		});
	}

	AnimMenuButtons.OnButtonClickListener listener = new AnimMenuButtons.OnButtonClickListener()
	{
		@Override
		public void onButtonClick(View v, int id)
		{
			mAnimMenu.closeMenu();
			switch (v.getId())
			{
			case R.id.item1:
				// find
				Toast.makeText(MainActivity.this, "你点击了find",
						Toast.LENGTH_SHORT).show();
				break;
			case R.id.item2:
				// hi
				Toast.makeText(MainActivity.this, "你点击了hi", Toast.LENGTH_SHORT)
						.show();
				break;
			case R.id.item3:
				// write
				Toast.makeText(MainActivity.this, "你点击了write",
						Toast.LENGTH_SHORT).show();
				break;
			case R.id.item4:
				Toast.makeText(MainActivity.this, "你点击了person",
						Toast.LENGTH_SHORT).show();
				// person
				break;
			}
		}
	};
}
