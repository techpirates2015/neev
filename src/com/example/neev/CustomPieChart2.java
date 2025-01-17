package com.example.neev;

import java.util.ArrayList;

import com.example.neev.view.SlidingTabLayout;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

public class CustomPieChart2 extends Activity {
	 	private SlidingTabLayout slidingTabLayout;
	    private ViewPager viewPager;
	    private ArrayList<Fragment> fragments;
	    private ActionTabsViewPagerAdapter1 myViewPageAdapter;
	    
	    @Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);	
			
			// Define SlidingTabLayout (shown at top)
	        // and ViewPager (shown at bottom) in the layout.
	        // Get their instances.
	        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.tab);
	        viewPager = (ViewPager) findViewById(R.id.viewpager);

	        // create a fragment list in order.
	        fragments = new ArrayList<Fragment>(); 
	        fragments.add(new CustomPieFragment()); 
	        fragments.add(new TodayFragment());        
	          

	        // use FragmentPagerAdapter to bind the slidingTabLayout (tabs with different titles)
	        // and ViewPager (different pages of fragment) together.
	        myViewPageAdapter =new ActionTabsViewPagerAdapter1(getFragmentManager(),fragments);
	        viewPager.setAdapter(myViewPageAdapter);

	        // make sure the tabs are equally spaced.
	        slidingTabLayout.setDistributeEvenly(true);
	        slidingTabLayout.setViewPager(viewPager);
		}
	

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pie_chart1, menu);
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
}
