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

public interface GetDataService {
    @GET("/api/skilliq")
    Call<List<LearnerIQ>> getTopSkillIQLearners();

    @GET("/api/hours")
    Call<List<LearnerHours>> getTopHoursLearners();

    @POST("/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    Call<PostResponse> savePost(@FieldMap Map<String,String> params);
}
