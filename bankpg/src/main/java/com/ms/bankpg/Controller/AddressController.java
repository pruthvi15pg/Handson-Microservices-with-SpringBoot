package com.ms.bankpg.Controller;

import com.ms.addresspg.Entity.Address;
import com.ms.addresspg.Model.AddressRequest;
import com.ms.addresspg.Model.AddressResponse;
import com.ms.addresspg.Repository.AddressRepository;
import com.ms.addresspg.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private AddressRepository addressRepository;

    @PostMapping("/saveAddress")
    public ResponseEntity<AddressResponse> saveAddress(@RequestBody AddressRequest addressRequest) {
        AddressResponse saveAddress=addressService.saveAddress(addressRequest);
        return new ResponseEntity(saveAddress, HttpStatus.CREATED);
    }

    @GetMapping("/{address}")
    public ResponseEntity<List<AddressResponse>> findByAddress(@PathVariable("address") String address){
        List<AddressResponse> findAddress=addressService.findByAddress(address);
        return new ResponseEntity(findAddress,HttpStatus.FOUND);
    }


    @GetMapping("/city")
    public ResponseEntity<AddressResponse> findByCity(@RequestParam(value = "city",required = false,defaultValue = "Hyderabad") String city) throws Exception {
      List<AddressResponse> findCity= city !=null
               ? addressService.getAllAddress()
               : (List<AddressResponse>) addressRepository.findByCity(city);
        return new ResponseEntity(findCity,HttpStatus.FOUND);
    }

@GetMapping("/allAddress")
    public ResponseEntity<List<AddressResponse>> getAllAddress() throws Exception {

        List<AddressResponse> getAddress=addressService.getAllAddress();

       return new ResponseEntity<>(getAddress,HttpStatus.FOUND);
    }

//   @GetMapping("/")
//    public ResponseEntity<AddressResponse> findByState(@RequestParam(value = "state",required = false) String state){
//        List<AddressResponse> addressResponseList=state!=null
//                ?addressRepository.findByState(state)
//       :addressService.
//
//        AddressResponse findState=addressRepository.findByState(state);
//        return new ResponseEntity(findState,HttpStatus.FOUND);
//    }

}
