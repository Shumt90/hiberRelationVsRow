package com.example.hiberrelationvsrow;

import com.example.hiberrelationvsrow.entity.Entity1;
import com.example.hiberrelationvsrow.repository.Entity1Repo;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {

  private final TransactionService transactionService;


  @PostConstruct
  private void init(){

    var time=System.currentTimeMillis();

    transactionService.saveAll();

    System.out.println(System.currentTimeMillis()-time);
    time=System.currentTimeMillis();

    transactionService.persist();

    System.out.println(System.currentTimeMillis()-time);


  }

}
