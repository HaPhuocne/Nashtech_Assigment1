package nashtech.ass.phuochg.coffeeshop.services;

import java.util.List;

import nashtech.ass.phuochg.coffeeshop.entities.Information;

public interface InformationService {
public Information addInformation(Information information);
	
	public Information updateInformation(long id , Information information);

	public boolean deleteInformation(long id);
	
	public List<Information> getAllInformation();
	
	public Information getOneInformation(long id);
}
