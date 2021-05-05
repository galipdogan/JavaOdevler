package Adapter;

import java.rmi.RemoteException;
import java.util.Locale;

import Abstract.GamerCheckService;
import Entities.Gamer;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;


public class MernisServiceAdapter implements GamerCheckService {

	@Override
	public boolean checkIfRealPerson(Gamer gamer) {
		KPSPublicSoap client = new KPSPublicSoapProxy();
		boolean result = true;
		try {
			client.TCKimlikNoDogrula(
					gamer.getNationalityId(), 
					gamer.getFirstName().toUpperCase(new Locale("tr")),
					gamer.getLastName().toUpperCase(new Locale("tr")), 
					gamer.getDateOfBirth());
		} catch (RemoteException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
}
