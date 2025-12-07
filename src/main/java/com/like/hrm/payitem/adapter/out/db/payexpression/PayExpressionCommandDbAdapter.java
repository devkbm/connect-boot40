package com.like.hrm.payitem.adapter.out.db.payexpression;

import java.util.Optional;
import org.springframework.stereotype.Repository;

import com.like.hrm.payitem.adapter.out.db.payexpression.data.PayExpressionJpaRepository;
import com.like.hrm.payitem.application.port.out.PayExpressionCommandDbPort;
import com.like.hrm.payitem.domain.payexpression.PayExpression;

@Repository
public class PayExpressionCommandDbAdapter implements PayExpressionCommandDbPort {

	PayExpressionJpaRepository repository;
	
	PayExpressionCommandDbAdapter(PayExpressionJpaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Optional<PayExpression> select(Long id) {
		return this.repository.findById(id);
	}

	@Override
	public void save(PayExpression entity) {
		this.repository.save(entity);
	}

	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);
	}

}
