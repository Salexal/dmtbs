package cn.wzvtc.dmtbs.repository;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class PersistRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> {

    private final EntityManager entityManager;


    //nothing to do...
    public PersistRepositoryImpl(JpaEntityInformation entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }


    @Transactional
    public <S extends T> S persist(S entity) {
        entityManager.persist(entity);
        return entity;
    }
}
