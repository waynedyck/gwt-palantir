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

import java.io.Serializable;

public class Book implements Serializable {

    private static final long serialVersionUID = 1441635113369318927L;
    private String author;
    private int availableToDownload;
    private String briefSynopsis;
    private String downloadFormat;
    private int dtbookSize;
    private int freelyAvailable;
    private int id;
    private int images;
    private String isbn13;
    private String publisher;
    private String title;
    private String bookCoverUrl;
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public int getAvailableToDownload() {
        return availableToDownload;
    }
    
    public void setAvailableToDownload(int availableToDownload) {
        this.availableToDownload = availableToDownload;
    }
    
    public String getBriefSynopsis() {
        return briefSynopsis;
    }
    
    public void setBriefSynopsis(String briefSynopsis) {
        this.briefSynopsis = briefSynopsis;
    }
    
    public String getDownloadFormat() {
        return downloadFormat;
    }
    
    public void setDownloadFormat(String downloadFormat) {
        this.downloadFormat = downloadFormat;
    }
    
    public int getDtbookSize() {
        return dtbookSize;
    }
    
    public void setDtbookSize(int dtbookSize) {
        this.dtbookSize = dtbookSize;
    }
    
    public int getFreelyAvailable() {
        return freelyAvailable;
    }
    
    public void setFreelyAvailable(int freelyAvailable) {
        this.freelyAvailable = freelyAvailable;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getImages() {
        return images;
    }
    
    public void setImages(int images) {
        this.images = images;
    }
    
    public String getIsbn13() {
        return isbn13;
    }
    
    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }
    
    public String getPublisher() {
        return publisher;
    }
    
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getBookCoverUrl() {
        return bookCoverUrl;
    }

    public void setBookCoverUrl(String bookCoverUrl) {
        this.bookCoverUrl = bookCoverUrl;
    }
}
