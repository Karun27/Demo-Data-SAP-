package com.example.demo.data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	Logger logger = LoggerFactory.getLogger(TopicController.class);
	@Autowired
	private TopicService topicService;

	@Autowired
	ResourceLoader resourceLoader;
	
	@RequestMapping("/hello")
	public String getHello(String some) {
		return "Hello, args";
	}
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		logger.trace("0MAT_PLANT_ATTR-5eda72059ff7a66854f1d12b-Retrieving all topics : Started ");
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics" )
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}" )
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(id, topic);	
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}" )
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);	
	}

}
