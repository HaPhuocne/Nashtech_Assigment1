package nashtech.ass.phuochg.coffeeshop.servicesimpl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import nashtech.ass.phuochg.coffeeshop.dto.InformationDto;
import nashtech.ass.phuochg.coffeeshop.entities.Account;
import nashtech.ass.phuochg.coffeeshop.entities.Information;
import nashtech.ass.phuochg.coffeeshop.exceptions.handlers.ResourceFoundExceptions;
import nashtech.ass.phuochg.coffeeshop.repositories.AccountRepository;
import nashtech.ass.phuochg.coffeeshop.repositories.InfomationRepository;
import nashtech.ass.phuochg.coffeeshop.response.MessageResponse;
import nashtech.ass.phuochg.coffeeshop.services.InformationService;

@Component
public class InformationServiceImpl implements InformationService {

	@Autowired
	InfomationRepository infomationRepository;
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	ModelMapper modelMapper;
	


	@Override
	public ResponseEntity<?> updateInformation(long id, InformationDto informationDto) {
		// TODO Auto-generated method stub
		Optional<Information> optionalInformation = infomationRepository.findById(id);
		if(!optionalInformation.isPresent()) {
			throw new ResourceFoundExceptions("Information not found");
		}
		Optional<Account> optionalAccount = accountRepository.findById(informationDto.getAccount().getIdAccount());
		if(!optionalAccount.isPresent()) {
			throw new ResourceFoundExceptions("Account not found");
		}
		
		Information reInformation = optionalInformation.get();
		if(!reInformation.getPhoneNumber().equals(informationDto.getPhoneNumber())) {
			Optional<Information> optionalPhoneNumber = infomationRepository.findByPhoneNumber(informationDto.getPhoneNumber());
			if(optionalPhoneNumber.isPresent()) {
				throw new IllegalArgumentException("Phone number is already taken");
			}
		}
	
		modelMapper.map(informationDto, reInformation);
		infomationRepository.save(reInformation);
		return ResponseEntity.ok(new MessageResponse("Update information successfully !"));
	}


	

}
