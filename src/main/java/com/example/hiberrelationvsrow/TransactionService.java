package com.example.hiberrelationvsrow;

import static java.util.stream.Collectors.*;

import com.example.hiberrelationvsrow.entity.Entity1;
import com.example.hiberrelationvsrow.repository.Entity1Repo;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TransactionService {

  private final AtomicInteger inc=new AtomicInteger();
  private final Entity1Repo entity1Repo;
  private final EntityManager entityManager;

  @Transactional
  public void saveAll(){

    var dtos = Stream.generate(inc::incrementAndGet)
        .limit(100_000)
        .map(Entity1::new)
        .collect(toCollection(LinkedList::new));


    entity1Repo.saveAll(dtos);

  }

  @Transactional
  public void persist(){
    var dtos = Stream.generate(inc::incrementAndGet)
        .limit(100_000)
        .map(Entity1::new)
        .collect(toCollection(LinkedList::new));


    dtos.forEach(entityManager::persist);
  }
}
