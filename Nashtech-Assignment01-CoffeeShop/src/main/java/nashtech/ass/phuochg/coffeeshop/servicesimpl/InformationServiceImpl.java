package nashtech.ass.phuochg.coffeeshop.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import nashtech.ass.phuochg.coffeeshop.entities.Information;
import nashtech.ass.phuochg.coffeeshop.repositories.InfomationRepository;
import nashtech.ass.phuochg.coffeeshop.services.InformationService;

public class InformationServiceImpl implements InformationService {

	@Autowired
	InfomationRepository inforR;

	@Override
	public Information addInformation(Information information) {
		return inforR.save(information);
	}

	@Override
	public Information updateInformation(long id, Information information) {
		if (information != null) {
			Information rInformation = inforR.getById(id);
			if (rInformation != null) {
				rInformation.setAddress(rInformation.getAddress());
				rInformation.setName(rInformation.getName());
				rInformation.setPhoneNumber(rInformation.getPhoneNumber());
				return inforR.save(rInformation);
			}
		}
		return null;
	}

	@Override
	public boolean deleteInformation(long id) {
		if (id >= 1) {
			Information information = inforR.getById(id);
			if (information != null) {
				inforR.delete(information);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Information> getAllInformation() {
		return inforR.findAll();
	}

	@Override
	public Information getOneInformation(long id) {
		return inforR.getById(id);
	}

}
