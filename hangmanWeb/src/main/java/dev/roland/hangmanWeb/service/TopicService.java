package dev.roland.hangmanWeb.service;

import dev.roland.hangmanWeb.model.Topic;

import java.util.List;

public interface TopicService {

    List<Topic> findAll();

    Topic findById(int id);

    String findNameOfTopicById(int id);

    Topic save(Topic topic);

    void deleteById(int id);

}
