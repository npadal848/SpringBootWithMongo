package com.np.mongo.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.np.mongo.entity.Comments;
import com.np.mongo.service.CommentsService;

@RestController
@RequestMapping("/comment")
public class CommentsController {

	@Autowired
	private CommentsService commentsService;

	@GetMapping("/comments")
	public ResponseEntity<List<Comments>> getAllComments() {
		return ResponseEntity.ok(commentsService.getComments());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Comments> getCommentById(@PathVariable BigInteger id) {
		return new ResponseEntity<>(commentsService.getCommentById(id), HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<String> saveComment(@RequestBody Comments comments) {
		commentsService.insertComment(comments);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Comments> updateComment(@RequestBody Comments comments) {
		return new ResponseEntity<>(commentsService.updateComment(comments), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteComment(@PathVariable BigInteger id) {
		commentsService.deleteComment(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
