package com.jdc.online.balances.model;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

public class BaseRepositoryImpl<T,ID> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {
	
	private EntityManager em;

	public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.em = entityManager;
		
	}

	@Override
	public <R> List<R> search(Function<CriteriaBuilder, CriteriaQuery<R>> queryFunc) {
		var cq = queryFunc.apply(em.getCriteriaBuilder());
		var jpaQuery = em.createQuery(cq);
		return jpaQuery.getResultList();
	}

	@Override
	public <R> PageResult<R> search(Function<CriteriaBuilder, CriteriaQuery<R>> queryFunc,
			Function<CriteriaBuilder, CriteriaQuery<Long>> countFunc, int page, int size) {
		
		var count = count(countFunc);
		
		var cq = queryFunc.apply(em.getCriteriaBuilder());
		var jpaQuery = em.createQuery(cq);
		
		jpaQuery.setMaxResults(size);
		jpaQuery.setFirstResult(page * size);
		
		var list = jpaQuery.getResultList();
		
		PageResult.Builder<R> builder = PageResult.builder();
		
		
		return builder
				.contents(list)
				.size(size)
				.page(page)
				.count(count)
				.build();
	}

	@Override
	public <R> Optional<R> searchOne(Function<CriteriaBuilder, CriteriaQuery<R>> queryFunc) {
		var cq = queryFunc.apply(em.getCriteriaBuilder());
		var jpaQuery = em.createQuery(cq);
		return jpaQuery.getResultList().stream().findAny();
	}

	@Override
	public Long count(Function<CriteriaBuilder, CriteriaQuery<Long>> queryFunc) {
		var cq = queryFunc.apply(em.getCriteriaBuilder());
		var jpaQuery = em.createQuery(cq);
		return jpaQuery.getSingleResult();
	}
}
