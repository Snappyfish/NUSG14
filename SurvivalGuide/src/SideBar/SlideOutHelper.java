package SideBar;

import com.nusg.app.R;
import com.nusg.app.R.id;
import com.nusg.app.R.layout;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;

public class SlideOutHelper {

	private static Bitmap sCoverBitmap = null;
	private static int sWidth = -1;
	private Activity rActivity;
	private boolean rReverse;
	private ImageView rCover;
	private Animation rStartAnimation;
	private Animation rStopAnimation;
	private static final int DURATION_MS = 400;

	public static void prepare(Activity activity, int id, int width) {

		if (sCoverBitmap != null) {
			sCoverBitmap.recycle();
		}

		Rect rectangle = new Rect();
		Window window = activity.getWindow();
		window.getDecorView().getWindowVisibleDisplayFrame(rectangle);
		int statusBarHeight = rectangle.top;

		ViewGroup view = (ViewGroup) activity.findViewById(id).getRootView();
		view.setDrawingCacheEnabled(true);
		Bitmap src = Bitmap.createBitmap(view.getDrawingCache());
		view.setDrawingCacheEnabled(false);
		if (statusBarHeight != 0) {
			sCoverBitmap = Bitmap.createBitmap(src, 0, statusBarHeight,
					src.getWidth(), (src.getHeight() - statusBarHeight));
			src.recycle();
		} else {
			sCoverBitmap = src;
		}
		sWidth = width;
	}

	public SlideOutHelper(Activity activity, boolean reverse) {
		rActivity = activity;
		rReverse = reverse;
	}

	public SlideOutHelper(Activity activity) {
		this(activity, false);

	}

	public void activate() {
		rActivity.setContentView(com.nusg.app.R.layout.sidebarlayout);
		rCover = (ImageView) rActivity
				.findViewById(com.nusg.app.R.id.sidebar_cover);
		rCover.setImageBitmap(sCoverBitmap);
		rCover.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				close();
			}
		});

		int x = (int) (sWidth * 1.2f);
		if (rReverse) {
			@SuppressWarnings("deprecation")
			final android.widget.RelativeLayout.LayoutParams lp = new android.widget.RelativeLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
			rActivity.findViewById(com.nusg.app.R.id.sidebar_content)
					.setLayoutParams(lp);
		} else {
			@SuppressWarnings("deprecation")
			final android.widget.RelativeLayout.LayoutParams lp = new android.widget.RelativeLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
			rActivity.findViewById(com.nusg.app.R.id.sidebar_content)
					.setLayoutParams(lp);
		}
		initAnimations();
	}

	public void open() {
		rCover.startAnimation(rStartAnimation);
	}

	public void close() {
		rCover.startAnimation(rStopAnimation);
	}

	@SuppressWarnings("deprecation")
	public void initAnimations() {
		int displayWidth = ((WindowManager) rActivity
				.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay()
				.getWidth();
		final int shift = (rReverse ? -1 : 1) * sWidth - displayWidth;

		rStartAnimation = new TranslateAnimation(TranslateAnimation.ABSOLUTE,
				0, TranslateAnimation.ABSOLUTE, -shift,
				TranslateAnimation.ABSOLUTE, 0, TranslateAnimation.ABSOLUTE, 0);

		rStopAnimation = new TranslateAnimation(TranslateAnimation.ABSOLUTE, 0,
				TranslateAnimation.ABSOLUTE, shift,
				TranslateAnimation.ABSOLUTE, 0, TranslateAnimation.ABSOLUTE, 0);

		rStartAnimation.setDuration(DURATION_MS);
		rStartAnimation.setFillAfter(true);
		rStartAnimation.setAnimationListener(new AnimationListener() {

			public void onAnimationStart(Animation animation) {
			}

			public void onAnimationRepeat(Animation animation) {
			}

			public void onAnimationEnd(Animation animation) {
				rActivity.finish();
				rActivity.overridePendingTransition(0, 0);
			}
		});
	}
}
