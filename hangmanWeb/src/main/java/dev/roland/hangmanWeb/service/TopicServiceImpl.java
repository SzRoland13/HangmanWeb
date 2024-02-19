package dev.roland.hangmanWeb.service;

import dev.roland.hangmanWeb.model.Topic;
import dev.roland.hangmanWeb.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;

    @Autowired
    public TopicServiceImpl(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    public List<Topic> findAll() {
        return topicRepository.findAll();
    }

    @Override
    public Topic findById(int id) {

        Optional<Topic> resultOfSearch = topicRepository.findById(id);

        Topic theTopic;

        if (resultOfSearch.isPresent()) {
            theTopic = resultOfSearch.get();
        } else {
            throw new RuntimeException("Did not find the topic " + id);
        }
        return theTopic;
    }

    @Override
    public String findNameOfTopicById(int id) {
      Topic theTopic = findById(id);
      return theTopic.getName();
    }

    @Override
    public Topic save(Topic topic) {
        return topicRepository.save(topic);
    }

    @Override
    public void deleteById(int id) {
        topicRepository.deleteById(id);
    }
}
