package com.uangteman.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.uangteman.entity.Category;
import com.uangteman.entity.Product;

public interface ProductRepo extends CrudRepository<Product, Long>{
	
	public List<Product> findByNameIgnoringCase(String name);
	public List<Product> findAll();
	
	//Querynya bukan SQL tetapi JPAQl, bukan ke tabel melainkan ke Object(Class)
	@Query("select prod from Product prod where prod.name " + "like :paramName")
	public List<Product> findByName(@Param("paramName")
				String paramName);
	
	@Query("select p from Product p where p.harga between :min and :max")
	public List<Product> findByPriceRange(@Param("min") double min, @Param("max") double max);
	
	@Query("select p from Product p where p.category = :categoryParam")
	public List<Product> findByProductCategory(@Param("categoryParam") Category category);
	

}
