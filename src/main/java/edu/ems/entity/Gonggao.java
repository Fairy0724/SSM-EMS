package edu.ems.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

//229970615 李松蔓
@TableName("gonggao")
public class Gonggao extends Model<Gonggao> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@TableId
	private Integer id;
	private String title;
	private String content;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Gonggao [id=" + id + ", title=" + title + ", content=" + content + "]";
	}
	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	
}
