package com.cbedoy.apprende;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.cbedoy.apprende.adapters.CourseViewAdapter;
import com.cbedoy.apprende.adapters.ThemeViewAdapter;
import com.cbedoy.apprende.bussiness.MasterController;
import com.cbedoy.apprende.interfaces.IAsyncServiceDelegate;
import com.cbedoy.apprende.interfaces.viewdelegates.ICourseViewDelegate;
import com.cbedoy.apprende.interfaces.viewdelegates.IThemeViewDelegate;
import com.cbedoy.apprende.keysets.CourseKeySet;
import com.cbedoy.apprende.keysets.ServiceKeySet;
import com.cbedoy.apprende.keysets.ThemeKeySet;
import com.cbedoy.apprende.services.AppInstanceProvider;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class ThemeView extends Activity implements IThemeViewDelegate, ICourseViewDelegate{

	private ListView 			themeList;
	private ListView 			courseList;
	private ThemeViewAdapter 	themeViewAdapter;
	private CourseViewAdapter 	courseViewAdapter;
	private MasterController	masterController;
	private List<Object> 		informationAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_theme_view);
		this.courseViewAdapter 	= new CourseViewAdapter(getApplicationContext());
		this.themeViewAdapter 	= new ThemeViewAdapter(getApplicationContext());
		this.themeList 			= (ListView)findViewById(R.id.theme_listView);
		this.courseList	 		= (ListView)findViewById(R.id.course_view_list);
		this.informationAdapter	= new ArrayList<Object>();
		this.themeList.setAdapter(themeViewAdapter);
		this.courseList.setAdapter(courseViewAdapter);
		
		
		this.masterController = AppInstanceProvider.getInstance().instanceServiceCourse(this, ServiceKeySet.GET_COURSE);
		this.masterController.getAnsycTask().execute();
		this.masterController = AppInstanceProvider.getInstance().instanceServiceTheme(this, ServiceKeySet.GET_THEME);
		this.masterController.getAnsycTask().execute();
	}
	

	@Override
	public void reloadDataWithCourse(JSONArray response) {
		this.informationAdapter.clear();
		try {
			if(response!=null){
				for(int index = 0; index < response.length(); index++){
					JSONObject data 					= response.getJSONObject(index);
					JSONObject fields					= data.getJSONObject("fields");
					HashMap<Object, Object> information = new HashMap<Object, Object>();
					information.put(CourseKeySet.ID, data.get("pk"));
					information.put(CourseKeySet.NAME, fields.get("name"));
					information.put(CourseKeySet.DESCRIPTION, fields.get("description"));
					this.informationAdapter.add(information);
				}
				this.courseViewAdapter.reloadWithData(informationAdapter);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void reloadDataWithTheme(JSONArray response) {
		this.informationAdapter.clear();
		try {
			if(response!=null){
				for(int index = 0; index < response.length(); index++){
					JSONObject data 					= response.getJSONObject(index);
					JSONObject fields					= data.getJSONObject("fields");
					HashMap<Object, Object> information = new HashMap<Object, Object>();
					information.put(ThemeKeySet.ID, data.get("pk"));
					information.put(ThemeKeySet.NAME, fields.get("name"));
					information.put(ThemeKeySet.DESCRIPTION, fields.get("description"));
					this.informationAdapter.add(information);
				}
				this.themeViewAdapter.reloadWithData(informationAdapter);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
