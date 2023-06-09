package com.alpha.ThoseEngineers.modules.bids;

import com.alpha.ThoseEngineers.modules.jobs.data.Job;
import com.alpha.ThoseEngineers.modules.users.User;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "bids",uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "job_id"}))

public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private float biddingAmount;
    @Enumerated(EnumType.STRING)
    private Frequency frequency;
    private Integer deadline;
    private String relevantExperience;
    private String suggestions;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @ManyToOne()
    @JoinColumn(name = "job_id")
    private Job job;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;
    private boolean negotiable;

    public Bid() {
    }

    public Bid(Integer id, float biddingAmount, Frequency frequency, Integer deadline, String relevantExperience, String suggestions, LocalDateTime createdAt, LocalDateTime updatedAt, Job job, User user, boolean negotiable) {
        this.id = id;
        this.biddingAmount = biddingAmount;
        this.frequency = frequency;
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

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
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
