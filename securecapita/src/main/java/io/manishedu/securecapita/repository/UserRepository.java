package io.manishedu.securecapita.repository;

import io.manishedu.securecapita.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Collections;

public interface UserRepository<T extends User> {
    T create(T data);

    Collection<T> list(int page, int pageSize);

    T get(long Id);

    T update(T data);

    boolean delete(long Id);
}
//public interface UserRepository extends JpaRepository<User,String> {
//
//
//

