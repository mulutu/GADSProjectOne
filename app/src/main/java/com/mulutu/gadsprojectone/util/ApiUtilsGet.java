package com.mulutu.gadsprojectone.util;

import android.util.Log;

public class ApiUtilsGet {
    private ApiUtilsGet() {}

    private static final String BASE_URL = "https://gadsapi.herokuapp.com";

    public static GetDataService GetDataService() {
        Log.e("ApiUtilsGet:: ", "BASE_URL ::: " + BASE_URL);
        return RetrofitClient.getClient(BASE_URL).create(GetDataService.class);
    }
}
