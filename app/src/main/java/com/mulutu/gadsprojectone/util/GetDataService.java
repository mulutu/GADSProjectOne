package com.mulutu.gadsprojectone.util;

import com.mulutu.gadsprojectone.model.LearnerHours;
import com.mulutu.gadsprojectone.model.LearnerIQ;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {
    @GET("/api/skilliq")
    Call<List<LearnerIQ>> getTopSkillIQLearners();

    @GET("/api/hours")
    Call<List<LearnerHours>> getTopHoursLearners();
}
