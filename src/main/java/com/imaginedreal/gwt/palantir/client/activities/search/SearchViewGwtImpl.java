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
import com.google.gwt.safehtml.shared.SafeUri;
import com.google.gwt.safehtml.shared.UriUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.widget.button.image.PreviousitemImageButton;
import com.googlecode.mgwt.ui.client.widget.input.search.MSearchBox;
import com.googlecode.mgwt.ui.client.widget.input.search.SearchSubmitEvent;
import com.googlecode.mgwt.ui.client.widget.input.search.SearchSubmitHandler;
import com.googlecode.mgwt.ui.client.widget.list.celllist.CellList;
import com.googlecode.mgwt.ui.client.widget.panel.scroll.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.progress.ProgressIndicator;
import com.imaginedreal.gwt.palantir.client.util.ParserUtils;
import com.imaginedreal.gwt.palantir.shared.Book;

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
    CellList<Book> cellList;

    @UiField
    FlowPanel flowPanel;

    @UiField
    static
    ScrollPanel scrollPanel;
    
    @UiField(provided = true)
    MSearchBox searchBox;

    @UiField
    ProgressIndicator progressIndicator;

	private Presenter presenter;
	
	public SearchViewGwtImpl() {
	    
	    handleOnLoad();
	
	    cellList = new CellList<Book>(new BookCell<Book>() {

            @Override
            public SafeUri getBookCoverUrl(Book model) {
                return UriUtils.fromString(model.getBookCoverUrl());
            }

            @Override
            public String getTitle(Book model) {
                return model.getTitle();
            }

            @Override
            public String getBriefSynopsis(Book model) {
                String briefSynopsis = "";

                if (MGWT.getOsDetection().isPhone()) {
                    briefSynopsis = ParserUtils.ellipsis(model.getBriefSynopsis(), 128);
                } else {
                    briefSynopsis = ParserUtils.ellipsis(model.getBriefSynopsis(), 512);
                }

                return briefSynopsis;
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

    /**
     * ScrollPanel doesn't allow scrolling to the bottom if it contains a CellList with images.
     * 
     * See: https://code.google.com/p/mgwt/issues/detail?id=276
     * 
     * ScrollPanel.refresh() must be explicitly called after the images are loaded.
     * Since the onload event of images is not bubbling up, the LoadHandler can't be attached
     * to the CellList. Instead, the onload event needs to be captured at the <img>, and directly
     * trigger the ScrollPanel.refresh() from there.
     */
    private native void handleOnLoad() /*-{
        $wnd.refreshPanel = @com.imaginedreal.gwt.palantir.client.activities.search.SearchViewGwtImpl::refreshPanel();
    }-*/;

    public static void refreshPanel() {
        scrollPanel.refresh();
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
    public void render(List<Book> createBooksList) {
        cellList.render(createBooksList);
    }

    @Override
    public void showProgressIndicator() {
        progressIndicator.setVisible(true);
    }

    @Override
    public void hideProgressIndicator() {
        progressIndicator.setVisible(false);
    }

    @Override
    public void refresh() {
        scrollPanel.refresh();
    }

}