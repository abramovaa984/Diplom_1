import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TestBun {
    private Bun bun;

    @Before
    public void createBun() {
        bun = new Bun("black bun", 100.0f);
    }

    @Test
    public void testBunGetName() {
        String expectedName = "black bun";
        String actualName = bun.getName();

        assertEquals("Некорректное название булки", expectedName, actualName);
    }

    @Test
    public void testBunGetPrice() {
        float expectedPrice = 100.0f;
        float actualPrice = bun.getPrice();

        assertEquals("Некорректная цена булки", expectedPrice, actualPrice, 0.0f);
    }
}
