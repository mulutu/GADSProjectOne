package com.mulutu.gadsprojectone.util;

public class ApiUtilsGet {
    private ApiUtilsGet() {}

    private static final String BASE_URL = "https://gadsapi.herokuapp.com";

    public static GetDataService GetDataService() {
        return RetrofitClient.getClient(BASE_URL).create(GetDataService.class);
    }
}
