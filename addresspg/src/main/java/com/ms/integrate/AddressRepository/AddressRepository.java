package com.ms.integrate.OrderRepository;

import com.ms.integrate.Entity.Address;
import com.ms.integrate.Model.AddressResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {

 AddressResponse findByAddress(String address);


    AddressResponse findByCity(String city);

    AddressResponse findByState(String state);
}
