package com.sbi.mvs.service;

import com.sbi.mvs.entity.Pfhrms;
import com.sbi.mvs.repository.PfhrmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    PfhrmsRepository pfhrmsRepository;

    @Override
    public Pfhrms getUserByUserId(String userId) {
        Optional<Pfhrms> user = pfhrmsRepository.findById(userId);
        return user.isPresent() ? user.get() : null;
    }

    @Override
    public List<Pfhrms> getUsersByPart(String userId) {
        return pfhrmsRepository.findAllByPfIdLike(userId + "%");
    }
}
