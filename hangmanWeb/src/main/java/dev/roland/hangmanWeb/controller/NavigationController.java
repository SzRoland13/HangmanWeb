package dev.roland.hangmanWeb.controller;

import dev.roland.hangmanWeb.model.Word;
import dev.roland.hangmanWeb.service.TopicService;
import dev.roland.hangmanWeb.service.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @PostMapping("/edit/getWordsByTopic")
    @ResponseBody
    public List<Word> getWordsByTopic(@RequestBody Map<String, Integer> body) {
        int topicId = body.get("topicId");
        if(topicId == 0) {
            return wordService.findAll();
        }else return wordService.findAllByTopic_Id(topicId);
    }
}
