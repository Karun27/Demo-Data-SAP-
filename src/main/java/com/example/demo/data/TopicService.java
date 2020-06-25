package com.example.demo.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	Logger logger = LoggerFactory.getLogger(TopicService.class);
	@Autowired
	private TopicRepository topicRepository;

//	private List<Topic> topics = new ArrayList<> (Arrays.asList(
//			new Topic("a", "b", "c"),
//			new Topic("d", "b", "c"),
//			new Topic("e", "b", "c")
//			));
	
	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics::add);
		logger.trace("0MAT_PLANT_ATTR-5eda72059ff7a66854f1d12b-All topics retrieved : Completed ");
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topicRepository.findOne(id);	}

	public void addTopic(Topic topic) {
		 topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);		
	}

	public void deleteTopic(String id) {
		topicRepository.delete(id);
		
	}
}
