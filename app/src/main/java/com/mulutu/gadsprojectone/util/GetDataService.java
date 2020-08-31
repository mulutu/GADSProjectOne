package com.mulutu.gadsprojectone.util;

import com.mulutu.gadsprojectone.model.Learner;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {
    @GET("/api/skilliq")
    Call<List<Learner>> getTopSkillIQLearners();

    @GET("/api/hours")
    Call<List<Learner>> getTopHoursLearners();
}
