package com.ms.userpg.Repository;

import com.ms.userpg.Entity.Role;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.jpa.repository.JpaRepository;
@ReadingConverter
public interface RoleRepository extends JpaRepository<Role,Integer> {
}
