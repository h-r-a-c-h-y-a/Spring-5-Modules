package am.gitc.service.impl;

import am.gitc.entities.Car;
import org.joda.time.DateTime;
import org.joda.time.Years;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("scheduledCarService")
@Repository
@Transactional
public class ScheduledCarServiceImpl extends CarServiceImpl {
    @Override
//    @Scheduled(fixedRate = 10000)
    public void updateCarAgeJob() {
        List<Car> cars = findAll();
        DateTime currentDate = DateTime.now();
        logger.info("Car age update job started");
        cars.forEach(car -> {
            int age = Years.yearsBetween(
                    car.getManufactureDate(),
                    currentDate
            ).getYears();
            car.setAge(age);
            save(car);
        });
        logger.info("Car age update job completed "
                + "successfully");
    }
}


@FunctionalInterface
interface TemperatureMeasurementCallback {
    public void temperatureMeasured(int temperature);
}


interface Thermometer {
    public int measure();
}

@Configuration
@EnableScheduling
@Import({FakeThermometer.class, WeatherForecastService.class})
class Config {

    @Bean
    public TemperatureMeasurementCallback callback() {
        return (temperature) -> System.out.println(temperature);
    }

}

@Component
@Scope(value = "provider")
class FakeThermometer implements Thermometer {

    private int currentTemperature = 21;

    @Override
    public int measure() { return currentTemperature++; }
}

@Service
public class WeatherForecastService {

    @Autowired
    private Thermometer thermometer;
    @Autowired
    private TemperatureMeasurementCallback callback;

    @Scheduled(fixedDelay = 50)
    public void takeTemperatureMeasurement() {
        int temperature = thermometer.measure();
        callback.temperatureMeasured(temperature);
    }
}