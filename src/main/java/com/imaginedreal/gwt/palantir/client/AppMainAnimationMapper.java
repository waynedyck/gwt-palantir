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

import com.google.gwt.place.shared.Place;
import com.googlecode.mgwt.mvp.client.AnimationMapper;
import com.googlecode.mgwt.ui.client.widget.animation.Animation;
import com.googlecode.mgwt.ui.client.widget.animation.Animations;
import com.imaginedreal.gwt.palantir.client.activities.about.AboutPlace;
import com.imaginedreal.gwt.palantir.client.activities.home.HomePlace;
import com.imaginedreal.gwt.palantir.client.activities.search.SearchPlace;
import com.imaginedreal.gwt.palantir.client.activities.settings.SettingsPlace;

public class AppMainAnimationMapper implements AnimationMapper {

  @Override
  public Animation getAnimation(Place oldPlace, Place newPlace) {
    if (oldPlace == null) {
      return Animations.FADE;
    }
    
    if (oldPlace instanceof SearchPlace && newPlace instanceof HomePlace) {
        return Animations.FADE_REVERSE;
    }
    
    if (oldPlace instanceof AboutPlace && newPlace instanceof HomePlace) {
        return Animations.FADE_REVERSE;
    }
    
    if (oldPlace instanceof SettingsPlace && newPlace instanceof HomePlace) {
        return Animations.FADE_REVERSE;
    }
    
    return Animations.FADE;

  }

}
