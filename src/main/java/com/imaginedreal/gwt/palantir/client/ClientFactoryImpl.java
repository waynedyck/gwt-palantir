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

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.googlecode.mgwt.ui.client.widget.menu.swipe.SwipeMenu;
import com.imaginedreal.gwt.palantir.client.activities.MenuView;
import com.imaginedreal.gwt.palantir.client.activities.MenuViewGwtImpl;
import com.imaginedreal.gwt.palantir.client.activities.about.AboutView;
import com.imaginedreal.gwt.palantir.client.activities.about.AboutViewGwtImpl;
import com.imaginedreal.gwt.palantir.client.activities.home.HomeView;
import com.imaginedreal.gwt.palantir.client.activities.home.HomeViewGwtImpl;
import com.imaginedreal.gwt.palantir.client.activities.search.SearchView;
import com.imaginedreal.gwt.palantir.client.activities.search.SearchViewGwtImpl;

public class ClientFactoryImpl implements ClientFactory {

	private EventBus eventBus;
	private PlaceController placeController;
	private SwipeMenu swipeMenu;
	private HomeView homeView;
	private AboutViewGwtImpl aboutView;
	private SearchViewGwtImpl searchView;
	private MenuViewGwtImpl menuView;

	public ClientFactoryImpl() {
		eventBus = new SimpleEventBus();
		placeController = new PlaceController(eventBus);
		swipeMenu = new SwipeMenu();
		homeView = new HomeViewGwtImpl();
	}

	@Override
	public HomeView getHomeView() {
	    if (homeView == null) {
            homeView = new HomeViewGwtImpl();
	    }
		
		return homeView;
	}	
	
	@Override
	public EventBus getEventBus() {
		return eventBus;
	}

    @Override
    public SwipeMenu getSwipeMenu() {
        return swipeMenu;
    }
	
	@Override
	public PlaceController getPlaceController() {
		return placeController;
	}

	@Override
	public AboutView getAboutView() {
		if (aboutView == null) {
			aboutView = new AboutViewGwtImpl();
		}
		
		return aboutView;
	}

    @Override
    public SearchView getSearchView() {
        if (searchView == null) {
            searchView = new SearchViewGwtImpl();
        }

        return searchView;
    }

    @Override
    public MenuView getMenuView() {
        if (menuView == null) {
            menuView = new MenuViewGwtImpl();
        }
        return menuView;
    }

}
