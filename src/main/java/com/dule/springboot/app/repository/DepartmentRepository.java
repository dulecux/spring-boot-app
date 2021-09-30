package com.dule.springboot.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dule.springboot.app.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	Department findByDepartmentName(String departmentName);
	
	Department findByDepartmentNameIgnoreCase(String departmentName);
	
	@Query(value = "SELECT * FROM DEPARTMENT", nativeQuery = true)
	List<Department> findAllDep();


}
