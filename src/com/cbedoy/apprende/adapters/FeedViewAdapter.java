package com.cbedoy.apprende.adapters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cbedoy.apprende.R;
import com.cbedoy.apprende.interfaces.representationDelegates.IFeedRepresentationDelegate;
import com.cbedoy.apprende.keysets.QuestionKeySet;
import com.cbedoy.apprende.services.AppInstanceProvider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FeedViewAdapter extends BaseAdapter implements IFeedRepresentationDelegate{

	private List<Object> 	dataModel;
	private Context			context;
	
	public FeedViewAdapter(Context context){
		this.context 		= context;
		this.dataModel 		= new ArrayList<Object>();
	}
	
	@Override
	public int getCount() {

		return dataModel.size();
	}

	@Override
	public Object getItem(int position) {
		
		return dataModel.get(position);
	}

	@Override
	public long getItemId(int arg0) {

		return 0;
	}

	@Override
	public View getView(int position, View view, ViewGroup viewGroup) {
		
		if (view == null) {
			
			view = LayoutInflater.from(context).inflate(R.layout.feed_view, null, false);
			
		}else{
			
			if(!dataModel.isEmpty()){
				@SuppressWarnings("unchecked")
				HashMap<QuestionKeySet, Object>  information 	= (HashMap<QuestionKeySet, Object>) dataModel.get(position);
				if(!information.isEmpty()){
					TextView	feedQuestion 						= (TextView) view.findViewById(R.id.feed_question);
					TextView	feedCorrect 						= (TextView) view.findViewById(R.id.feed_correct);
					TextView	feedUser 							= (TextView) view.findViewById(R.id.feed_your_option);
					feedQuestion.setText(information.get(QuestionKeySet.QUESTION).toString());
					feedCorrect.setText(information.get(QuestionKeySet.CORRECT).toString());
					feedUser.setText(information.get(QuestionKeySet.OPTION_USER).toString());
					feedQuestion.setTypeface(AppInstanceProvider.regularFont);
					feedCorrect.setTypeface(AppInstanceProvider.lightFont);
					feedUser.setTypeface(AppInstanceProvider.lightFont);
				}
			}
		
		}
		return view;
		
	}

	@Override
	public void reloadWithData(List<Object> dataModel) {
		this.dataModel = dataModel;
		this.notifyDataSetChanged();
		
	}

}
