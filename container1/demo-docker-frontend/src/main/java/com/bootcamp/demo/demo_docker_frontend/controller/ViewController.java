package com.bootcamp.demo.demo_docker_frontend.controller;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.demo.demo_docker_frontend.service.NameService;
import com.bootcamp.demo.demo_docker_frontend.service.StockService;

@Controller
public class ViewController {
  @Autowired
  private NameService nameService;

  @Autowired
  private StockService stockService;

  @GetMapping(value = "/")
  public String getNames(Model model) {
    model.addAttribute("nameList", nameService.names());
    model.addAttribute("ohlcList", stockService.getOHLC().getChart().getResults()[0].getMeta());
    return "default"; // default.html
  }
}
