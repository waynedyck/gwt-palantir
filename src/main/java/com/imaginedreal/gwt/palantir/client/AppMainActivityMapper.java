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

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.imaginedreal.gwt.palantir.client.activities.about.AboutActivity;
import com.imaginedreal.gwt.palantir.client.activities.about.AboutPlace;
import com.imaginedreal.gwt.palantir.client.activities.home.HomeActivity;
import com.imaginedreal.gwt.palantir.client.activities.home.HomePlace;
import com.imaginedreal.gwt.palantir.client.activities.search.SearchActivity;
import com.imaginedreal.gwt.palantir.client.activities.search.SearchPlace;

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
        
        if (newPlace instanceof SearchPlace) {
            return new SearchActivity(clientFactory);
        }

		return null;
	}

}
