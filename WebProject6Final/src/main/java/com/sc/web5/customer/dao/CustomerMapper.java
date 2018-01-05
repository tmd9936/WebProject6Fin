package com.sc.web5.customer.dao;

import com.sc.web5.customer.vo.Customer;

public interface CustomerMapper {
	//id로 유저 찾기 <select id="searchCustomer" parameterType="String" resultType="customer">
	public Customer searchCustomerOne(String custid);
	
	// 회원가입 <insert id="joinCustomer" parameterType="customer">
	public int joinCustomer(Customer customer);
	
	//유저 수정 <update id="updateCustomer" parameterType="customer">
	public int updateCustomer(Customer customer);
}
