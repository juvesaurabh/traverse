package com.project;

import java.util.Date;

/**
 * Created by saurabh-macbookair on 6/11/15.
 */
public class DetailedInfo {

    String absolutePath;
    Long size;
    Date modifiedDate;

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getAbsolutePath() {

        return absolutePath;
    }

    public Long getSize() {
        return size;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }
}