package com.jdc.online.balances.model;

import java.util.ArrayList;
import java.util.List;

public record PageResult<T>(
		List<T> contents,
		long count,
		int size,
		int page
		) {
	
	public int getTotalPages() {
		
		Long totalpage = count / size;
		
		if(count % size > 0) {
			totalpage += 1;
		}
		
		return totalpage.intValue();
		
	}
	
	public List<Integer> getPageLinks(){
		
		var totalPages = getTotalPages();
		var links = new ArrayList<Integer>();
		
		if(totalPages > 0) {
			
			links.add(page);
			
			while(links.getFirst() > 0 && links.size() < 3) {
				links.addFirst(links.getFirst() - 1);
			}
			
			while(links.getLast() < totalPages && links.size() < 5) {
				links.addLast(links.getLast() + 1);
			}
			
			while(links.getFirst() > 0 && links.size() < 5) {
				links.addFirst(links.getFirst() - 1);
			}
			
		}
		
		return links;
	}
	
	public static <T> Builder<T> builder() {
		return new Builder<>();
	}
	
	public static class Builder<T> {
		private List<T> contents;
		private long count;
		private int size;
		private int page;

		public Builder<T> contents(List<T> contents) {
			this.contents = contents;
			return this;
		}

		public Builder<T> count(long count) {
			this.count = count;
			return this;
		}

		public Builder<T> size(int size) {
			this.size = size;
			return this;
		}

		public Builder<T> page(int page) {
			this.page = page;
			return this;
		}

		public PageResult<T> build() {
			return new PageResult<>(contents, count, size, page);
		}
	}

}
