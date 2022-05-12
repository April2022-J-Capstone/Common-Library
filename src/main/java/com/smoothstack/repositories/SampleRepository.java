package com.smoothstack.repositories;

import com.smoothstack.models.SampleModel;
import org.springframework.data.repository.CrudRepository;

public interface SampleRepository extends CrudRepository<SampleModel, Integer> {
    SampleModel findById(int id);
}
