package com.imaginedreal.gwt.palantir.client.activities.sample;

import com.google.gwt.user.client.ui.IsWidget;

public interface SampleView extends IsWidget {
	
	public void setPresenter(Presenter presenter);
	
	public interface Presenter {
		
		public void onBackButtonPressed();
		
	}
}