package utilities;

import templates.Videogames;

import java.util.ArrayList;
import java.util.List;

public class Filters {
    public static List<Videogames> filterGamesByCompany(List<Videogames> completeList, String company){
        List<Videogames> filterList = new ArrayList<>();

        for(Videogames game : completeList){
            if(game.getCompany().equalsIgnoreCase(company)){
                filterList.add(game);
            }
        }

        return filterList;
    }

}
