package com.cake.repository;

import com.cake.entity.PermissaoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends CrudRepository<PermissaoEntity, Integer> {

}
