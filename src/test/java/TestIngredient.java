import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

import praktikum.Ingredient;
import praktikum.IngredientType;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class TestIngredient {
    private final IngredientType type;
    private final String name;
    private final float price;
    private Ingredient ingredient;

    public TestIngredient(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Test values: Type ingredient - {0} Name - {1} Price - {2}")
    public static Object[][] getIngredientsData() {
        return new Object[][] {
                {FILLING, "cutlet", 100.0f},
                {FILLING, "dinosaur", 200.0f},
                {FILLING, "sausage", 300.0f},
                {SAUCE, "hot sauce", 100.0f},
                {SAUCE, "sour cream", 200.0f},
                {SAUCE, "chili sauce", 300.0f},
                {FILLING, "test", 0.0f},
                {SAUCE, "test", 0.0f}
        };
    }

    @Before
    public void testIngredientStart() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void testGetName() {
        assertEquals("Некорректное название", name, ingredient.getName());
    }

    @Test
    public void testGetPrice() {
        ingredient = new Ingredient(type, name, price);
        assertEquals("Некорректная цена", price, ingredient.getPrice(), 0f);
    }
}
