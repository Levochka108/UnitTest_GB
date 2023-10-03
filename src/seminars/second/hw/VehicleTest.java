package seminars.second.hw;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class VehicleTest {
    @Test
    public void testCarIsInstanceOfVehicle() {
        Car car = new Car("Company", "Model", 2022);
        assertThat(car).isInstanceOf(Vehicle.class);
    }

    @Test
    public void testCarHasFourWheels() {
        Car car = new Car("Company", "Model", 2022);
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    @Test
    public void testMotorcycleHasTwoWheels() {
        Motorcycle motorcycle = new Motorcycle("Company", "Model", 2022);
        assertThat(motorcycle.getNumWheels()).isEqualTo(2);
    }

    @Test
    public void testCarTestDrive() {
        Car car = new Car("Company", "Model", 2022);
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }

    @Test
    public void testMotorcycleTestDrive() {
        Motorcycle motorcycle = new Motorcycle("Company", "Model", 2022);
        motorcycle.testDrive();
        assertThat(motorcycle.getSpeed()).isEqualTo(75);
    }

    @Test
    public void testCarPark() {
        Car car = new Car("Company", "Model", 2022);
        car.testDrive();
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
    }

    @Test
    public void testMotorcyclePark() {
        Motorcycle motorcycle = new Motorcycle("Company", "Model", 2022);
        motorcycle.testDrive();
        motorcycle.park();
        assertThat(motorcycle.getSpeed()).isEqualTo(0);
    }
}
