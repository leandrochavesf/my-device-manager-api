package me.leandrochaves.my_device_manager_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import me.leandrochaves.my_device_manager_api.model.Device;
import me.leandrochaves.my_device_manager_api.service.DeviceService;

@RestController
@RequestMapping("/api")
public class DeviceController {

  @Autowired
  DeviceService deviceService;

  @GetMapping("/device")
  public Page<Device> getAllDevices(@RequestParam(defaultValue = "0") int page, 
  @RequestParam(defaultValue = "10") int size) {
    return deviceService.findAll(page, size);
  }

  @PostMapping("/device")
  @ResponseStatus(HttpStatus.CREATED)
  public Device createDevice(@RequestBody Device device){
    return deviceService.save(device);
  }

  @GetMapping("/device/{id}")
  public Device getDeviceById(@PathVariable Long id) {
    return deviceService.findById(id);
  }

  @GetMapping("/device/brand/{brand}")
  public List<Device> getDeviceByBrand(@PathVariable String brand) {
    return deviceService.findByBrand(brand);
  }

  @PutMapping("/device/{id}")
  public Device updateDeviceById(@PathVariable Long id, @RequestBody Device device) {
    return deviceService.updateById(id, device);
  }

  @PatchMapping("/device/{id}")
  public Device updatePartialDeviceById(@PathVariable Long id, @RequestBody Device device) {
    return deviceService.updatePartialById(id, device);
  }

  @DeleteMapping("/device/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteDevice(@PathVariable Long id) {
    deviceService.deleteById(id);
  }
}
