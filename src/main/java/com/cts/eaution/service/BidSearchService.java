package com.cts.eaution.service;
import java.util.List;

import com.cts.eaution.vo.BidVO;
/**
 * @author aadi
 *API for bid search
 */
public interface BidSearchService {

	/**
	 * Get all bids by product id
	 * @param productID
	 * @return
	 */
	List<BidVO> getAllBids(Long productID);
}
