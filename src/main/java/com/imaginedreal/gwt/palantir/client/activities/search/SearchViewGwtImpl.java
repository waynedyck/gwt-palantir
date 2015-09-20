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

package com.imaginedreal.gwt.palantir.client.activities.search;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.ui.client.widget.button.image.PreviousitemImageButton;
import com.googlecode.mgwt.ui.client.widget.input.search.MSearchBox;
import com.googlecode.mgwt.ui.client.widget.input.search.SearchSubmitEvent;
import com.googlecode.mgwt.ui.client.widget.input.search.SearchSubmitHandler;
import com.googlecode.mgwt.ui.client.widget.list.celllist.BasicCell;
import com.googlecode.mgwt.ui.client.widget.list.celllist.CellList;
import com.googlecode.mgwt.ui.client.widget.progress.ProgressIndicator;
import com.imaginedreal.gwt.palantir.shared.Topic;

public class SearchViewGwtImpl extends Composite implements SearchView {

	/**
	 * The UiBinder interface.
	 */	
	interface SearchViewGwtImplUiBinder extends
			UiBinder<Widget, SearchViewGwtImpl> {
	}

	/**
	 * The UiBinder used to generate the view.
	 */
	private static SearchViewGwtImplUiBinder uiBinder = GWT
			.create(SearchViewGwtImplUiBinder.class);
	

	@UiField
	PreviousitemImageButton backButton;

    @UiField(provided = true)
    CellList<Topic> cellList;

    @UiField
    FlowPanel flowPanel;

    @UiField(provided = true)
    MSearchBox searchBox;

    @UiField
    ProgressIndicator progressIndicator;

	private Presenter presenter;
	
	public SearchViewGwtImpl() {
	
	    cellList = new CellList<Topic>(new BasicCell<Topic>() {

            @Override
            public String getDisplayString(Topic model) {
                return model.getName();
            }

            @Override
            public boolean canBeSelected(Topic model) {
                return true;
            }
	    });
	    
	    searchBox = new MSearchBox();
	    searchBox.setPlaceHolder("Search Bookshare");
	    searchBox.addSearchSubmitHandler(new SearchSubmitHandler() {

            @Override
            public void onEvent(SearchSubmitEvent event) {
                if (presenter != null) {
                    presenter.onSearchTextChanged(searchBox.getText());
                }
            }
	    });
	    
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
    public void render(List<Topic> createTopicsList) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void showProgressIndicator() {
        progressIndicator.setVisible(true);
    }

    @Override
    public void hideProgressIndicator() {
        progressIndicator.setVisible(false);
    }

}