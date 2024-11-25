package main;

import annotations.Regression;
import annotations.Smoke;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;
import reader.ExcelReader;
import templates.Videogames;
import utilities.BaseTests;
import utilities.Filters;
import utilities.Logs;

import java.util.ArrayList;
import java.util.List;

public class ExcelVideogameTests extends BaseTests {

    private List<Videogames> completeList;

    @BeforeEach
    void setUp() {
        completeList = ExcelReader.getExcel();
    }

    @Test
    @Regression
    @Smoke
    @Description("Verify that there are 6 Xbox games")
    @Severity(SeverityLevel.NORMAL)
    void gamesCountByCompanyTest() {
        String company = "XBOX";
        Logs.info("The company is: %s",company);

        List<Videogames> listByCompany = Filters.filterGamesByCompany(completeList,company);
        int total = listByCompany.size();
        Logs.info("Total of games: %d", total);
        
        Assertions.assertEquals(7, total,"There are not 6 games from the Xbox company.");
        Logs.info("Test complete");
    }

    @Test
    @Regression
    @Smoke
    @Description("Filter the games by genre and sort them")
    @Severity(SeverityLevel.NORMAL)
    void sortGamesByGenreTest() {
        String genre = "horror";
        Logs.info("The genre to filter is: " + genre);

        List<Videogames> filterList = Filters.filterGamesByGenre(completeList,genre);
        Logs.info("Filtered list");

        Filters.sortGames(filterList);
        Logs.info("Sorted list");

        boolean result =  Filters.verifySort(filterList);
        Logs.info("The result is: " + result);

        Assertions.assertTrue(result, "The list is not sorted.");
    }

    @Test
    @Regression
    @Smoke
    @Description("Verify the size of the list filtered by the first letter of a video game")
    @Severity(SeverityLevel.BLOCKER)
    void sizeOfListFilteredByFirstLetter() {

        char firstLetter = 't';
        Logs.info("The letter to filter is: " + firstLetter);

        List<Videogames> filterList = Filters.filterGamesByFirstLetter(completeList, firstLetter);
        Logs.info("List filtered");

        int size = filterList.size();
        Logs.info("The size of the list is: " + size);

        Assertions.assertTrue(size > 0,"The list is empty");
    }

    @Test
    @Regression
    @Smoke
    @Description("This test checks that the all movie's era is between two different years")
    @Severity(SeverityLevel.CRITICAL)
    void movieEraBetweenTest() {
        int age1 = 2001;
        int age2 = 2019;
        Logs.info("Between years: " + age1 + " - " + age2);

        List<Videogames> notAreBetweenTheYears = new ArrayList<>();

        for(Videogames game : completeList){
            if(game.getEra() < age1 || game.getEra() > age2){
                notAreBetweenTheYears.add(game);
            }
        }

        Assertions.assertTrue(notAreBetweenTheYears.isEmpty(), "There are movies that not are between the years: " + notAreBetweenTheYears);
    }

    @AfterEach
    void tearDown() {

    }
}
