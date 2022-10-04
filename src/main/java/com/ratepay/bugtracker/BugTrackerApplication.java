package com.ratepay.bugtracker;

import com.ratepay.bugtracker.model.Bug;
import com.ratepay.bugtracker.service.BugService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;

@SpringBootApplication
@EnableJpaRepositories("com.ratepay.bugtracker.repository")
@Slf4j
public class BugTrackerApplication implements CommandLineRunner {
	@Autowired
	private BugService bugService;


	public static void main(String[] args) {
		SpringApplication.run(BugTrackerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Bug bug=new Bug();
		bug.setBugOpened(new Date());
		bug.setDescription("console not working");
		bug.setCreatedBy("John");
		bug.setName("Jms ser");
		bugService.addBug(bug);
		log.info("Bug has been added " +bug.toString());
		Bug bug1=new Bug();
		bug1.setBugOpened(new Date());
		bug1.setDescription("console not working");
		bug1.setCreatedBy("John");
		bug1.setName("backend service");
		bugService.addBug(bug1);
		log.info("Bug has been added " +bug1.toString());
		Bug bug2=new Bug();
		bug2.setBugOpened(new Date());
		bug2.setName("console");
		bug2.setDescription("console not working");
		bug2.setCreatedBy("John");
		bugService.addBug(bug2);
		log.info("Bug has been added " +bug2.toString());
	}
}
