package br.com.aweb.sistema_produto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.aweb.sistema_produto.model.Product;
import br.com.aweb.sistema_produto.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
@RequestMapping("/products")

public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping()
    public String list(Model model) {
        model.addAttribute("products", productService.listAll());
        return "products/list";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("product", new Product());
        return "products/form";
    }
    
    
}
