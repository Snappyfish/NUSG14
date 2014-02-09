package SideBar;

import com.nusg.app.SideBarExample;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SideBarListFragment extends ListFragment {
	
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, new String[]{"put","sub","pages","here"}));
		getListView();
		
	}
	
	public void onListItemClick(ListView l, View v, int position, long id){
		super.onListItemClick(l,v,position,id);
		((SideBarExample)getActivity()).getSlideOutHelper().close();
	}
	
}
