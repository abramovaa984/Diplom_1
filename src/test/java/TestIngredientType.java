import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

import praktikum.IngredientType;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class TestIngredientType {
    private final IngredientType type;
    private final String name;

    public TestIngredientType(IngredientType type, String name) {
        this.type = type;
        this.name = name;
    }

    @Parameterized.Parameters(name = "Test values: Type ingredient - {0} Name - {1}")
    public static Object[][] getIngredientsData() {
        return new Object[][] {
                {FILLING, "FILLING"},
                {SAUCE, "SAUCE"}
        };
    }

    @Test
    public void testIngredientTypeName() {
        assertEquals("Некорректное имя типа ингридиента", name, type.name());
    }

}