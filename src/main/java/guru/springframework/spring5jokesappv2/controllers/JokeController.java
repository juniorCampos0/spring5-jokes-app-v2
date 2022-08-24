package guru.springframework.spring5jokesappv2.controllers;

import guru.springframework.spring5jokesappv2.services.JokeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JokeController {

    private final JokeService jokeService;

    public JokeController(@Qualifier("chuckNorrisJokeService") JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @GetMapping({"/",""})
    public String jokes(Model model) {
        model.addAttribute("joke",jokeService.getRandomJoke());
        return "index";
    }

}
