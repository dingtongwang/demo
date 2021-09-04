package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.CreateUserRequest;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

/**
 * @program: demo
 * @description:
 * @author: tongwang.ding
 * @date: 2021-08-25 20:32
 **/
@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  private EntityManager entityManager;

  public User createUser(CreateUserRequest request) {
    User user = User.builder()
        .firstName(request.getFirstName())
        .lastName(request.getLastName())
        .phoneNumber(request.getPhoneNumber())
        .email(request.getEmail())
        .roles(request.getRoles())
        .build();
    return userRepository.save(user);
  }

  public List<User> getUsers() {
    return userRepository.findAll();
  }

  public Page<User> getUsers(Integer id, Integer pageNum, Integer pageSize) {
    Sort sort = Sort.by(Sort.Direction.DESC, "id");
    Pageable pageable = PageRequest.of(pageNum, pageSize, sort);

    Specification<User> specification = new Specification<>() {
      @Override
      public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        Path<Integer> idPath = root.get("id");

        query.where(cb.gt(idPath, id));
        query.orderBy(cb.asc(idPath));

        return query.getRestriction();
      }
    };
    return userRepository.findAll(specification, pageable);
  }

  private Specification createSpecification(Integer specialId, String specialEmail) {
    Specification<User> specification = new Specification<>() {
      @Override
      public Predicate toPredicate(Root<User> root,
          CriteriaQuery<?> query, CriteriaBuilder cb) {
        Path id = root.get("id");
        Predicate predicateId = cb.gt(id, specialId);

        Path email = root.get("email");
        Predicate predicateEmail = cb.equal(email, specialEmail);

        return cb.and(predicateId, predicateEmail);
      }
    };

    return specification;
  }

  private void getUserList(String specialEmail) {
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<User> query = cb.createQuery(User.class);

    Root<User> root = query.from(User.class);

    Path<User> email = root.get("email");
    Predicate predicateEmail = cb.equal(email, specialEmail);
    query.where(predicateEmail);

    TypedQuery<User> q = entityManager.createQuery(query);
    List<User> result = q.getResultList();
    for (User user : result) {
      //打印查询结果
      System.out.println(user.toString());
    }
  }
}
