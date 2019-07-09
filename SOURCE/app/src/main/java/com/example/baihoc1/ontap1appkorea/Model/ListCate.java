package com.example.baihoc1.ontap1appkorea.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ListCate implements Serializable {

@SerializedName("categoryID")
@Expose
public Integer categoryID;
@SerializedName("name")
@Expose
public String name;
@SerializedName("urlCategory")
@Expose
public String urlCategory;

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlCategory() {
        return urlCategory;
    }

    public void setUrlCategory(String urlCategory) {
        this.urlCategory = urlCategory;
    }
}