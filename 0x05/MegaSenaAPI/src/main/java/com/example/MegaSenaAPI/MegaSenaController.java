package com.example.MegaSenaAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/megasena")
public class MegaSenaController {

    @GetMapping("/simpleMessageWelcome")
    public String mensagemBoasVindas() {
        return "Bem vindo a API REST para geração de números para a loteria Mega Sena.";
    }


    @GetMapping("/getNumbers")
    public List<Integer> numerosMegaSena() {
        Random rnd = new Random();
        ArrayList<Integer> listaSorteador = rnd.ints(6, 1, 60)
                .boxed().collect(Collectors.toCollection(ArrayList::new));
        listaSorteador.sort(Comparator.naturalOrder());
        return listaSorteador;
    }
}
