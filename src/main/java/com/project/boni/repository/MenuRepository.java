package com.project.boni.repository;

import com.project.boni.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import static org.hibernate.hql.internal.antlr.HqlTokenTypes.FROM;
import static org.hibernate.loader.Loader.SELECT;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
}
