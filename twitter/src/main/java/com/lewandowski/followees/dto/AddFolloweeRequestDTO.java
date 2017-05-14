package com.lewandowski.followees.dto;

import javax.validation.constraints.NotNull;

public class AddFolloweeRequestDTO {

    @NotNull
    private Long followeeId;

    public Long getFolloweeId() {
        return followeeId;
    }

    public void setFolloweeId(Long followeeId) {
        this.followeeId = followeeId;
    }

    @Override
    public String toString() {
        return "AddFolloweeRequestDTO{" +
                "followeeId=" + followeeId +
                '}';
    }
}
