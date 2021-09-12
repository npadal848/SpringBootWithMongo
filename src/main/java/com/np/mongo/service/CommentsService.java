package com.np.mongo.service;

import java.math.BigInteger;
import java.util.List;

import com.np.mongo.entity.Comments;

public interface CommentsService {

	List<Comments> getComments();
	Comments getCommentById(BigInteger id);
	void insertComment(Comments comments);
	Comments updateComment(Comments comments);
	void deleteComment(BigInteger id);
}
