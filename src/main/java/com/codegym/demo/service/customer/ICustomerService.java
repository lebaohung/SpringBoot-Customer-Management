package com.codegym.demo.service.customer;

import com.codegym.demo.model.Customer;
import com.codegym.demo.model.Province;
import com.codegym.demo.service.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService extends IService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);
    Page<Customer> findAllByFirstNameContaining(String firstName, Pageable pageable);
}