package com.ats.triladmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.triladmin.model.SettingValue;

public interface SettingValueRepository extends JpaRepository<SettingValue, Integer>{

	SettingValue findAllByName(String name);

}
