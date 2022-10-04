package com.ratepay.bugtracker.service;

import com.ratepay.bugtracker.exception.BugNotFoundException;
import com.ratepay.bugtracker.model.Bug;
import com.ratepay.bugtracker.repository.BugTrackerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@Transactional
public class BugSerivceImpl implements BugService{

    @Autowired
    private BugTrackerRepo repo;

    public Bug addBug(Bug bug) {
        Bug bugAdded = repo.save(bug);
        return bugAdded;
    }


    public Bug updateBug(Bug bug) {
        Optional<Bug> byId = repo.findById(bug.getId());
        if(bug.getId()==byId.get().getId()){
            Bug updatedBug = repo.save(bug);
            return updatedBug;
        }else {
            throw new BugNotFoundException("Passed bug is not available" );
        }
    }


    public void deleteBug(Long id) {
        repo.deleteById(id);
    }


    public List<Bug> getBugs() {
        List<Bug> bugs=new ArrayList<>();
        Iterable<Bug> bugIterable = repo.findAll();
        for (Bug bug: bugIterable) {
            bugs.add(bug);

        }
        return bugs;

    }

    @Override
    public Bug findBugById(Long id) {
        Optional<Bug> byId = repo.findById(id);
        return byId.get();
    }
}
