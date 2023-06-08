package com.alpha.ThoseEngineers.dto.bids;

import com.alpha.ThoseEngineers.modules.bids.Duration;
import com.alpha.ThoseEngineers.modules.jobs.data.Job;
import com.alpha.ThoseEngineers.modules.users.User;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

public class BidResponseBody {
    private Integer id;
    private float biddingAmount;
    private Duration duration;
    private Integer deadline;
    private String relevantExperience;
    private String suggestions;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    private Job job;
    private User user;
    private boolean negotiable;

    public BidResponseBody() {
    }

    public BidResponseBody(Integer id, float biddingAmount, Duration duration, Integer deadline, String relevantExperience, String suggestions, LocalDateTime createdAt, LocalDateTime updatedAt, Job job, User user, boolean negotiable) {
        this.id = id;
        this.biddingAmount = biddingAmount;
        this.duration = duration;
        this.deadline = deadline;
        this.relevantExperience = relevantExperience;
        this.suggestions = suggestions;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.job = job;
        this.user = user;
        this.negotiable = negotiable;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getBiddingAmount() {
        return biddingAmount;
    }

    public void setBiddingAmount(float biddingAmount) {
        this.biddingAmount = biddingAmount;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isNegotiable() {
        return negotiable;
    }

    public void setNegotiable(boolean negotiable) {
        this.negotiable = negotiable;
    }
}
