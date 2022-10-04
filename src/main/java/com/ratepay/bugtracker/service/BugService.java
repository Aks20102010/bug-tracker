package com.ratepay.bugtracker.service;

import com.ratepay.bugtracker.model.Bug;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface BugService {
    public Bug addBug(Bug bug);
    public Bug updateBug(Bug bug);
    public void deleteBug(Long Id);
    public List<Bug> getBugs();

    Bug findBugById(Long id);
}
