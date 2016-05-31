package com.org.coop.society.data.admin.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.coop.society.data.admin.entities.BranchMaster;

public interface BranchMasterRepository extends JpaRepository<BranchMaster, Integer> {
	public BranchMaster findByMicrCode(String micrCode);
	public BranchMaster findByIfscCode(String ifscCode);
	
	public BranchMaster findByMicrCodeAndIfscCode(String micrCode, String ifscCode);
	
	public BranchMaster findByBranchId(int branchId);
	
	public List<BranchMaster> findByParentId(int parentId);
}
