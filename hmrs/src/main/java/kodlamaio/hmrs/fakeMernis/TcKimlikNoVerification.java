package kodlamaio.hmrs.fakeMernis;

public class TcKimlikNoVerification {
	
	 public boolean TCKimlikNoDogrula(String identityNumber, String firstName, String lastName, int birthOfYear) {
		 if(identityNumber!=null && identityNumber.length()==11 && firstName!=null && lastName!=null && birthOfYear!=0) {
				return true;
			}else 
				return false;	 
	 }

}
