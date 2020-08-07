package am.gitc.service.impl;

import am.gitc.entities.Car;
import am.gitc.repository.CarRepository;
import am.gitc.service.CarService;
import org.joda.time.DateTime;
import org.joda.time.Years;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("carService")
@Repository
@Transactional
public class CarServiceImpl implements CarService {

    public boolean done;
    protected static Logger logger = LoggerFactory.getLogger(CarServiceImpl.class);

    @Autowired
    private  CarRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Car> findAll() {
        return repository.findAll();
    }

    @Override
    public Car save(Car car) {
        return repository.save(car);
    }

    @Override
    public void updateCarAgeJob() {
        List<Car> cars = repository.findAll();
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
        done = true;
    }

    @Override
    public boolean isDone() {
        return done;
    }
}
