package com.hc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hc.enums.PaymentTypeEnums;
import com.hc.enums.PurchaseMethodEnums;
import com.hc.model.PaymentInfo;
 
public class PaymentHistoryMapper implements RowMapper
{
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		PaymentInfo payment = new PaymentInfo();
		
		payment.setBilledAmount(rs.getString("billedAmount"));
		payment.setCreated(rs.getDate("created"));
		//payment.setEmailId(rs.getString("emailId"));
		payment.setId(rs.getString("id"));
		payment.setLastupdated(rs.getDate("lastupdated"));
		payment.setOtherDetails(rs.getString("otherDetails"));
		payment.setPaymentType(PaymentTypeEnums.values()[rs.getInt("paymentType")]);
		payment.setPurchaseMethod(PurchaseMethodEnums.values()[rs.getInt("purchaseMethod")]);
		payment.setTransactionId(rs.getString("transactionId"));
		
		return payment;
	}
 
}
