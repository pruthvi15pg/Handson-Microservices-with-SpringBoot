package Service;

import com.ms.addresspg.Entity.Address;
import com.ms.addresspg.Model.AddressRequest;
import com.ms.addresspg.Model.AddressResponse;
import com.ms.addresspg.Repository.AddressRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public AddressResponse saveAddress(AddressRequest addressRequest) {

        log.info("addressRequest from client:{}", addressRequest);
        Address address = Address.builder()
                .address(addressRequest.getAddress())
                .state(addressRequest.getState())
                .city(addressRequest.getCity())
                .postalcode(addressRequest.getPostalcode())
                .build();
        addressRepository.save(address);

        log.info("address saved in database:{}", address);

        AddressResponse addressResponse = AddressResponse.builder()
                .address(address.getAddress())
                .state(address.getState())
                .postalcode(address.getPostalcode())
                .city(address.getCity())
                .build();

        log.info("address Response:{}", addressResponse);
        return addressResponse;
    }


    public List<AddressResponse> getAllAddress() throws Exception {
        List<Address> address = addressRepository.findAll();
        if (address == null) throw new Exception("No addresses Found");
//        List<AddressResponse> collectAllAdresses = address.stream().map(add -> {
//            AddressResponse adr = AddressResponse.builder()
//                    .address(add.getAddress())
//                    .country(add.getCountry())
//                    .city(add.getCity())
//                    .postalcode(add.getPostalcode())
//                    .state(add.getState())
//                    .build();
//            return adr;
//        }).collect(Collectors.toList());

        List<AddressResponse> addressResponse = address.stream().map(a -> mapToAddressResponse(a)).toList();
        return addressResponse;
    }

    @Override
    public List<AddressResponse> findByAddress(String address) {
        List<Address> alladdress = addressRepository.findAll();
        List<AddressResponse> collectByAddress;
        String message = "Given Address----" + address + "-----not found";
        try {
            Address address1 = alladdress.stream().filter(a -> a.getAddress().equals(address))
                    .findAny()
                    .orElseThrow(() -> new RuntimeException(message));
            collectByAddress = (List<AddressResponse>) mapToAddressResponse(address1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return collectByAddress;
    }

    private AddressResponse mapToAddressResponse(Address address) {
        return AddressResponse
                .builder()
                .city(address.getCity())
                .country(address.getCountry())
                .state(address.getState())
                .postalcode(address.getPostalcode())
                .build();
    }


}
