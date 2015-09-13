package com.imaginedreal.gwt.palantir.client.activities;

import java.util.ArrayList;
import java.util.List;

import com.imaginedreal.gwt.palantir.client.ClientFactory;
import com.imaginedreal.gwt.palantir.client.activities.about.AboutPlace;
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
            //clientFactory.getPlaceController().goTo(new MenuItemTwoPlace());
		    return;
		}
		if (index == 2) {
		    clientFactory.getSwipeMenu().close(false);
			//clientFactory.getPlaceController().goTo(new MenuItemThreePlace());
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
		
		list.add(new Topic("Read Now"));
		list.add(new Topic("My Library"));
		list.add(new Topic("Search Bookshare"));
		list.add(new Topic("Settings"));
		list.add(new Topic("Help & feedback"));
		
		return list;
	}

}
