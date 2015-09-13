package com.imaginedreal.gwt.palantir.client;

import com.imaginedreal.gwt.palantir.client.activities.about.AboutPlace.AboutPlaceTokenizer;
import com.imaginedreal.gwt.palantir.client.activities.home.HomePlace.HomePlaceTokenizer;
import com.imaginedreal.gwt.palantir.client.activities.sample.SamplePlace.SamplePlaceTokenizer;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({ HomePlaceTokenizer.class, AboutPlaceTokenizer.class, SamplePlaceTokenizer.class })
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}
