package com.np.mongo.repo;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.np.mongo.entity.Comments;

@Repository
public interface CommentsRepo extends MongoRepository<Comments, BigInteger> {

}
