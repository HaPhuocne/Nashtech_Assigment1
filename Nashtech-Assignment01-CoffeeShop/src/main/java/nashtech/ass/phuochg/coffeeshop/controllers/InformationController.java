package nashtech.ass.phuochg.coffeeshop.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nashtech.ass.phuochg.coffeeshop.dto.InformationDto;
import nashtech.ass.phuochg.coffeeshop.services.InformationService;

@RestController
@RequestMapping("/information")
public class InformationController {
	@Autowired
	InformationService informationService ;
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateInformation(@PathVariable("id")Long id,@Valid @RequestBody InformationDto informationDto){
		return informationService.updateInformation(id, informationDto);
	}

}
