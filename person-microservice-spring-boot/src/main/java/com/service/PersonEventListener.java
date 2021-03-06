package com.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class PersonEventListener implements
		ApplicationListener<PersonServiceEvent> {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	// Person Change this according to your application needs
	public void onApplicationEvent(PersonServiceEvent event) {
		PersonServiceEvent personEvent = (PersonServiceEvent) event;
		logger.info("Person " + event.getEventType() + " with details : "
				+ personEvent.getEventPerson());
	}
}
