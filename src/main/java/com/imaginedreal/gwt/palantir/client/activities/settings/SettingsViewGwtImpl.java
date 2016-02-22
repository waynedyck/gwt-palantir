/*
 * Copyright 2016 Wayne Dyck
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

package com.imaginedreal.gwt.palantir.client.activities.settings;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.ui.client.widget.button.image.PreviousitemImageButton;
import com.googlecode.mgwt.ui.client.widget.input.slider.Slider;
import com.googlecode.mgwt.ui.client.widget.list.widgetlist.WidgetList;

public class SettingsViewGwtImpl extends Composite implements SettingsView {

	/**
	 * The UiBinder interface.
	 */	
	interface SettingsViewGwtImplUiBinder extends
			UiBinder<Widget, SettingsViewGwtImpl> {
	}

	/**
	 * The UiBinder used to generate the view.
	 */
	private static SettingsViewGwtImplUiBinder uiBinder = GWT
			.create(SettingsViewGwtImplUiBinder.class);
	

	@UiField
	PreviousitemImageButton backButton;
	
	@UiField
	FlowPanel flowPanel;

	@UiField
	WidgetList widgetList;

	@UiField
	Slider slider;

	@UiField
	HTML valueField;

	private Presenter presenter;

	public SettingsViewGwtImpl() {

		initWidget(uiBinder.createAndBindUi(this));

	}

	@UiHandler("backButton")
	protected void onBackButtonPressed(TapEvent event) {
		if (presenter != null) {
			presenter.onBackButtonPressed();
		}
	}
	
	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

    @Override
    public HasValue<Integer> getSliderValue() {
        return slider;
    }

    @Override
    public HasHTML getTextField() {
        return valueField;
    }

}