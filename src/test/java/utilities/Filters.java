package utilities;

import templates.Videogames;

import java.util.ArrayList;
import java.util.Comparator;
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

    public static List<Videogames> filterGamesByGenre(List<Videogames> completeList, String genre){
        List<Videogames> filterList = new ArrayList<>();

        for(Videogames game : completeList){
            if(game.getGenre().equalsIgnoreCase(genre)){
                filterList.add(game);
            }
        }

        return filterList;
    }

    public static void sortGames(List<Videogames> list){
        list.sort((a,b) -> (a).getName().compareToIgnoreCase(b.getName()));
    }

    public static boolean verifySort (List<Videogames> completeList){
        for(int i = 0; i < (completeList.size() - 1); i++){
            if((completeList.get(i).getName().compareToIgnoreCase(completeList.get(i+1).getName()) > 0)){
                return false;
            }
        }
        return true;
    }

    public static List<Videogames> filterGamesByFirstLetter(List<Videogames> completeList, char firstLetter){
        List<Videogames> filterList = new ArrayList<>();

        for(Videogames game : completeList){
            if(Character.toUpperCase(game.getName().charAt(0)) == Character.toUpperCase(firstLetter)){
                filterList.add(game);
            }
        }

        return filterList;
    }




}
