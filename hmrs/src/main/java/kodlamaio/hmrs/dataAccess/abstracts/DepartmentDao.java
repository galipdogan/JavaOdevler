package kodlamaio.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.Department;


public interface DepartmentDao extends JpaRepository<Department, Integer> {
	Department getByName(String name);
	List<Department> getByNameContains(String name);
}
