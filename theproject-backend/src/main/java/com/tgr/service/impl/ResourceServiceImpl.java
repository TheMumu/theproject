package com.tgr.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tgr.model.Stories;
import com.tgr.model.Story;
import com.tgr.service.ResourceService;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Value("${content.json.path}")
    String jsonResourcePath;

    private static final Logger logger = LoggerFactory.getLogger(ResourceServiceImpl.class);

    public Object getStoriesObject() throws IOException {
        return getJsonObject(new PathResource(jsonResourcePath + "stories.json"));
    }

    public Object getShowsObject() throws IOException {
        return getJsonObject(new PathResource(jsonResourcePath + "shows.json"));
    }

    public Story getStoryByTitle(String title) throws IOException {
        String jsonStr = "";
        try  (InputStream is = new PathResource(jsonResourcePath + "stories.json").getInputStream()){
            jsonStr = IOUtils.toString(is);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw e;
        }

        Stories stories = new Stories();
        ObjectMapper mapper = new ObjectMapper();
        try {
            stories = mapper.readValue(jsonStr, Stories.class);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw e;
        }

        Story result = null;
        for(Story story :stories.getStoryList()){
            if(StringUtils.equals(story.getTitle(), title)) {
                result = story;
            }
        }

        return  result;
    }

    private Object getJsonObject(Resource resource) throws IOException {
        String jsonStr = "";
        try  (InputStream is = resource.getInputStream()){
            jsonStr = IOUtils.toString(is);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw e;
        }

        Object object = new Object();
        ObjectMapper mapper = new ObjectMapper();
        try {
            object = mapper.readValue(jsonStr, Object.class);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
        return  object;
    }


}


