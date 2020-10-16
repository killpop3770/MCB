package com.mcb.creditfactory.service.airplane;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.external.ExternalApproveService;
import com.mcb.creditfactory.model.Airplane;
import com.mcb.creditfactory.repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirplaneServiceImpl extends AirplaneService {

    @Autowired
    private ExternalApproveService approveService;

    @Autowired
    private AirplaneRepository airplaneRepository;

    @Override
    public boolean approve(AirplaneDto dto) {
        return approveService.approve(new AirplaneAdapter(dto)) == 0;
    }

    @Override
    public Airplane save(Airplane airplane) {
        return airplaneRepository.save(airplane);
    }

    @Override
    public Optional<Airplane> load(Long id) {
        return airplaneRepository.findById(id);
    }

    @Override
    public Airplane fromDto(AirplaneDto dto) {
        return new Airplane(
                dto.getId(),
                dto.getBrand(),
                dto.getModel(),
                dto.getPower(),
                dto.getManufacturer(),
                dto.getYear(),
                dto.getFuel(),
                dto.getSeats()
        );
    }

    @Override
    public AirplaneDto toDTO(Airplane airplane) {
        return new CarDto(
                airplane.getId(),
                airplane.getBrand(),
                airplane.getModel(),
                airplane.getPower(),
                airplane.getManufacturer(),
                airplane.getYear(),
                airplane.getFuel(),
                airplane.getSeats()
        );
    }

    @Override
    public Long getId(Airplane airplane) {
        return airplane.getId();
    }
}