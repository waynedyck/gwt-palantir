package com.imaginedreal.gwt.palantir.client;

import com.imaginedreal.gwt.palantir.client.activities.MenuView;
import com.imaginedreal.gwt.palantir.client.activities.about.AboutView;
import com.imaginedreal.gwt.palantir.client.activities.home.HomeView;
import com.imaginedreal.gwt.palantir.client.activities.sample.SampleView;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.mgwt.ui.client.widget.menu.swipe.SwipeMenu;


public interface ClientFactory {

	public HomeView getHomeView();
	public EventBus getEventBus();
	public PlaceController getPlaceController();
	public SwipeMenu getSwipeMenu();
	
	/**
	 * @return
	 */
	public AboutView getAboutView();
	public SampleView getSampleView();
        public MenuView getMenuView();
}
