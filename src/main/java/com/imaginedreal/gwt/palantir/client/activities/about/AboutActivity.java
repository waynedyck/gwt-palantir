package com.imaginedreal.gwt.palantir.client.activities.about;

import com.imaginedreal.gwt.palantir.client.ClientFactory;
import com.imaginedreal.gwt.palantir.client.event.ActionEvent;
import com.imaginedreal.gwt.palantir.client.event.ActionNames;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;

public class AboutActivity extends MGWTAbstractActivity implements
		AboutView.Presenter {

	private final ClientFactory clientFactory;
	private AboutView view;
	private EventBus eventBus;

	public AboutActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public void start(AcceptsOneWidget panel, final EventBus eventBus) {
		view = clientFactory.getAboutView();
		this.eventBus = eventBus;
		view.setPresenter(this);

		panel.setWidget(view);

	}

	@Override
	public void onStop() {
		view.setPresenter(null);
	}
	
	@Override
	public void onBackButtonPressed() {
		ActionEvent.fire(eventBus, ActionNames.BACK);
	}

}