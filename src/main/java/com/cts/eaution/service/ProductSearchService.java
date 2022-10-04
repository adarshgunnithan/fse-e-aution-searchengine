package com.cts.eaution.service;

import java.util.List;

import com.cts.eaution.dao.ProductIdAndName;
import com.cts.eaution.entities.Category;
import com.cts.eaution.vo.ProductVO;

/**
 * @author aadi
 *API to search products
 */
public interface ProductSearchService {
	/**
	 * Get All products matching to name
	 * @param productName
	 * @return List<ProductVO>
	 */
	public List<ProductVO> getProductByName(String productName);
	
	/**
	 * To get all product names
	 * @return List<ProductIdAndName> 
	 */
	public List<ProductIdAndName> getAllProductNames();
	
	/**
	 * To get product by id
	 * @param productId
	 * @return ProductVO
	 */
	public ProductVO getProductById(Long productId);
	
	public List<ProductVO> getProducts(Category category);
	
	public List<ProductVO>  getAllProducts();
}
