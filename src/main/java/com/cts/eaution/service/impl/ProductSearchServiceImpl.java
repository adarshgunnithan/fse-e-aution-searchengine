package com.cts.eaution.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.eaution.dao.ProductIdAndName;
import com.cts.eaution.dao.ProductSearchDao;

import com.cts.eaution.vo.Category;
import com.cts.eaution.entities.ProductDocument;
import com.cts.eaution.service.BidSearchService;
import com.cts.eaution.service.ProductSearchService;
import com.cts.eaution.vo.ProductVO;
import com.cts.eaution.vo.BidVO;

@Service
public class ProductSearchServiceImpl  implements ProductSearchService{

	@Autowired
	ProductSearchDao productSearchDao;

	@Autowired
	BidSearchService bidSearchServiceImpl;
	@Override
	public List<ProductVO> getProductByName(String productName) {
		List <ProductDocument>productDocuments=productSearchDao.findByName(productName);
		List<ProductVO> products = new ArrayList<ProductVO>();
		for(ProductDocument productDocument : productDocuments) {
			ProductVO productVO = new ProductVO();
			BeanUtils.copyProperties(productDocument, productVO);
			products.add(productVO);
		}
		return products;
	}

	@Override
	public List<ProductIdAndName> getAllProductNames() {
		List<ProductIdAndName> productIdandNames=productSearchDao.findAllProjectedBy();
		return productIdandNames;
	}

	@Override
	public ProductVO getProductById(Long productId) {
		ProductVO productVO = null;
		// TODO Auto-generated method stub
		Optional<ProductDocument> productDocument=productSearchDao.findById(productId);
		if(productDocument.isPresent()) {
		List<BidVO>bids=bidSearchServiceImpl.getAllBids(productId);
		 productVO = new ProductVO();
		BeanUtils.copyProperties( productDocument.get(),productVO);
		productVO.setBids(bids);
		}
		return productVO;
	}

	@Override
	public List<ProductVO> getProducts(Category category) {
		// TODO Auto-generated method stub
		List<ProductDocument> productDocuments=productSearchDao.findByCategory(category.toString());
		List<ProductVO> products=new ArrayList<ProductVO>();
		for (ProductDocument productDocument :productDocuments) {
			ProductVO productVO = new ProductVO();
			BeanUtils.copyProperties(productDocument, productVO);
			products.add(productVO);
			
		}
		return products;
	}

	@Override
	public List<ProductVO> getAllProducts() {
		// TODO Auto-generated method stub
		Iterable<ProductDocument> productDocuments=productSearchDao.findAll();
		List<ProductVO> products= new ArrayList<ProductVO> ();
	
		for(ProductDocument productDocument : productDocuments) {
			ProductVO productVO = new ProductVO();
			BeanUtils.copyProperties(productDocument, productVO);
			products.add(productVO);
		}
		return products;
	}
}
