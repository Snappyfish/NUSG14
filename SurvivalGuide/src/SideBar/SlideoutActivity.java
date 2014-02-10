package SideBar;


import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;

public class SlideoutActivity extends Activity{
	   
	private SlideOutHelper rSlideoutHelper;
	   
	public static void prepare (Activity activity,int id, int width){
		SlideOutHelper.prepare(activity, id, width);
	}
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		rSlideoutHelper.activate();
		rSlideoutHelper.open();
	}
	
	public boolean onKeyDown(int key, KeyEvent event){
		if(key==KeyEvent.KEYCODE_BACK){
			rSlideoutHelper.close();
			return true;
		}
		return super.onKeyDown(key,event);
	}
	
	//This is a comment!
	
}
