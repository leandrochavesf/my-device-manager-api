package me.leandrochaves.my_device_manager_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import me.leandrochaves.my_device_manager_api.model.Device;

public interface DeviceRepository extends JpaRepository<Device, Long> {

  List<Device> findByBrand(String brand);;
  
}