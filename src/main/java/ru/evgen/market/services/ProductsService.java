package ru.evgen.market.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.evgen.market.models.Product;
import ru.evgen.market.repositories.ProductsRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProductsService {

    private final ProductsRepository productsRepository;

    @Autowired
    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    /**
     * Получение всех товаров из БД
     * @return список товаров
     */
    public List<Product> index(){
        return productsRepository.findAll();
    }

    /**
     * Поиск товара по наименованию или каталожному номеру
     * @param find данные для поиска из веб-представления
     * @return список найденных товаров
     */
    public List<Product> find(String find){
        return productsRepository.findDistinctByNameOrNumberOrderByName(find, find);
    }

    /**
     * Посик товаров по id
     * @param id товара
     * @return найденный товар или null
     */
    public Product show(int id){
        return (Product) productsRepository.findById(id).orElse(null);
    }

    /**
     * Поиск товаров по применяемости
     * @param find применяемость товаров из веб-представления
     * @return список найденных товаров
     */
    public List<Product> applying(String find) {
        return productsRepository.findDistinctByApplyingIgnoreCaseOrderByName(find);
    }

}
