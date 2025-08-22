package com.bootcamp.demo.project_data_provider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SymbolRepository extends JpaRepository<SymbolEntity, Long> {

}
