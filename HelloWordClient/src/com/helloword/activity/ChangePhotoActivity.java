package com.helloword.activity;

import com.helloword.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;


public class ChangePhotoActivity extends Activity {

    private String userAvatarType;
	private String userAvatar;
	public final static int RESULT_CODE=1;
	private String num;
	
	private int[] drawAvatar = {R.drawable.ic_photo1, R.drawable.ic_photo2,
				R.drawable.ic_photo3, R.drawable.ic_photo4,
				R.drawable.ic_photo5, R.drawable.ic_photo6,
				R.drawable.ic_photo7, R.drawable.ic_photo8,
				R.drawable.ic_photo9, R.drawable.ic_photo10};
	/*private int[] drawAvatar_press = {R.drawable.ic_photo1_press, R.drawable.ic_photo2_press,
				R.drawable.ic_photo3_press, R.drawable.ic_photo4_press,
				R.drawable.ic_photo5_press, R.drawable.ic_photo6_press,
				R.drawable.ic_photo7_press, R.drawable.ic_photo8_press,
				R.drawable.ic_photo9_press, R.drawable.ic_photo10_press};*/
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_photo);
        Intent intent=getIntent();  
        Bundle bundle=intent.getExtras();  
        String str=bundle.getString("userAvatarString");
        System.out.println(str);
    /*    ImageView photo1 = (ImageView) findViewById(R.id.choose_photo1);
        ImageView photo2 = (ImageView) findViewById(R.id.choose_photo2);
        ImageView photo3 = (ImageView) findViewById(R.id.choose_photo3);
        ImageView photo4 = (ImageView) findViewById(R.id.choose_photo4);
        ImageView photo5 = (ImageView) findViewById(R.id.choose_photo5);
        ImageView photo6 = (ImageView) findViewById(R.id.choose_photo6);
        ImageView photo7 = (ImageView) findViewById(R.id.choose_photo7);
        ImageView photo8 = (ImageView) findViewById(R.id.choose_photo8);
        ImageView photo9 = (ImageView) findViewById(R.id.choose_photo9);
        ImageView photo10 = (ImageView) findViewById(R.id.choose_photo10);
        ImageView[] photo = {photo1,photo2,photo3,photo4,photo5,photo6,photo7,
        		photo8,photo9,photo10};           */             
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.change_photo, menu);
        return true;
    }

   public void changephoto1(View view){
           this.num = "1";
        }
   
   public void changephoto2(View view){
       this.num = "2";
    }
    
   public void changephoto3(View view){
       this.num = "3";
    }
   
   public void changephoto4(View view){
       this.num = "4";
    }
   
   public void changephoto5(View view){
       this.num = "5";
    }
   
   public void changephoto6(View view){
       this.num = "6";
    }
   
   public void changephoto7(View view){
       this.num = "7";
    }
   
   public void changephoto8(View view){
       this.num = "8";
    }
   
   public void changephoto9(View view){
       this.num = "9";
    }
   
   public void changephoto10(View view){
       this.num = "10";
    }
   
   public void confirmChangePhoto(View view){
	   System.out.println(num);
	   Intent intent=new Intent();  
       intent.putExtra("photo_avatar", num);  
       setResult(RESULT_CODE, intent);  
       finish();
   }
   
}
