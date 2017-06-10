package com.tgr.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Stories {

    private List<Story> storyList;

    public List<Story> getStoryList() {
        return storyList;
    }

    public void setStoryList(List<Story> storyList) {
        this.storyList = storyList;
    }
}
