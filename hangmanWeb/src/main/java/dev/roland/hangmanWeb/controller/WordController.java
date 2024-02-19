package dev.roland.hangmanWeb.controller;

import dev.roland.hangmanWeb.model.Word;
import dev.roland.hangmanWeb.service.TopicService;
import dev.roland.hangmanWeb.service.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/word")
public class WordController {

    private final WordService wordService;

    private final TopicService topicService;

    public WordController(WordService wordService, TopicService topicService) {
        this.wordService = wordService;
        this.topicService = topicService;
    }

    @GetMapping("/update/showFormForUpdate/{wordId}")
    public String showFormForUpdate(@PathVariable("wordId") int wordId, Model model) {
        System.out.println("Got the wordId: " + wordId);
        Word word = wordService.findById(wordId);

        model.addAttribute("word", word);
        model.addAttribute("topics", topicService.findAll());

        return "word/word-form";
    }

    @GetMapping("/add/showFormForAdd")
    public String showFormForAdd(Model model){
        Word word = new Word();
        model.addAttribute("word", word);
        model.addAttribute("topics", topicService.findAll());

        return "word/word-form";
    }

    @PostMapping("/save")
    public String saveFormData(@RequestParam("word") Word word) {
        wordService.save(word);
        return "redirect:navigation/list-words-and-topics";
    }

    @GetMapping("/delete/{wordId}")
    public String delete(@PathVariable("wordId") int wordId) {
        wordService.deleteById(wordId);

        return "redirect:navigation/list-words-and-topics";
    }


}
