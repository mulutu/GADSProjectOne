package com.mulutu.gadsprojectone.util;

import android.util.Log;

public class ApiUtilsPost {
    private ApiUtilsPost() {}

    public static GetDataService GetDataService() {
        return RetrofitClientPost.getClient().create(GetDataService.class);
    }
}
