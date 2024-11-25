package templates;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;

@ExcelSheet("videogames")
public class Videogames {
    @ExcelCellName("NAME")
    private String name;
    @ExcelCellName("ERA")
    private int era;
    @ExcelCellName("PRICE")
    private double price;
    @ExcelCellName("DURATION")
    private int duration;
    @ExcelCellName("GENRE")
    private String genre;
    @ExcelCellName("COMPANY")
    private String company;

    public String getName() {
        return name;
    }

    public int getEra() {
        return era;
    }

    public double getPrice() {
        return price;
    }

    public int getDuration() {
        return duration;
    }

    public String getGenre() {
        return genre;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public String toString() {
        String multiline = """
                {
                    Name: %s,
                    Era: %d,
                    Price: %.2f,
                    Duration: %d,
                    Genre: %s,
                    Company: %s
                }
                """;
        return String.format(multiline,name,era,price,duration,genre,company);
    }
}
