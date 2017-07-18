import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lena on 07/07/2017.
 */
public class Collections {
  public static void main(String[] args){
    String langs[] = {"java", "Pyton", "Ruby"};
    List<String> languages = new ArrayList<String>();
    //    List<String> languages = Arrays.asList();

    for(String l:langs){
      System.out.println(l);
    }
  }
}
