package com.bootcamp.demo.project_data_provider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.project_data_provider.entity.SymbolEntity;

@Repository
public interface SymbolRepository extends JpaRepository<SymbolEntity, String> {

}
