package com.floor.decor.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.floor.decor.demo.dto.OrderDetailOfuser;
import com.floor.decor.demo.entity.AddToCart;
import com.floor.decor.demo.entity.Order;

@Repository
public interface OrderDetailRpository extends JpaRepository<Order, Long> {

//	@Query("SELECT new com.floor.decor.demo.dto.OrderDetailDTO(o.id,o.name,p.name,o.phoneNumber,o.address,o.landmark,o.city,o.pincode,o.activeStatus,o.approvedOrder,o.rejectedOrder) FROM Order o JOIN User u on o.userId=u.id JOIN Product p on o.productId=p.id WHERE o.userId = :id")
//	public List<OrderDetailDTO> orderDetailById(@Param("id") long id);

	@Query("SELECT DISTINCT o  FROM Order o LEFT OUTER JOIN o.carts a WHERE o.userId = :id")
	public List<?> orderDetailById(@Param("id") long id);

	@Query("SELECT o FROM Order o WHERE o.userId = :id AND ( o.approvedOrder = :status AND o.rejectedOrder = :status)")
	public List<Order> orderDetailByUserId(@Param("id") long id, @Param("status") boolean status);

	@Query("SELECT o FROM Order o WHERE o.userId = :id AND o.approvedOrder = 1")
	public List<Order> approveOrderDetailByUserId(@Param("id") long id);

	@Query("SELECT o FROM Order o WHERE o.userId = :id AND o.rejectedOrder = 1")
	public List<Order> rejectOrderDetailByUserId(@Param("id") long id);

//	@Query("SELECT o FROM Order o WHERE o.userId = :id AND o.approvedOrder = :status")
//	public List<Order> orderDetailByUserId(@Param("id") long id, @Param("status") boolean status);

	@Transactional
	@Modifying
	@Query("UPDATE Order o SET o.activeStatus = 1, o.approvedOrder = 1 WHERE o.id = :id")
	public void isActive(@Param("id") long id);

	@Transactional
	@Modifying
	@Query("UPDATE Order o SET o.activeStatus = 0, o.rejectedOrder = 1 WHERE o.id = :id")
	public void isInActive(@Param("id") long id);

	@Query("SELECT o FROM Order o WHERE o.approvedOrder = 1")
	public List<Order> findApprovedOrder();

	@Query("SELECT o FROM Order o WHERE o.rejectedOrder = 1")
	public List<Order> findRejectedOrder();

	@Query("FROM Order o WHERE o.rejectedOrder = 1")
	public List<Long> existsRejectedOrder();

	@Query("FROM Order o WHERE o.approvedOrder = 1")
	public int existsApprovedOrder();

	@Query("SELECT o FROM Order o WHERE o.userId = :id")
	public List<Order> getChartDetail(@Param("id") long id);

//	 Boolean existsApprovedOrder(boolean approvedOrder);
}
