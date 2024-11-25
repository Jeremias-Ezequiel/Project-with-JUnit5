package main;

import annotations.Regression;
import annotations.Smoke;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import reader.ExcelReader;
import templates.Videogames;
import utilities.BaseTests;
import utilities.Filters;
import utilities.Logs;

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
    void sortGamesByGenreTest() {
        String genre = "horror";
        List<Videogames> filterList = Filters.filterGamesByGenre(completeList,genre);
        Filters.sortGames(filterList);
        boolean result =  Filters.verifySort(filterList);

        Assertions.assertTrue(result, "The list is not sorted.");
    }

    @AfterEach
    void tearDown() {

    }
}
