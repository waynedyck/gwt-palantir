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

import com.google.gwt.user.client.ui.IsWidget;
import com.imaginedreal.gwt.palantir.shared.Book;

public interface SearchView extends IsWidget {
	
	public void setPresenter(Presenter presenter);
	
	public interface Presenter {
		
		public void onBackButtonPressed();
		
		public void onSearchTextChanged(String filter);

	}
	
    public void render(List<Book> createBooksList);

    public void showProgressIndicator();

    public void hideProgressIndicator();
    
    public void refresh();
    
}