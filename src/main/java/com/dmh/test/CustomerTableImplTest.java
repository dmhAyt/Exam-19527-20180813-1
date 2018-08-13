package com.dmh.test;


import com.dmh.dao.CustomerTable;
import com.dmh.dao.impl.CustomerTableImpl;
import com.dmh.entity.Customer;
import org.junit.jupiter.api.Test;

/**
 * Created by deng_yt on 2018/8/13.
 */
public class CustomerTableImplTest {

  public static void main(String[] args) throws Exception {
    CustomerTable ct = new CustomerTableImpl();
    Customer mary = ct.findCustomerByFirstName("MARY");
    System.out.println(mary.toString());

  }

}