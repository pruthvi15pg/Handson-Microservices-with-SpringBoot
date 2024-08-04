package com.ms.addresspg.Service;

import com.ms.addresspg.Model.AddressRequest;
import com.ms.addresspg.Model.AddressResponse;

import java.util.List;

public interface AddressService {
   AddressResponse saveAddress(AddressRequest addressRequest);

   List<AddressResponse> getAllAddress() throws Exception;

   List<AddressResponse> findByAddress(String address);

   public String deleteAddress(int addressid);

   AddressResponse getAddressById(int addressid);
}
