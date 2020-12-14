package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CharList {

    static List<String> list = new ArrayList<>() ;

    public static void shuffle() throws FileNotFoundException {
        Scanner s = new Scanner(new File("C:\\Users\\EnesGuven\\IdeaProjects\\MatrixEffect\\src\\sample\\character.txt"));
        list = new ArrayList<>();
        while (s.hasNext()) list.add(s.next());
        s.close();
    }
}
