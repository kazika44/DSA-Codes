package io.manishedu.securecapita.repository;

import io.manishedu.securecapita.model.Role;

import java.util.Collection;

public interface RoleRepository<T extends Role>{
    T create(T data);

    Collection<T> list(int page, int pageSize);

    T get(long Id);

    T update(T data);

    boolean delete(long Id);

    void addRoleToUser(Long userId, String roleName);
    Role getRoleByUserId(Long userId);
    Role getRoleByUserEmail(String userEmail);
    void updateUserRole(Long userId, String roleName);

}
