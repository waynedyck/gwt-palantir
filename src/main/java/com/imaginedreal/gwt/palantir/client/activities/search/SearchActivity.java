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

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.jsonp.client.JsonpRequestBuilder;
import com.google.gwt.safehtml.shared.UriUtils;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;
import com.imaginedreal.gwt.palantir.client.ClientFactory;
import com.imaginedreal.gwt.palantir.client.event.ActionEvent;
import com.imaginedreal.gwt.palantir.client.event.ActionNames;
import com.imaginedreal.gwt.palantir.client.util.Consts;
import com.imaginedreal.gwt.palantir.shared.Book;
import com.imaginedreal.gwt.palantir.shared.BookJso;

public class SearchActivity extends MGWTAbstractActivity implements
		SearchView.Presenter {

	private final ClientFactory clientFactory;
	private SearchView view;
	private EventBus eventBus;
	
	private static final String TITLE_SEARCH_URL = Consts.HOST_URL + "/api/book/search/title/";
	private static List<Book> books = new ArrayList<Book>();

	public SearchActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public void start(AcceptsOneWidget panel, final EventBus eventBus) {
		view = clientFactory.getSearchView();
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

    @Override
    public void onSearchTextChanged(String filter) {
        String url = TITLE_SEARCH_URL + UriUtils.encode(filter) + "/page/1/limit/5";

        view.showProgressIndicator();

        JsonpRequestBuilder jsonp = new JsonpRequestBuilder();
        jsonp.setTimeout(30000); // Set timeout for 30 seconds
        jsonp.requestObject(url, new AsyncCallback<BookJso>() {

            @Override
            public void onFailure(Throwable caught) {
                view.hideProgressIndicator();
            }

            @Override
            public void onSuccess(BookJso result) {
                if (result.getBookShare() != null) {
                    books.clear();
                    Book book;
                    int numBooks = result.getBookShare().getBook().getList().getResult().length();
                    
                    for (int i = 0; i < numBooks; i++) {
                        book = new Book();
                        
                        book.setTitle(result.getBookShare().getBook().getList().getResult().get(i).getTitle());
                        book.setBriefSynopsis(result.getBookShare().getBook().getList().getResult().get(i).getBriefSynopsis());
                        
                        String isbn = result.getBookShare().getBook().getList().getResult().get(i).getIsbn13();
                        book.setIsbn13(isbn);
                        book.setBookCoverUrl("http://covers.openlibrary.org/b/isbn/" + isbn + "-S.jpg");
                        
                        books.add(book);
                    }
                }
                
                view.hideProgressIndicator();
                view.render(books);
                view.refresh();
            }
        });

    }

}