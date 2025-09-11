package com.br.aweb.sistema_vendas.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.aweb.sistema_vendas.model.Produto;
import com.br.aweb.sistema_vendas.services.ProdutoServices;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/produto")
public class ProdutoController {
    
    @Autowired
    private ProdutoServices produtoService;

    @GetMapping("/novo")
    public ModelAndView create() {
        return new ModelAndView("produto/form", Map.of("produto", new Produto()));
    }

    @PostMapping("/novo")
    public String create(@Valid Produto produto, BindingResult result) {
        if (result.hasErrors()) {
            return "produto/form";
        }
        produtoService.salvar(produto);
        return "redirect:/produto";
    }

}
