package com.harleeninfo.venkatsai.jobs.service;

import com.harleeninfo.venkatsai.jobs.entity.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
