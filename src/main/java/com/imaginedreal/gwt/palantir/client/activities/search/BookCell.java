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

import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeUri;
import com.google.gwt.uibinder.client.UiRenderer;
import com.google.gwt.uibinder.client.UiTemplate;
import com.googlecode.mgwt.ui.client.widget.list.celllist.Cell;

public abstract class BookCell<T> implements Cell<T> {

	@UiTemplate("BookCell.ui.xml")
	public interface Renderer extends UiRenderer {
		public void render(SafeHtmlBuilder safeHtmlBuilder,
				SafeUri bookCoverUrl, String title, String briefSynopsis);
	}

	private Renderer renderer = GWT.create(Renderer.class);
	
	public void render(SafeHtmlBuilder sb, T model) {
		renderer.render(sb, getBookCoverUrl(model), getTitle(model), getBriefSynopsis(model));

	}

	public abstract SafeUri getBookCoverUrl(T model);
    
	public abstract String getTitle(T model);		
	
	public abstract String getBriefSynopsis(T model);

	@Override
	public boolean canBeSelected(T model) {
		return true;
	}

}
