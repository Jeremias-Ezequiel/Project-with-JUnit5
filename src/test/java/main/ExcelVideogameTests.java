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
        List<Videogames> listByCompany = Filters.filterGamesByCompany(completeList,company);
        long total = listByCompany.size(); 
        
        Assertions.assertEquals(6, total,"There are not 6 games from the Xbox company.");
    }

    @AfterEach
    void tearDown() {

    }
}
