package com.gelo.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/stok")
public class StokController {

    @RequestMapping
    public String get(HttpServletRequest request){
        return "redirect:/stok/"+request.getSession(true).getId();
    }

    @RequestMapping(value = "/{stokId}", method = RequestMethod.GET)
    public String getStok(@PathVariable("stokId") String stokId, Model model){
        model.addAttribute("stokId", stokId);
        return "stok";
    }
}
