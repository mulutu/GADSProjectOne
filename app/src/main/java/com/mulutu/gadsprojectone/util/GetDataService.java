package com.mulutu.gadsprojectone.util;

import com.mulutu.gadsprojectone.PostResponse;
import com.mulutu.gadsprojectone.model.LearnerHours;
import com.mulutu.gadsprojectone.model.LearnerIQ;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface GetDataService {
    @GET("/api/skilliq")
    Call<List<LearnerIQ>> getTopSkillIQLearners();

    @GET("/api/hours")
    Call<List<LearnerHours>> getTopHoursLearners();

    //@POST("/forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    //@POST("https://docs.google.com/forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    //@POST("/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @POST
    @FormUrlEncoded
    Call<PostResponse> savePost(@Url String loginUrl, @FieldMap Map<String, String> params);
    //Call<PostResponse> savePost(@FieldMap Map<String, String> params);
}
