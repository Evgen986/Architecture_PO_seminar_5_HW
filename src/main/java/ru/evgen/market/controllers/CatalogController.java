package ru.evgen.market.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.evgen.market.models.Product;
import ru.evgen.market.services.ProductsService;

import java.util.List;

@Controller
@RequestMapping("/catalog")
public class CatalogController {

    private ProductsService productsService;

    @Autowired
    public CatalogController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping()
    public String catalog(Model model){
        List<Product> allProducts = productsService.index();
        model.addAttribute("products", allProducts);
        return "catalog/catalog";
    }

    @GetMapping("/{id}")
    public String product(@PathVariable("id") int id, Model model){
        model.addAttribute(productsService.show(id));
        return "catalog/product";
    }

    @PostMapping("/find")
    public String find(@RequestParam(value = "find", required = false) String find, Model model){
        List <Product> findProducts = productsService.find(find);
        model.addAttribute("products", findProducts);
        return "catalog/catalog";
    }

    @PostMapping("/applying")
    public String findApplying(@RequestParam(value = "find", required = false) String find, Model model){
        System.out.println(find);
        List <Product> findApplying = productsService.applying(find);
        model.addAttribute("products", findApplying);
        return "catalog/catalog";
    }
}
