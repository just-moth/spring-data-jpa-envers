package com.mndeveci.spring.boot.rest.repository;

import com.mndeveci.spring.boot.rest.model.City;
import com.mndeveci.spring.boot.rest.model.EntityWithRevision;
import com.mndeveci.spring.boot.rest.model.RevisionsEntity;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author： lxh
 * @description：
 * @created: 2018/4/26 10:39
 * @modified by:
 */
public class ExtBaseRepository<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID>{

    private EntityManager em;
    private Class<T> domainClass;

    public ExtBaseRepository(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.em = entityManager;
        this.domainClass = entityInformation.getJavaType();
    }


    @Override
    public List<EntityWithRevision<T>> listCityRevisions(ID id) {
        AuditReader auditReader = AuditReaderFactory.get(em);

        List<Number> revisions = auditReader.getRevisions(domainClass, id);

        List<EntityWithRevision<T>> cityRevisions = new ArrayList<>();
        for (Number revision : revisions) {
            T cityRevision = auditReader.find(domainClass, id, revision);
            Date revisionDate = auditReader.getRevisionDate(revision);

            cityRevisions.add(
                    new EntityWithRevision(
                            new RevisionsEntity(revision.longValue(), revisionDate), cityRevision));
        }

        return cityRevisions;
    }
}
