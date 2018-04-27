package com.company.tpMonitoreo.repository;

import com.company.tpMonitoreo.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repositoryInterface extends JpaRepository<Log, Long> {

}
