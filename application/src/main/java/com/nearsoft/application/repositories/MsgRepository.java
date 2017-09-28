package com.nearsoft.application.repositories;

import com.nearsoft.application.entities.FierroMessage;
import org.springframework.data.repository.CrudRepository;

public interface MsgRepository extends CrudRepository<FierroMessage, String> {
}
