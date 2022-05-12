package com.smoothstack.common.repositories;

import com.smoothstack.common.models.SampleModel;
import org.springframework.data.repository.CrudRepository;

public interface SampleRepository extends CrudRepository<SampleModel, Integer> {
    SampleModel findById(int id);
}
