package nashtech.ass.phuochg.coffeeshop.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import nashtech.ass.phuochg.coffeeshop.dto.InformationDto;
@Service
public interface InformationService {

	public ResponseEntity<?> updateInformation(long id, InformationDto informationDto);

}