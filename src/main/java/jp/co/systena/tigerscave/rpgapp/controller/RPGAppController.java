package jp.co.systena.tigerscave.rpgapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Viewあり。Viewを返却するアノテーション
public class RPGAppController {

  @RequestMapping("/CreateCharacter") // URLとのマッピング
  public String createCharacter(){

    // Viewのテンプレート名を返す
    return "CreateCharacter";
  }
}
