package com.mas.tytarenko.finalproject.repositories;

import com.mas.tytarenko.finalproject.models.Setting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettingRepository extends CrudRepository<Setting, Long> {}
