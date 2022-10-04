package com.cts.eaution.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.eaution.dao.BidSearchDao;
import com.cts.eaution.entities.BidDocument;
import com.cts.eaution.service.BidSearchService;
import com.cts.eaution.vo.BidVO;
@Service
public class BidSearchServiceImpl implements BidSearchService{
	@Autowired
	BidSearchDao bidSearchDao;

	@Override
	public List<BidVO> getAllBids(Long productId) {
		List<BidDocument> bidDocuments=bidSearchDao.findByproduct(productId);
		List<BidVO> bids= new ArrayList<BidVO>();
		for (BidDocument bidDocument : bidDocuments) {
			BidVO bidVO = new BidVO();
			BeanUtils.copyProperties(bidDocument, bidVO);
			bids.add(bidVO);
			
		}
		return bids;
	}

}
