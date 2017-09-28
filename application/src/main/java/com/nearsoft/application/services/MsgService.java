package com.nearsoft.application.services;

import com.nearsoft.application.entities.FierroMessage;

public interface MsgService {
    void saveOrUpdate(FierroMessage msg);
}
