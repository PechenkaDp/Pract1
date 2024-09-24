package com.example.pract1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConverterController {

    @PostMapping("/convert")
    public String convert(@RequestParam("amount") double amount,
                          @RequestParam("fromCurrency") String fromCurrency,
                          @RequestParam("toCurrency") String toCurrency, Model model) {
        double rate = 0.0;
        if (fromCurrency.equals("USD") && toCurrency.equals("EUR")) {
            rate = 0.85;
        } else if (fromCurrency.equals("EUR") && toCurrency.equals("USD")) {
            rate = 1.17;
        }
        double result = amount * rate;
        model.addAttribute("result", result);
        return "conversionResult";
    }
}
