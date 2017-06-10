package com.tgr.service;

import com.tgr.model.Story;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface ResourceService {

    public Object getStoriesObject() throws IOException;

    public Object getShowsObject() throws IOException;

    public Story getStoryByTitle(String title) throws IOException;
}
