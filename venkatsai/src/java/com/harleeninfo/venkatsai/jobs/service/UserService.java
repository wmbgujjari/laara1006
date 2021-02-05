package com.harleeninfo.venkatsai.jobs.service;

import com.harleeninfo.venkatsai.jobs.entity.OtpUser;
import com.harleeninfo.venkatsai.jobs.entity.User;

public interface UserService {
    void save(User user);
    void saveotp(OtpUser user);
        
    User findByUsername(String username);
}
