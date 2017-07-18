import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lena on 01/07/2017.
 */
public class Collections {
  public static void main(String[] args){
    String[] langs = {"Java","C#", "Pyton", "PHP"};
    List<String> languages = new ArrayList<String>();
    languages.add("Java");
    languages.add("C#");
//    for (int i = 0; i< langs.length; i++){
//      System.out.println("I want to learn" + " " + langs[i]);

      for (String l : langs){
        System.out.println("I want to learn" + " " + l);
      }
    }

  }
//}
