package kodlamaio.hmrs.adapter;

import org.springframework.stereotype.Service;

import kodlamaio.hmrs.core.utilities.mernis.PersonCheckService;
import kodlamaio.hmrs.entities.concretes.JobSekeer;
import kodlamaio.hmrs.fakeMernis.TcKimlikNoVerification;


@Service
public class MernisServiceAdapter implements PersonCheckService {

	@Override
	public boolean checkIfRealPerson(JobSekeer jobSekeer) {
//		@Override
//		public boolean checkIfRealPerson(Gamer gamer) {
//			KPSPublicSoap client = new KPSPublicSoapProxy();
//			boolean result = true;
//			try {
//				client.TCKimlikNoDogrula(
//						gamer.getNationalityId(), 
//						gamer.getFirstName().toUpperCase(new Locale("tr")),
//						gamer.getLastName().toUpperCase(new Locale("tr")), 
//						gamer.getDateOfBirth());
//			} catch (RemoteException e) {
//				result = false;
//				e.printStackTrace();
//			}
//			return result;
//		}

		TcKimlikNoVerification checkPerson = new TcKimlikNoVerification();
		boolean result = true;
		try {
			result = checkPerson.TCKimlikNoDogrula(jobSekeer.getNationalityId(), jobSekeer.getFirstName(),
					jobSekeer.getLastName(), jobSekeer.getDateOfBirth().getYear());
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}
		return result;

	}

}
