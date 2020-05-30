package com.rpg.web.user.controller;

import org.springframework.data.domain.Page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageFilter<F> {
	
	private F filter;
	private Page page;
	
	public F getFilter() {
		return filter;
	}
	public void setFilter(F filter) {
		this.filter = filter;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
	
	
}
