package com.imaginedreal.gwt.palantir.client;

import com.imaginedreal.gwt.palantir.client.activities.MenuActivity;
import com.imaginedreal.gwt.palantir.client.activities.home.HomePlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class AppNavActivityMapper implements ActivityMapper {

	private final ClientFactory clientFactory;

	public AppNavActivityMapper(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	private MenuActivity menuActivity;

	private Activity getMenuActivity() {
		if (menuActivity == null) {
			menuActivity = new MenuActivity(clientFactory);
		}
		return menuActivity;
	}

	@Override
	public Activity getActivity(Place place) {
		if (place instanceof HomePlace) {
			return getMenuActivity();
		}

		return new MenuActivity(clientFactory);
	}
}
