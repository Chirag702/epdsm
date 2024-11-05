
package com.onefactor.epdsm.department.service.impl;

import com.onefactor.epdsm.department.entity.Department;
import com.onefactor.epdsm.department.repository.DepartmentRepository;
import com.onefactor.epdsm.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private final DepartmentRepository departmentRepository;

	@Autowired
	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}

	@Override
	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}

	@Override
	public Optional<Department> getDepartmentById(Long id) {
		return departmentRepository.findById(id);
	}

	@Override
	public Department createDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public Department updateDepartment(Long id, Department department) {
		if (departmentRepository.existsById(id)) {
			department.setId(id);
			return departmentRepository.save(department);
		} else {
			throw new RuntimeException("Department not found with id " + id);
		}
	}

	@Override
	public void deleteDepartment(Long id) {
		departmentRepository.deleteById(id);
	}
}
