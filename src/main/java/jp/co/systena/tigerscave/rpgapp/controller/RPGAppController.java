package jp.co.systena.tigerscave.rpgapp.controller;


import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscave.rpgapp.form.CharacterParameter;
import jp.co.systena.tigerscave.rpgapp.service.CharacterParameterService;

@Controller // Viewあり。Viewを返却するアノテーション
public class RPGAppController {

  @Autowired
  HttpSession session; // セッション管理

  @RequestMapping("/CreateCharacter") // URLとのマッピング
  public String createCharacter(){

    // Viewのテンプレート名を返す
    return "CreateCharacter";
  }

  @RequestMapping(value = "/dicideCharacter", method = RequestMethod.GET) // URLとのマッピング
  public ModelAndView index(ModelAndView mav) {


    CharacterParameterService service = new CharacterParameterService();
      List<CharacterParameter> human = service.getCharacterParameter();

      mav.addObject("baseCharacterForm", human);


      return mav;
  }

  @RequestMapping("/dicideCharacter") // URLとのマッピング
  public String dicideCharacter(){

    int a = 0;
    a = 2;

    // Viewのテンプレート名を返す
    return "selectCommand";
  }
}
