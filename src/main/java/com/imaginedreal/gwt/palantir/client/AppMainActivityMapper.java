package com.imaginedreal.gwt.palantir.client;

import com.imaginedreal.gwt.palantir.client.activities.about.AboutActivity;
import com.imaginedreal.gwt.palantir.client.activities.about.AboutPlace;
import com.imaginedreal.gwt.palantir.client.activities.home.HomeActivity;
import com.imaginedreal.gwt.palantir.client.activities.home.HomePlace;
import com.imaginedreal.gwt.palantir.client.activities.sample.SampleActivity;
import com.imaginedreal.gwt.palantir.client.activities.sample.SamplePlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class AppMainActivityMapper implements ActivityMapper {

	private final ClientFactory clientFactory;

	private Place lastPlace;

	public AppMainActivityMapper(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;

	}

	@Override
	public Activity getActivity(Place place) {
		Activity activity = getActivity(lastPlace, place);
		lastPlace = place;
		
		return activity;

	}

	private HomeActivity homeActivity;

	private HomeActivity getHomeActivity() {
		if (homeActivity == null) {
		    homeActivity = new HomeActivity(clientFactory);
		}

		return homeActivity;
	}

	private Activity getActivity(Place lastPlace, Place newPlace) {
		if (newPlace instanceof HomePlace) {
			return getHomeActivity();
		}
		
        if (newPlace instanceof AboutPlace) {
            return new AboutActivity(clientFactory);
        }
        
        if (newPlace instanceof SamplePlace) {
            return new SampleActivity(clientFactory);
        }

		return null;
	}

}
