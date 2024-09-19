package com.sboard.repository;

import com.sboard.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    public boolean existsByUid(String uid);
    public User findByName(String name);
    public User findByEmail(String email);
    public User findByNick(String nick);
    public User findByHp(String hp);
}
