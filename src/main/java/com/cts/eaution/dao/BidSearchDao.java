package com.cts.eaution.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.Repository;

import com.cts.eaution.entities.BidDocument;
public interface BidSearchDao extends Repository<BidDocument, Long>{
	/**
	 * Get by productid
	 * @param productId
	 * @return
	 */
	@Query("{'productId' : ?0}")
	List<BidDocument> findByproduct(Long productId);
}
