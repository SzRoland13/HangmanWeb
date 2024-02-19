package dev.roland.hangmanWeb.controller;

import dev.roland.hangmanWeb.model.ResponseGameData;
import dev.roland.hangmanWeb.model.Topic;
import dev.roland.hangmanWeb.service.GameService;
import dev.roland.hangmanWeb.service.TopicService;
import dev.roland.hangmanWeb.service.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/game")
public class GameController {

    private WordService wordService;
    private TopicService topicService;
    private GameService gameService;

    public GameController(WordService wordService, TopicService topicService, GameService gameService) {
        this.wordService = wordService;
        this.topicService = topicService;
        this.gameService = gameService;
    }

    @GetMapping("/chooseTopic")
    public String chooseTopic(Model model) {
        List<Topic> listOfTopics = topicService.findAll();

        model.addAttribute("topics", listOfTopics);

        return "game/choose-topic";
    }

    @GetMapping("/initializeGame")
    public String initializeGame(@RequestParam("topicId") int id, Model model) {
        String secretWord = wordService.getRandomWordFromTopic(id);
        gameService.initializeGame(secretWord, id);

        model.addAttribute("viewOfSecretWord", gameService.getViewOfSecretWord());
        model.addAttribute("numberOfMistakes", gameService.getNumberOfMistakes());
        model.addAttribute("titleOfTopic", topicService.findNameOfTopicById(gameService.getIdOfTopic()));

        return "game/game-view";
    }

    @PostMapping("/handleGuess")
    @ResponseBody
    public ResponseGameData handleGuess(@RequestParam("guessedChar") char guessedChar){
        gameService.makeGuess(guessedChar);
        ResponseGameData responseGameData = new ResponseGameData(gameService.getViewOfSecretWord(), gameService.getNumberOfMistakes(), topicService.findNameOfTopicById(gameService.getIdOfTopic()), gameService.isSecretWordContainsGuess(guessedChar), gameService.hasRemainingMistakes());
        System.out.println(responseGameData);
        return responseGameData;
    }
}
