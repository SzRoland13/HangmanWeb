package dev.roland.hangmanWeb.service;

import dev.roland.hangmanWeb.model.Word;

import java.util.List;

public interface WordService {

    List<Word> findAll();

    Word findById(int id);

    List<Word> findAllByTopicId(int topicId);

    Word save(Word word);

    void deleteById(int id);

    String getRandomWordFromTopic(int topicId);


}
