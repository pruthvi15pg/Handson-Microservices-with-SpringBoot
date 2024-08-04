package com.ms.addresspg.Controller;

import com.ms.addresspg.Entity.Address;
import com.ms.addresspg.Model.AddressRequest;
import com.ms.addresspg.Model.AddressResponse;
import com.ms.addresspg.Repository.AddressRepository;
import com.ms.addresspg.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private AddressRepository addressRepository;

    @PostMapping("/saveAddress")
    @CacheEvict(value = "address", allEntries = true)
    public ResponseEntity<AddressResponse> saveAddress(@RequestBody AddressRequest addressRequest) {
        AddressResponse saveAddress = addressService.saveAddress(addressRequest);
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        return new ResponseEntity(saveAddress, HttpStatus.CREATED);
    }

    @GetMapping("/{address}")
    @CacheEvict(key = "#p0", value = "address")
    public ResponseEntity<List<AddressResponse>> findByAddress(@PathVariable("address") String address) {
        List<AddressResponse> findAddress = addressService.findByAddress(address);
         try{
             Thread.sleep(3000);
         }catch (InterruptedException e){
             e.printStackTrace();
         }
        return new ResponseEntity(findAddress, HttpStatus.FOUND);
    }


    @GetMapping("/city")
    @CacheEvict(key = "#p0", value = "address")
    public ResponseEntity<AddressResponse> findByCity(@RequestParam(value = "city", required = false, defaultValue = "Hyderabad") String city) throws Exception {
        List<AddressResponse> findCity = city != null
                ? addressService.getAllAddress()
                : (List<AddressResponse>) addressRepository.findByCity(city);
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        return new ResponseEntity(findCity, HttpStatus.FOUND);
    }

    @GetMapping("/allAddress")
    @Cacheable("address")
    public List<AddressResponse> getAllAddress() throws Exception {

        List<AddressResponse> getAddress = addressService.getAllAddress();

        return getAddress;
    }




    @DeleteMapping("/{id}")
    @CacheEvict(key = "#p0", value = "address")
    public String deleteAddress(@PathVariable("id") int addressid) throws Exception {
        Optional<Address> byId = addressRepository.findById(addressid);
     try {
         if (byId.isPresent()) {
             addressService.deleteAddress(addressid);
             Thread.sleep(3000);
         } else {
             throw new Exception("Address not found");
         }
     }catch (Exception e){
         e.printStackTrace();
     }

        return "address deleted successfully";
    }



    @GetMapping("/{id}")
    public ResponseEntity<AddressResponse> getAddressById(@PathVariable("id") int addressid) throws Exception {

           AddressResponse addressResponse = addressService.getAddressById(addressid);
       try{
           Thread.sleep(3000);
       }catch (InterruptedException e){
           e.printStackTrace();
       }
        return new ResponseEntity<>(addressResponse, HttpStatus.FOUND);
    }


}
