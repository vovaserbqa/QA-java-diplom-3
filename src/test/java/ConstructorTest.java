import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class ConstructorTest extends Base {

    @Test
    @DisplayName("going to the 'Buns' section")
    public void bunsSectionTest() {
        mainPage.clickFilling();
        mainPage.clickBun();
        assertTrue("went to the Buns section", mainPage.isBunActive());
    }

    @Test
    @DisplayName("going to the 'Sauces' section")
    public void saucesSectionTest() {
        mainPage.clickSauce();
        assertTrue("went to the Sauces section", mainPage.isSauceActive());
    }

    @Test
    @DisplayName("going to the 'Fillings' section")
    public void saucesFillingsTest() {
        mainPage.clickFilling();
        assertTrue("Не зашел в Начинки", mainPage.isFillingActive());
    }
}