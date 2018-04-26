package com.mndeveci.spring.boot.rest.repository;

import com.mndeveci.spring.boot.rest.model.EntityWithRevision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

/**
 * @author： lxh
 * @description：
 * @created: 2018/4/26 10:38
 * @modified by:
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

    List<EntityWithRevision<T>> listCityRevisions(ID id);
}
