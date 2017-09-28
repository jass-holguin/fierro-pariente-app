package com.nearsoft.application.services;

import com.nearsoft.application.entities.FierroMessage;
import com.nearsoft.application.repositories.MsgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MsgServiceImpl implements MsgService {

    private MsgRepository msgRepository;

    @Autowired
    public MsgServiceImpl(MsgRepository msgRepository) {
        this.msgRepository = msgRepository;
    }

    @Override
    public void saveOrUpdate(FierroMessage msg) {
        msgRepository.save(msg);
    }
}
