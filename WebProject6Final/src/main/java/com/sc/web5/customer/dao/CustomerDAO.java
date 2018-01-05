package com.sc.web5.customer.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sc.web5.customer.vo.Customer;

@Repository
public class CustomerDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerDAO.class);
	
	@Autowired
	SqlSession sqlSession;
	
	public Customer searchCustomerOne(String custid) {
		logger.info("회원 정보 검색 시작");
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		
		Customer customer = null;
		try {
			customer = mapper.searchCustomerOne(custid);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		logger.info("회원 정보 검색 종료");
		return customer;
	}
	
	public int joinCustomer(Customer customer){
		logger.info("회원 등록 시작");
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		
		int result = 0;
		try{
			result = mapper.joinCustomer(customer);
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		logger.info("회원 등록 종료");
		return result;
	}
	
	public int updateCustomer(Customer customer){
		logger.info("회원 수정 시작");
		
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		
		int result = 0;
		try {
			result = mapper.updateCustomer(customer);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		logger.info("회원 수정 종료");
		return result;
	}
	
}
