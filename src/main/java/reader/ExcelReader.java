package reader;

import com.poiji.bind.Poiji;
import templates.Videogames;

import java.io.File;
import java.util.List;

public class ExcelReader {
    private static final String pathExcel = "src/main/java/data/dataExcel.xlsx";

    public static List<Videogames> getExcel(){
        return Poiji.fromExcel(new File(pathExcel), Videogames.class);
    }
}
