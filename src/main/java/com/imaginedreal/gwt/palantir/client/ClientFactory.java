/*
 * Copyright 2015 Wayne Dyck
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
