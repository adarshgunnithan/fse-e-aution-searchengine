package com.cts.eaution.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.eaution.dao.ProductIdAndName;

import com.cts.eaution.vo.Category;
import com.cts.eaution.service.ProductSearchService;
import com.cts.eaution.vo.ProductVO;

/**
 * @author aadi
 *Controller for product search
 */
@RestController
@RequestMapping("product")
public class ProductSearchController {
	
	@Autowired
	ProductSearchService productSearchServiceImpl;
	
	/**
	 * Get all products
	 * @return
	 */
	@GetMapping("/all")
	public ResponseEntity<List<ProductVO>> getAllproducts(){
		List<ProductVO> products= null;
		products=productSearchServiceImpl.getAllProducts();
		return new ResponseEntity<List<ProductVO>>(products, HttpStatus.OK);
		
	}
	
	/**
	 * Get by product name
	 * @param productName
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<ProductVO>> getProductByName (@RequestParam("name") String productName){
		List<ProductVO> products=null;
		products=productSearchServiceImpl.getProductByName(productName);
		return new ResponseEntity<List<ProductVO>>(products, HttpStatus.OK);
		
	}
	/**
	 * Get all product names
	 * @return
	 */
	@GetMapping("/names/")
	public ResponseEntity<List<ProductIdAndName>> getAllProductNames(){
		List<ProductIdAndName> IdAndNames=productSearchServiceImpl.getAllProductNames();
		return new ResponseEntity<List<ProductIdAndName>>(IdAndNames,HttpStatus.OK);
	}
	
	/**
	 * Get by product id
	 * @param productId
	 * @return
	 */
	@GetMapping("/{productId}")
	public ResponseEntity<ProductVO> getProductById (@PathVariable Long productId){
		ProductVO productVO=productSearchServiceImpl.getProductById(productId);
		return new  ResponseEntity<ProductVO>(productVO,HttpStatus.OK);
	}
	
	/**
	 * Get products by category
	 * @param category
	 * @return
	 */
	@GetMapping("/category/{category}")
	public ResponseEntity<List<ProductVO>> getProducts (@PathVariable Category category){
		List<ProductVO> products=productSearchServiceImpl.getProducts(category);
		return new ResponseEntity<List<ProductVO>>(products,HttpStatus.OK);
		
	}

}
