package Main;

import Abstract.BaseCustomerManager;
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
		customer.setDateOfBirth(1905);
		customer.setNationalityId(12345678912L);
		
		BaseCustomerManager customerManager = new StarbucksCustomerManager(new CustomerCheckService() {
			
			@Override
			public boolean checkIfRealPerson(Customer customer) {
				// TODO Auto-generated method stub
				return false;
			}
		});
		customerManager.save(customer);
		
	}
}

