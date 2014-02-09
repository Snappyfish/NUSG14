package SidebarAttempt2;

public class SideBar2 {

21down voteaccepted 



I came up with a solution... I don't know if it is perfect but it is working well.

So what I did was a single FrameLayout with both of the Layouts stacked together and then I just animate the top layout to slide to the right of the screen (just need to call the slideTo or scrollBy. And basically it's that! Quite simple and effective! (the code though is not very pretty :P)

EDIT:

Some code samples.
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    android:background="#FFF" >

        <include
        android:id="@+id/menu_layout"
            layout="@layout/menu_list"
            android:visibility="invisible"/>

        <include
            android:id="@+id/news_list_parent"
            layout="@layout/main_news_list" 
            />

</FrameLayout>
This is the layout xml, quite simpe. The included .xml are simple LinearLayouts with a heading and a listview.

The "magic" happens in the animation:
protected void applyTransformation(float interpolatedTime, Transformation t) {
    int newOffset;
    if(expanded) {
        newOffset = 0;
        newOffset = (int)(endOffset*(1-interpolatedTime));
    } else {
        newOffset = (int)(endOffset*(interpolatedTime));
    }
    view.scrollTo(-newOffset, 0);
}
The endOffset is the target movement. I set it before I start the animation, and the View I want to animate (in this case is the view with the id=news_list_parent) it is set on the constructor.

But just to understand how that works make a button and its listener would do something like this:
if(viewBeneath.getVisibility() == View.INVISIBLE) {
    viewBeneath.setVisibility(View.Visible);
    viewToSlide.slideTo(-(width-50), 0);
}
And finally override the back button to do the opposite of the button
if(viewBeneath.getVisibility() == View.VISIBLE) {
    viewToSlide.slideTo(0, 0);
    viewBeneath.setVisibility(View.Visible);
}
Read this as pseudo-code =) This is what I did in the beginning, that code is lost :P
 
}
