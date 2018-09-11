package com.sheng.spring.mastermind.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IMastermindGameRepository  extends JpaRepository<MastermindGame, Long>{

}
