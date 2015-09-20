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

package com.imaginedreal.gwt.palantir.client.activities;

import java.util.ArrayList;
import java.util.List;

import com.imaginedreal.gwt.palantir.client.ClientFactory;
import com.imaginedreal.gwt.palantir.client.activities.about.AboutPlace;
import com.imaginedreal.gwt.palantir.client.activities.search.SearchPlace;
import com.imaginedreal.gwt.palantir.shared.Topic;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;

public class MenuActivity extends MGWTAbstractActivity implements
		MenuView.Presenter {

	private final ClientFactory clientFactory;
	private MenuView view;
    private EventBus eventBus;
	
	public MenuActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}
	
	@Override
	public void start(AcceptsOneWidget panel, final EventBus eventBus) {
		view = clientFactory.getMenuView();
		this.eventBus = eventBus;
		view.setPresenter(this);
		view.render(createTopicsList());
		
		panel.setWidget(view);
	}

	@Override
	public void onStop() {
		view.setPresenter(null);
	}

	@Override
	public void onItemSelected(int index) {
		if (index == 0) {
		    clientFactory.getSwipeMenu().close(false);
			//clientFactory.getPlaceController().goTo(new MenuItemOnePlace());
			return;
		}
		if (index == 1) {
		    clientFactory.getSwipeMenu().close(false);
            clientFactory.getPlaceController().goTo(new SearchPlace());
		    return;
		}
		if (index == 2) {
		    clientFactory.getSwipeMenu().close(false);
			//clientFactory.getPlaceController().goTo(new MenuItemThreePlace());
			return;
		}
		if (index == 3) {
		    clientFactory.getSwipeMenu().close(false);
		    //clientFactory.getPlaceController().goTo(new MenuItemFourPlace());
		    return;
		}
	}
	
    @Override
    public void onAboutButtonPressed() {
        clientFactory.getSwipeMenu().close(false);
        clientFactory.getPlaceController().goTo(new AboutPlace());
    }
	
	private List<Topic> createTopicsList() {
		ArrayList<Topic> list = new ArrayList<Topic>();

		list.add(new Topic("My Library"));
		list.add(new Topic("Search Bookshare"));
		list.add(new Topic("Settings"));
		list.add(new Topic("Help & feedback"));
		
		return list;
	}

}
