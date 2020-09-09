package com.mulutu.gadsprojectone;

import com.google.gson.annotations.SerializedName;

public class PostResponse {
    @SerializedName("success")
    private String success;

    public void setSuccess(String success){
        this.success = success;
    }
    public String getSuccess(){
        return success;
    }
}
