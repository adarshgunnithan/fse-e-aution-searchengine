package com.cts.eaution.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.cts.eaution.entities.ProductDocument;

public interface ProductSearchDao  extends Repository<ProductDocument, Long> {
	/**
	 *Find Product by id
	 */
	Optional<ProductDocument> findById(Long id);
	  
	/**
	 *Get all products
	 */
	Iterable<ProductDocument> findAll();
	  
	  /**
	   * Get all products by name
	 * @param name
	 * @return List<Product>
	 * 
	 */
	List<ProductDocument> findByName(String name);
	
	/**
	 * Get product id and name of all products
	 * @return
	 */
	List<ProductIdAndName> findAllProjectedBy();
	
	/**
	 * Get product by category
	 * @param category
	 * @return
	 */
	List<ProductDocument> findByCategory(String category);
	
	
}
