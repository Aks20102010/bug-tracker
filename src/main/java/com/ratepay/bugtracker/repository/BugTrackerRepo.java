package com.ratepay.bugtracker.repository;

import com.ratepay.bugtracker.model.Bug;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BugTrackerRepo extends CrudRepository<Bug, Long> {
}
