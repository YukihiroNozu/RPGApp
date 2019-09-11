package jp.co.systena.tigerscave.rpgapp.service;

import java.util.ArrayList;
import java.util.List;
import jp.co.systena.tigerscave.rpgapp.form.CharacterParameter;

public class CharacterParameterService {

  public List<CharacterParameter> getCharacterParameter() {


    List<CharacterParameter> human = new ArrayList<CharacterParameter>();

    CharacterParameter CharacterParameter = new CharacterParameter();

    CharacterParameter.setName("よしひこ");
    CharacterParameter.setJob("戦士");
    CharacterParameter.setHp(100);
    human.add(CharacterParameter);

    return human;
  }
}