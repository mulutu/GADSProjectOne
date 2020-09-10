package com.mulutu.gadsprojectone.util;

public class ApiUtilsPost {
    private ApiUtilsPost() {}

    public static final String BASE_URL = "https://docs.google.com/forms/d/e/";

    public static GetDataService GetDataService() {
        return RetrofitClient.getClient(BASE_URL).create(GetDataService.class);
    }
}
