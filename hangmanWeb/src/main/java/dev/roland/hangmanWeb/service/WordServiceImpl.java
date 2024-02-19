package dev.roland.hangmanWeb.service;

import dev.roland.hangmanWeb.model.Word;
import dev.roland.hangmanWeb.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class WordServiceImpl implements WordService {

    private final WordRepository wordRepository;

    @Autowired
    public WordServiceImpl(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
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
    public List<Word> findAllByTopicId(int topicId) {
       return wordRepository.findAllByTopicId(topicId);
    }

    @Override
    public Word save(Word word) {
        return wordRepository.save(word);
    }

    @Override
    public void deleteById(int id) {
        wordRepository.deleteById(id);
    }

    @Override
    public String getRandomWordFromTopic(int topicId) {
        List<Word> listOfWords = findAllByTopicId(topicId);
        Random random = new Random();
        return listOfWords.get(random.nextInt(listOfWords.size())).getName();
    }
}
