package dev.roland.hangmanWeb.controller;

import dev.roland.hangmanWeb.model.Word;
import dev.roland.hangmanWeb.service.TopicService;
import dev.roland.hangmanWeb.service.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/nav")
public class NavigationController {

    private final WordService wordService;

    private final TopicService topicService;

    public NavigationController(WordService wordService, TopicService topicService){
        this.topicService = topicService;
        this.wordService = wordService;
    }

    @GetMapping("/start")
    public String startGame() {
        return "navigation/start-page";
    }

    @GetMapping("/edit/wordsAndTopics")
    public String addWordAndTopics(Model model){
        model.addAttribute("topics", topicService.findAll());

        return "navigation/list-words-and-topics";
    }

    @GetMapping("/edit/getWordsByTopic")
    @ResponseBody
    public List<Word> getWordsByTopic(@RequestParam int topicId){
        return wordService.findAllByTopicId(topicId);
    }
}
