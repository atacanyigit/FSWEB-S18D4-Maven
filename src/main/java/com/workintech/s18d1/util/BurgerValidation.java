package com.workintech.s18d1.util;

import com.workintech.s18d1.exceptions.BurgerException;
import org.springframework.http.HttpStatus;

public class BurgerValidation {
    public static void checkBurgerParams(String name, Double price) {
        if (name == null || name.isEmpty() || price == null || price < 0) {
            throw new BurgerException("Geçersiz burger parametreleri! Name ve Price dolu ve pozitif olmalıdır.", HttpStatus.BAD_REQUEST);
        }
    }
}