import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;

@RunWith(MockitoJUnitRunner.class)
public class TestBurger {
    Database data = new Database();

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Mock
    private Ingredient filling;
    private Burger burger;

    @Before
    public void createBurger() {
        burger = new Burger();
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(bun);

        assertEquals("Некорректное добавление булки", bun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient);
        List<Ingredient> expected = List.of(ingredient);
        List<Ingredient> actual = burger.ingredients;

        assertEquals("Некорректное добавление ингридиента", expected, actual);
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        List<Ingredient> actual = burger.ingredients;

        assertEquals("Некорректное удаление ингридиента", List.of(), actual);
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(filling);
        burger.addIngredient(ingredient);
        burger.moveIngredient(0,1);
        Ingredient actual = burger.ingredients.get(1);

        assertEquals("Некорректное перемещение ингридиента", filling, actual);
    }

    @Test
    public void testGetPrice() {
        burger.setBuns(data.availableBuns().get(2));
        burger.addIngredient(data.availableIngredients().get(4));
        burger.addIngredient(data.availableIngredients().get(2));
        burger.addIngredient(data.availableIngredients().get(3));
        float actual = burger.getPrice();

        assertEquals(1200, actual,0);
    }

    @Test
    public void testGetReceipt() {
        burger.setBuns(data.availableBuns().get(1));
        burger.addIngredient(data.availableIngredients().get(2));
        burger.addIngredient(data.availableIngredients().get(5));
        Bun bun = burger.bun;

        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        List<Ingredient> ingredients = burger.ingredients;
        for (Ingredient ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

        assertEquals("Некорректный чек", receipt.toString(), burger.getReceipt());
    }
}
