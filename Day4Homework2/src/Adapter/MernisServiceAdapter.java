package Adapter;

import java.rmi.RemoteException;
import java.util.Locale;

import Abstract.CustomerCheckService;
import Entities.Customer;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements CustomerCheckService {

	@Override
	public boolean checkIfRealPerson(Customer customer) {
		KPSPublicSoapProxy client =new KPSPublicSoapProxy();
			boolean result = true;
			try{
			result=client.TCKimlikNoDogrula(
					customer.getNationalityId(), 
					customer.getFirstName().toUpperCase(new Locale("tr")), 
					customer.getLastName().toUpperCase(new Locale("tr")), 
					customer.getDateOfBirth());
		}catch (RemoteException e){
			result = false; 
			e.printStackTrace(); 
		}	
		return result;
		
	}

}
