package com.example.Odontoprev.controller;

import com.example.Odontoprev.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ai")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("/perguntar")
    public String perguntar(@RequestParam("pergunta") String pergunta, Model model) {
        String resposta = chatService.enviarMensagem(pergunta);
        model.addAttribute("pergunta", pergunta);
        model.addAttribute("resposta", resposta);
        return "resposta_ia";
    }

    @GetMapping("/form")
    public String formularioPergunta() {
        return "perguntar";
    }

}
