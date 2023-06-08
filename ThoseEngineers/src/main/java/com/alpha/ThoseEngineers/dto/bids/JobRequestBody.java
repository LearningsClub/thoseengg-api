package com.alpha.ThoseEngineers.dto.bids;

public class JobRequestBody {
    private String title;

    public JobRequestBody() {
    }

    public JobRequestBody(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
