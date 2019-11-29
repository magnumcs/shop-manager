package com.portifolio.magnum.eventregisterapi.repository;

import com.portifolio.magnum.eventregisterapi.domain.wrapper.EventWrapper;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends MongoRepository<EventWrapper, String> {

    @Query("{'event': {$regex: ?0 }})")
    List<EventWrapper> findEventByEventLike(String event);

}
