package com.np.mongo.entity;

import java.math.BigInteger;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("comments")
public class Comments {

	@Id
	private BigInteger id;
	private String name;
	private String comment;
	private Date date;

}
