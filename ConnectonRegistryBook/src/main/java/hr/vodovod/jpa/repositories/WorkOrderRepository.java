package hr.vodovod.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.vodovod.model.WorkOrder;

public interface WorkOrderRepository extends JpaRepository<WorkOrder, Integer> {

}
