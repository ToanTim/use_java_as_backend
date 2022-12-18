package com.example.hotel_booking;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

  @GetMapping("/")
  public String getIndex() {
    return "index";
  }

  /*
   * spring.datasource.url=jdbc:h2:file:./database;create=true
   * spring.datasource.username=sa
   * spring.datasource.password=
   * 
   * spring.jpa.hibernate.ddl-auto=update
   * spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect
   * spring.jpa.show-sql=true
   */

  /*
   * @GetMapping("*")
   * public String redirectToIndex() {
   * return "redirect:/";
   * }
   */

}