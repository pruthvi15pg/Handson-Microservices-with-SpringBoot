package Service;

import com.ms.addresspg.Model.AddressRequest;
import com.ms.addresspg.Model.AddressResponse;

import java.util.List;

public interface AddressService {
   AddressResponse saveAddress(AddressRequest addressRequest);

   List<AddressResponse> getAllAddress() throws Exception;

   List<AddressResponse> findByAddress(String address);
}
