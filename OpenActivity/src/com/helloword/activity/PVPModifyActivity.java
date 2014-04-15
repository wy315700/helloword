package com.helloword.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.helloword.R;

public class PVPModifyActivity extends BaseActivity{
	
	private int default_photo_id;
	private ImageView photo;
	private EditText username;
	private EditText nickname;
	private EditText password;
	private EditText college;
	private Button modifybtn;
	private TextView modifyphoto_hint;
	
	private RelativeLayout pvp_modify_account_area;
	private RelativeLayout pvp_nickname_area;
	private RelativeLayout pvp_modify_pass_area;
	private RelativeLayout pvp_modify_college_area;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvp_modify);
        
        /*--------------implemented to find the photo id of user-------------------*/
        default_photo_id=R.drawable.photo_girl1;
        
        photo=(ImageView)findViewById(R.id.pvp_modify_photo);
        username=(EditText)findViewById(R.id.pvp_modify_username);
        nickname=(EditText)findViewById(R.id.pvp_modify_nickname);
        password=(EditText)findViewById(R.id.pvp_modify_password);
        college=(EditText)findViewById(R.id.pvp_modify_college);
        modifybtn=(Button)findViewById(R.id.pvp_modify_btn);
        modifyphoto_hint=(TextView)findViewById(R.id.pvp_modify_photo_hint);
        
        pvp_modify_account_area=(RelativeLayout)findViewById(R.id.pvp_modify_account_area);
        pvp_nickname_area=(RelativeLayout)findViewById(R.id.pvp_nickname_area);
        pvp_modify_pass_area=(RelativeLayout)findViewById(R.id.pvp_modify_pass_area);
        pvp_modify_college_area=(RelativeLayout)findViewById(R.id.pvp_modify_college_area);
        
        modifybtn.setText("修改");
        /*fake a file*/
        username.setText("2fdw34sdfsdf@163.com");
        nickname.setText("我要玩单词");
        password.setText("2fjsdfsd");
        college.setText("中国科学院大学");
        
        username.setEnabled(false);
        nickname.setEnabled(false);
        password.setEnabled(false);
        college.setEnabled(false);
        photo.setClickable(false);
    }
	
	public void beginModify(View view){
		if(modifybtn.getText().equals("修改")){
			modifybtn.setText("完成");
			nickname.setText(null);
			password.setText(null);
			college.setText(null);
			
	        nickname.setEnabled(true);
	        password.setEnabled(true);
	        college.setEnabled(true);
	        modifyphoto_hint.setVisibility(View.VISIBLE);
	        photo.setClickable(true);
	        
	        pvp_nickname_area.setBackgroundResource(R.drawable.round_rectangle_white);
	        pvp_modify_pass_area.setBackgroundResource(R.drawable.round_rectangle_white);
	        pvp_modify_college_area.setBackgroundResource(R.drawable.round_rectangle_white);
		}
		else if(modifybtn.getText().equals("完成")){
			/*------------To be implemented, check content which user fills-------------*/
			modifybtn.setText("修改");
	        username.setEnabled(false);
	        nickname.setEnabled(false);
	        password.setEnabled(false);
	        college.setEnabled(false);
	        photo.setClickable(false);
	        modifyphoto_hint.setVisibility(View.INVISIBLE);
	        
	        pvp_nickname_area.setBackgroundResource(R.drawable.round_rectangle);
	        pvp_modify_pass_area.setBackgroundResource(R.drawable.round_rectangle);
	        pvp_modify_college_area.setBackgroundResource(R.drawable.round_rectangle);
		}
	}
	
	public void goChoosePhoto(View view){
		Intent intent = new Intent(this, PVPModifyPhotoActivity.class);
		startActivityForResult(intent, 1000);
	}
	
	 @Override
	    protected void onActivityResult(int requestCode, int resultCode, Intent data)
	    {
	        super.onActivityResult(requestCode, resultCode, data);
	        if(requestCode == 1000 && resultCode == 1001)
	        {
	            int result_photo_value = data.getIntExtra("photo_choose", default_photo_id);
	            photo.setImageResource(result_photo_value);
	        }
	    }
}
