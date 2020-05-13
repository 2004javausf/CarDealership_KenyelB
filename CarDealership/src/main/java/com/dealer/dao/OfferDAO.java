package com.dealer.dao;

import java.sql.SQLException;
import java.util.List;

import com.dealer.beans.Customer;
import com.dealer.beans.Offer;

public interface OfferDAO {
	
	public void insertNewOffer(int carID, String userName, int offerAmount, String offerStatus)throws SQLException;
	
	public List<Offer>getofferList() throws SQLException;
	public List<Offer>viewofferList() throws SQLException;
//	public List<Offer>viewCOfferList() throws SQLException;
	public void customerOfferList(Customer customer) throws SQLException;
}
