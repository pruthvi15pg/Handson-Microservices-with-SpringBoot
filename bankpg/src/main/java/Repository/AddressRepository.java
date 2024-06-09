package Repository;

import com.ms.addresspg.Entity.Address;
import com.ms.addresspg.Model.AddressResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {

 AddressResponse findByAddress(String address);


    AddressResponse findByCity(String city);

    AddressResponse findByState(String state);
}
