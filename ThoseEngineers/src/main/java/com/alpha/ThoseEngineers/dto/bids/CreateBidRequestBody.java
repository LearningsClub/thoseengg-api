package com.alpha.ThoseEngineers.dto.bids;

import com.alpha.ThoseEngineers.dto.jobs.CreateJobRequestBody;
import com.alpha.ThoseEngineers.dto.users.UserRequestBody;
import com.alpha.ThoseEngineers.modules.bids.Duration;

public class CreateBidRequestBody {
    private float biddingAmount;
    private String duration;
    private Integer deadline;
    private String relevantExperience;
    private String suggestions;
    private boolean negotiable;
    private UserRequestBody userRequestBody;
    private JobRequestBody jobRequestBody;

    public CreateBidRequestBody() {
    }

    public CreateBidRequestBody(float biddingAmount, String duration, Integer deadline, String relevantExperience, String suggestions, boolean negotiable, UserRequestBody userRequestBody, JobRequestBody jobRequestBody) {
        this.biddingAmount = biddingAmount;
        this.duration = duration;
        this.deadline = deadline;
        this.relevantExperience = relevantExperience;
        this.suggestions = suggestions;
        this.negotiable = negotiable;
        this.userRequestBody = userRequestBody;
        this.jobRequestBody = jobRequestBody;
    }

    public float getBiddingAmount() {
        return biddingAmount;
    }

    public void setBiddingAmount(float biddingAmount) {
        this.biddingAmount = biddingAmount;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Integer getDeadline() {
        return deadline;
    }

    public void setDeadline(Integer deadline) {
        this.deadline = deadline;
    }

    public String getRelevantExperience() {
        return relevantExperience;
    }

    public void setRelevantExperience(String relevantExperience) {
        this.relevantExperience = relevantExperience;
    }

    public String getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(String suggestions) {
        this.suggestions = suggestions;
    }

    public boolean isNegotiable() {
        return negotiable;
    }

    public void setNegotiable(boolean negotiable) {
        this.negotiable = negotiable;
    }

    public UserRequestBody getUserRequestBody() {
        return userRequestBody;
    }

    public void setUserRequestBody(UserRequestBody userRequestBody) {
        this.userRequestBody = userRequestBody;
    }

    public JobRequestBody getJobRequestBody() {
        return jobRequestBody;
    }

    public void setJobRequestBody(JobRequestBody jobRequestBody) {
        this.jobRequestBody = jobRequestBody;
    }
}
