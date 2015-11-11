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

package com.imaginedreal.gwt.palantir.client.activities.home;

import java.util.ArrayList;
import java.util.List;

import com.imaginedreal.gwt.palantir.client.ClientFactory;
import com.imaginedreal.gwt.palantir.client.activities.settings.SettingsPlace;
import com.imaginedreal.gwt.palantir.shared.Topic;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;

public class HomeActivity extends MGWTAbstractActivity implements
		HomeView.Presenter {

	private final ClientFactory clientFactory;
	private HomeView view;
		
	public HomeActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view = clientFactory.getHomeView();
		view.setPresenter(this);
		view.render(createTopicsList());
		view.refresh();
		
		panel.setWidget(view);
	}

    private List<Topic> createTopicsList() {
        ArrayList<Topic> list = new ArrayList<Topic>();
        
        list.add(new Topic("Sample Activity"));
        
        return list;
    }

    @Override
    public void onItemSelected(int index) {
        if (index == 0) {
            clientFactory.getPlaceController().goTo(new SettingsPlace());
            
            return;
        }        
    }

    @Override
    public void onMenuButtonPressed() {
        if (!clientFactory.getSwipeMenu().isOpen()) {
            clientFactory.getSwipeMenu().open();
        } else {
            clientFactory.getSwipeMenu().close();
        }
    }

}