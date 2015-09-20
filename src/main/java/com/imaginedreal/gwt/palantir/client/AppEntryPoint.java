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

import com.imaginedreal.gwt.palantir.client.activities.home.HomePlace;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.mgwt.mvp.client.AnimatingActivityManager;
import com.googlecode.mgwt.mvp.client.AnimationMapper;
import com.googlecode.mgwt.mvp.client.history.MGWTPlaceHistoryHandler;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.MGWTSettings;
import com.googlecode.mgwt.ui.client.MGWTSettings.ViewPort;
import com.googlecode.mgwt.ui.client.util.SuperDevModeUtil;
import com.googlecode.mgwt.ui.client.widget.animation.AnimationWidget;

public class AppEntryPoint implements EntryPoint {
  
    private void start() {
        SuperDevModeUtil.showDevMode();

        ViewPort viewPort = new MGWTSettings.ViewPort();
        viewPort.setUserScaleAble(false).setInitialScale(1.0).setMinimumScale(1.0).setMaximumScale(1.0);

        MGWTSettings settings = new MGWTSettings();
        settings.setViewPort(viewPort);
        settings.setIconUrl("logo.png");
        settings.setFullscreen(true);
        settings.setFixIOS71BodyBug(true);
        settings.setPreventScrolling(true);

        MGWT.applySettings(settings);

        final ClientFactory clientFactory = new ClientFactoryImpl();

        // Start PlaceHistoryHandler with our PlaceHistoryMapper
        AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
        
        createPhoneDisplay(clientFactory);

        AppHistoryObserver historyObserver = new AppHistoryObserver();
        MGWTPlaceHistoryHandler historyHandler = new MGWTPlaceHistoryHandler(historyMapper, historyObserver);
        historyHandler.register(clientFactory.getPlaceController(), clientFactory.getEventBus(), new HomePlace());
        historyHandler.handleCurrentHistory();
    }

    private void createPhoneDisplay(ClientFactory clientFactory) {       
        // Setup navigation activity
        AnimationWidget navDisplay = new AnimationWidget();
        ActivityMapper navActivityMapper = new AppNavActivityMapper(
                clientFactory);
        
        AnimationMapper navAnimationMapper = new AppNavAnimationMapper();
        AnimatingActivityManager navActivityManager = new AnimatingActivityManager(
                navActivityMapper, navAnimationMapper, clientFactory.getEventBus());

        navActivityManager.setDisplay(navDisplay);
        clientFactory.getSwipeMenu().setMenuDisplay(navDisplay);

        // Setup main content activity
        AnimationWidget mainDisplay = new AnimationWidget();
        AppMainActivityMapper mainActivityMapper = new AppMainActivityMapper(clientFactory);
        AnimationMapper mainAnimationMapper = new AppMainAnimationMapper();
        AnimatingActivityManager mainActivityManager = new AnimatingActivityManager(
                mainActivityMapper, mainAnimationMapper, clientFactory.getEventBus());

        mainActivityManager.setDisplay(mainDisplay);
        clientFactory.getSwipeMenu().setContentDisplay(mainDisplay);
        
        RootPanel.get().add(clientFactory.getSwipeMenu());
    }

    @Override
    public void onModuleLoad() {
        start();
    }
  
}
