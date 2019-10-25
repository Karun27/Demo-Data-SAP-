package com.example.demo.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class TopicService {
	
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
