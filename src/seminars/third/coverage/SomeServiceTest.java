package seminars.third.coverage;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import seminars.third.coverage.SomeService;

public class SomeServiceTest {
    @Test
    public void testFizzBuzz() {
        SomeService service = new SomeService();
        assertEquals("Fizz", service.fizzBuzz(3));
        assertEquals("Buzz", service.fizzBuzz(5));
        assertEquals("FizzBuzz", service.fizzBuzz(15));
        assertEquals("7", service.fizzBuzz(7));
    }

    @Test
    public void testFirstLast6() {
        SomeService service = new SomeService();
        int[] arr1 = {1, 2, 6};
        int[] arr2 = {6, 1, 2, 3};
        int[] arr3 = {13, 6, 1, 2};
        assertTrue(service.firstLast6(arr1));
        assertTrue(service.firstLast6(arr2));
        assertFalse(service.firstLast6(arr3));
    }

    @Test
    public void testCalculatingDiscount() {
        SomeService service = new SomeService();
        assertEquals(80.0, service.calculatingDiscount(100.0, 20));
        assertEquals(90.0, service.calculatingDiscount(100.0, 10));
        assertEquals(100.0, service.calculatingDiscount(100.0, 0));
    }

    @Test
    public void testCalculatingDiscountInvalidDiscount() {
        SomeService service = new SomeService();
        assertThrows(IllegalArgumentException.class, () -> service.calculatingDiscount(100.0, -10));
        assertThrows(IllegalArgumentException.class, () -> service.calculatingDiscount(100.0, 110));
    }

    @Test
    public void testSumWithout13() {
        SomeService service = new SomeService();
        assertEquals(6, service.sumWithout13(1, 2, 3));
        assertEquals(3, service.sumWithout13(1, 13, 2));
        assertEquals(0, service.sumWithout13(13, 2, 3));
        assertEquals(0, service.sumWithout13(13, 13, 13));
    }
    @Test
    public void testIsEven() {
        SomeService service = new SomeService();
        assertTrue(service.isEven(2));
        assertTrue(service.isEven(4));
        assertFalse(service.isEven(3));
        assertFalse(service.isEven(7));
    }
    @Test
    public void testIsInRange() {
        SomeService service = new SomeService();
        assertTrue(service.isInRange(30));
        assertTrue(service.isInRange(50));
        assertFalse(service.isInRange(10));
        assertFalse(service.isInRange(150));
    }
}
