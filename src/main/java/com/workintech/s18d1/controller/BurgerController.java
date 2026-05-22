package com.workintech.s18d1.controller;

import com.workintech.s18d1.dao.BurgerDao;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.util.BurgerValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/burger")
public class BurgerController {

    private final BurgerDao burgerDao;

    @Autowired
    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }

    @GetMapping
    public List<Burger> findAll() {
        return burgerDao.findAll();
    }

    @GetMapping("/{id}")
    public Burger findById(@PathVariable Integer id) {
        return burgerDao.findById(id);
    }

    @PostMapping
    public Burger save(@RequestBody Burger burger) {
        BurgerValidation.checkBurgerParams(burger.getName(), burger.getPrice());
        log.info("Burger kaydediliyor: {}", burger);
        return burgerDao.save(burger);
    }

    @PutMapping("/{id}")
    public Burger update(@RequestBody Burger burger, @PathVariable Integer id) {
        burger.setId(id);
        return burgerDao.update(burger);
    }

    @DeleteMapping("/{id}")
    public Burger remove(@PathVariable Integer id) {
        return burgerDao.remove(id);
    }

    @GetMapping("/findByPrice")
    public List<Burger> findByPrice(@RequestParam Double price) {
        return burgerDao.findByPrice(price);
    }

    @GetMapping("/findByBreadType")
    public List<Burger> findByBreadType(@RequestParam BreadType breadType) {
        return burgerDao.findByBreadType(breadType);
    }

    @GetMapping("/findByContent")
    public List<Burger> findByContent(@RequestParam String content) {
        return burgerDao.findByContent(content);
    }
}
