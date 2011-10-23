package com.emal.kladr.service;

import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * User: router
 * Date: 9/15/11
 * Time: 10:53 PM
 */
@Service
public class HumanResourceService {
    public void bookHoliday(Date startDate, Date endDate, String name) {
        System.out.println(startDate + " " + endDate + " " + name);
    }
}
