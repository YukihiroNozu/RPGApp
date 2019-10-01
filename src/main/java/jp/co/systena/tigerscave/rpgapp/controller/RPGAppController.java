package jp.co.systena.tigerscave.rpgapp.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscave.rpgapp.form.CharacterParameter;
import jp.co.systena.tigerscave.rpgapp.form.WarriorClass;
import jp.co.systena.tigerscave.rpgapp.form.WizardClass;

@Controller // Viewあり。Viewを返却するアノテーション
public class RPGAppController {

  @Autowired
  HttpSession session; // セッション管理

  @RequestMapping("/CreateCharacter") // URLとのマッピング
  public String createCharacter() {

    // Viewのテンプレート名を返す
    return "CreateCharacter";
  }

  @RequestMapping(value = "/session", method = RequestMethod.POST) // URLとのマッピング
  public ModelAndView index(ModelAndView mav, @Valid CharacterParameter characterParameter,
      BindingResult bindingResult, HttpServletRequest request) {

    session.setAttribute("CharacterParameter", characterParameter);

    return new ModelAndView("redirect:/dicideCharacter"); // リダイレクト
  }

  @RequestMapping(value = "/dicideCharacter", method = RequestMethod.GET) // URLとのマッピング
  public ModelAndView dicideCharacter(ModelAndView mav) {

    CharacterParameter human = (CharacterParameter) session.getAttribute("CharacterParameter");

    if (human.getJob().equals("戦士")) {

      CharacterParameter warrior = new WarriorClass();

      warrior.attack();

      String attackMessage = warrior.getMessage();

      warrior = (CharacterParameter) session.getAttribute("CharacterParameter");

      warrior.message = attackMessage;

      mav.addObject("CharacterParameter", warrior);

    } else if (human.getJob().equals("魔法使い")) {

      CharacterParameter wizard = new WizardClass();

      wizard.attack();

      String attackMessage = wizard.getMessage();

      wizard = human;

      wizard.message = attackMessage;

      mav.addObject("CharacterParameter", wizard);

    }else {

      human.setMessage("は石を投げて攻撃した。");

      mav.addObject("CharacterParameter", human);

    }

    // Viewのテンプレート名を返す

    mav.setViewName("selectCommand");

    return mav;
  }

  @RequestMapping(value = "/session2", method = RequestMethod.POST) // URLとのマッピング
  public ModelAndView index2(ModelAndView mav, @Valid CharacterParameter characterParameter,
      BindingResult bindingResult, HttpServletRequest request) {

//    session.setAttribute("CharacterParameter", characterParameter);

    // CharacterParameterService service = new CharacterParameterService();
    // List<CharacterParameter> human = service.getCharacterParameter();
    // mav.addObject("CharacterParameter", characterParameter);

    return new ModelAndView("redirect:/attack"); // リダイレクト
  }

  @RequestMapping(value = "/attack", method = RequestMethod.GET) // URLとのマッピング
  public ModelAndView result(ModelAndView mav) {

    CharacterParameter human = (CharacterParameter) session.getAttribute("CharacterParameter");

    mav.addObject("CharacterParameter", human);

    // Viewのテンプレート名を返す

    mav.setViewName("result");

    return mav;
  }
}
