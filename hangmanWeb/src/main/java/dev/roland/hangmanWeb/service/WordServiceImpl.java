package dev.roland.hangmanWeb.service;

import dev.roland.hangmanWeb.model.Topic;
import dev.roland.hangmanWeb.model.Word;
import dev.roland.hangmanWeb.repository.TopicRepository;
import dev.roland.hangmanWeb.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class WordServiceImpl implements WordService {

    private final WordRepository wordRepository;
    private final TopicRepository topicRepository;

    @Autowired
    public WordServiceImpl(WordRepository wordRepository, TopicRepository topicRepository) {
        this.wordRepository = wordRepository;
        this.topicRepository = topicRepository;
    }

    @Override
    public List<Word> findAll() {
        return wordRepository.findAll();
    }

    @Override
    public Word findById(int id) {
        Optional<Word> resultOfQuery = wordRepository.findById(id);

        Word word;

        if (resultOfQuery.isPresent()) {
            word = resultOfQuery.get();
        } else {
            throw new RuntimeException("Did not find word with this id: " + id);
        }
        return word;
    }

    @Override
    public List<Word> findAllByTopic_Id(int topicId) {
       return wordRepository.findAllByTopic_Id(topicId);
    }

    @Override
    public void save(String name, int topicId) {
        Optional<Topic> topic = topicRepository.findById(topicId);
        if(topic.isPresent()) {
            Topic newTopic = topic.get();
            Word word = new Word();
            word.setName(name);
            word.setTopic(newTopic);
            wordRepository.save(word);
        }else {
            throw new RuntimeException("Did not find topic with this id: " + topicId);
        }
    }

    @Override
    public void save(Word word) {
        wordRepository.save(word);
    }

    @Override
    public void deleteById(int id) {
        wordRepository.deleteById(id);
    }

    @Override
    public String getRandomWordFromTopic(int topicId) {
        List<Word> listOfWords = findAllByTopic_Id(topicId);
        Random random = new Random();
        return listOfWords.get(random.nextInt(listOfWords.size())).getName();
    }
}
