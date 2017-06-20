package com.shonlee.repostory;

import com.shonlee.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by ShonLee on 2017/6/7.
 */
public interface GirlRepostoryJpa extends JpaRepository<Girl,Integer> {
    List<Girl> findByAge(Integer age);
}
