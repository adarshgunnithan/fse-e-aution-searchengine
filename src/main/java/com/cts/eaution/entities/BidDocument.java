package com.cts.eaution.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * @author aadi
 *No sql document for bid
 */
@Document(collection = "bids")
public class BidDocument  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8187576789804101123L;
	
	@Id
	private Long bidId;
	private BigDecimal biddingAmount;
	private Long productId;
	private UserDocument user;
	private Date bidCreatedDate;
	private Boolean isBidActive;

	public BidDocument() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getBidId() {
		return bidId;
	}

	public void setBidId(Long bidId) {
		this.bidId = bidId;
	}

	public BigDecimal getBiddingAmount() {
		return biddingAmount;
	}

	public void setBiddingAmount(BigDecimal biddingAmount) {
		this.biddingAmount = biddingAmount;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public UserDocument getUser() {
		return user;
	}

	public void setUser(UserDocument user) {
		this.user = user;
	}

	public Date getBidCreatedDate() {
		return bidCreatedDate;
	}

	public void setBidCreatedDate(Date bidCreatedDate) {
		this.bidCreatedDate = bidCreatedDate;
	}

	public Boolean getIsBidActive() {
		return isBidActive;
	}

	public void setIsBidActive(Boolean isBidActive) {
		this.isBidActive = isBidActive;
	}
	
}
