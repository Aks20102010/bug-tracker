package com.ratepay.bugtracker.controlloer;

import com.ratepay.bugtracker.exception.BugNotFoundException;
import com.ratepay.bugtracker.model.Bug;
import com.ratepay.bugtracker.model.MessageResponse;
import com.ratepay.bugtracker.service.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BugController {
    @Autowired
    private BugService service;

    @PostMapping("/bug")
    public ResponseEntity<?> addBug(@RequestBody Bug bug){
        Bug addedBug = service.addBug(bug);
        return new ResponseEntity<Object>(addedBug, HttpStatus.CREATED);

    }
    @PutMapping("/bug/{id}")
    public ResponseEntity<?> updateBug(@PathVariable("id") Long userId, @RequestBody Bug bug){
        bug.setId(userId);
        Bug updatedBug = service.updateBug(bug);
        return new ResponseEntity<Object>(updatedBug, HttpStatus.OK);
    }

    /**delete a bug based on bug ID.
     * @param id
     * @return
     */

    @DeleteMapping(value="/delete-bug/{id}")
    public ResponseEntity<?> deleteBug(@PathVariable Long id){
        if(id ==null){
            throw new BugNotFoundException("id can't found ");

        }
        service.deleteBug(id);
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setMessage("Bug has been deleted successfully.");
        return new ResponseEntity<Object>(messageResponse, HttpStatus.OK);



    }
    /**get all list of bugs based on GET request.
     * @return
     */
    @GetMapping(value="/bugs")
    public ResponseEntity<?> getAllBugs(){
        List<Bug> bugs = service.getBugs();
        return new ResponseEntity<Object>(bugs, HttpStatus.OK);


    }

    /*** get a bug by ID in GET request, end point is http://hostname:port/api/va1/bug/id
     * @param id
     * @return
     */

    @GetMapping(value = "/bug/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Long id) {
        Bug bug = service.findBugById(id);
        if (bug == null) {
            MessageResponse messageResponse = new MessageResponse();
            messageResponse.setMessage("User not found.");
            return new ResponseEntity<Object>(messageResponse, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Object>(bug, HttpStatus.OK);
    }
    @GetMapping(value = "/hello")
    public ResponseEntity<?> helloworld() {

        return new ResponseEntity<Object>("hello-world", HttpStatus.OK);
    }

}
