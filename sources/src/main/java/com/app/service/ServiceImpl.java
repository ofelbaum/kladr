package com.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * User: router
 * Date: 9/15/11
 */
@Service
public class ServiceImpl {
    Logger logger = LoggerFactory.getLogger(ServiceImpl.class);

    @PostConstruct
    public void init() {
        logger.debug("service init");
    }
}
