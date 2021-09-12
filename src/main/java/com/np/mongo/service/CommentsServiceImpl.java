package com.np.mongo.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.np.mongo.entity.Comments;
import com.np.mongo.repo.CommentsRepo;

@Service
public class CommentsServiceImpl implements CommentsService {

	@Autowired
	private CommentsRepo commentsRepo;

	@Override
	public List<Comments> getComments() {
		return commentsRepo.findAll();
	}

	@Override
	public Comments getCommentById(BigInteger id) {
		return commentsRepo.findById(id).get();
	}

	@Override
	public void insertComment(Comments comments) {
		comments.setDate(new Date());
		commentsRepo.save(comments);
	}

	@Override
	public Comments updateComment(Comments comments) {
		Optional<Comments> optionalComment = commentsRepo.findById(comments.getId());
		if (optionalComment.isPresent()) {
			Comments oldComment = optionalComment.get();
			oldComment.setName(comments.getName());
			oldComment.setComment(comments.getComment());
			
			return commentsRepo.save(oldComment);
		} else {
			throw new RuntimeException("Id not Found");
		}
	}

	@Override
	public void deleteComment(BigInteger id) {
		commentsRepo.deleteById(id);
	}
}
