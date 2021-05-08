package Main;

import Abstract.BaseCustomerManager;
<<<<<<< HEAD
import Adapter.MernisServiceAdapter;
import Concrete.NeroCustomerManager;
import Concrete.StarbucksCustomerManager;
import Entities.Customer;

public class Main {

	public static void main(String[] args) {
		
		Customer customer = new Customer();
		customer.setId(1);
		customer.setFirstName("Galip");
		customer.setLastName("Doðan");
		customer.setDateOfBirth(1905);
		customer.setNationalityId(12345678912L);
		
		BaseCustomerManager customerManager = new NeroCustomerManager();
=======
import Abstract.CustomerCheckService;
import Adapter.MernisServiceAdapter;
import Concrete.NeroCustomerManager;
import Concrete.StarbucksCustomerManager;
import Entities.Customer;

public class Main {

	public static void main(String[] args) {
		
		Customer customer = new Customer();
		customer.setId(1);
		customer.setFirstName("Galip");
		customer.setLastName("Doðan");
		customer.setDateOfBirth(1986);
		customer.setNationalityId(14132752386L);
		
		BaseCustomerManager customerManager = new StarbucksCustomerManager(new CustomerCheckService() {
			
			@Override
			public boolean checkIfRealPerson(Customer customer) {
				
				return false;
			}
		});
>>>>>>> branch 'master' of https://github.com/galipdogan/JavaOdevler.git
		customerManager.save(customer);
		
	}
}

