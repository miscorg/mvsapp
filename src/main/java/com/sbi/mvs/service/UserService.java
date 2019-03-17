package com.sbi.mvs.service;

import com.sbi.mvs.entity.Pfhrms;

import java.util.List;

public interface UserService {

    Pfhrms getUserByUserId(String userId);

    List<Pfhrms> getUsersByPart(String userId);
}
