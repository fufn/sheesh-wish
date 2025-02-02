package kz.wishify.repository;

import kz.wishify.entity.WishEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface WishRepository extends JpaRepository<WishEntity, UUID> {

    List<WishEntity> findAllByUserName(String userName);
}
