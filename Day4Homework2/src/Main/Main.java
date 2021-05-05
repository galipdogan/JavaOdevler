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
		customer.setLastName("Do�an");
		customer.setDateOfBirth(1986);
		customer.setNationalityId(14132752386L);
		
		BaseCustomerManager customerManager = new StarbucksCustomerManager(new CustomerCheckService() {
			
			@Override
			public boolean checkIfRealPerson(Customer customer) {
				
				return false;
			}
		});
		customerManager.save(customer);
		
	}
}

