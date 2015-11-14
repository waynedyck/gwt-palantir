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

package com.imaginedreal.gwt.palantir.shared;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class BookJso extends JavaScriptObject {
    protected BookJso() {}
    
    public final native BookShare getBookShare() /*-{ return this.bookshare }-*/;

    static public class BookShare extends JavaScriptObject {
        protected BookShare() {}

        public final native Book getBook() /*-{ return this.book }-*/;
    }
    
    static public class Book extends JavaScriptObject {
        protected Book() {}
        
        public final native List getList() /*-{ return this.list }-*/;
    }
    
    static public class List extends JavaScriptObject {
        protected List() {}
        
        public final native JsArray<Result> getResult() /*-{ return this.result }-*/;
    }
    
    static public class Result extends JavaScriptObject {
        protected Result() {}

        public final native JsArray<Author> getAuthor() /*-{ return this.author }-*/;
        public final native int getAvailableToDownload() /*-{ return this.availableToDownload }-*/;
        public final native String getBriefSynopsis() /*-{ return this.briefSynopsis }-*/;
        public final native JsArray<DownloadFormat> getDownloadFormat() /*-{ return this.downloadFormat }-*/;
        public final native int getDtbookSize() /*-{ return this.dtbookSize }-*/;
        public final native int getFreelyAvailable() /*-{ return this.freelyAvailable }-*/;
        public final native int getId() /*-{ return this.id }-*/;
        public final native int getImages() /*-{ return this.images }-*/;
        public final native String getIsbn13() /*-{ return this.isbn13 }-*/;
        public final native String getPublisher() /*-{ return this.publisher }-*/;
        public final native String getTitle() /*-{ return this.title }-*/;
    }
    
    public static class Author extends JavaScriptObject {
        protected Author() {}
    }
    
    public static class DownloadFormat extends JavaScriptObject {
        protected DownloadFormat() {}
    }
}
