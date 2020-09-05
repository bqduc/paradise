package net.ecoparadise.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.ecoparadise.entity.OrderNote;
import net.ecoparadise.framework.repository.BaseRepository;
import net.ecoparadise.framework.service.GenericServiceImpl;
import net.ecoparadise.repository.trade.OrderNoteRepository;
import net.ecoparadise.service.trade.OrderNoteService;

@Service
public class OrderNoteServiceImpl extends GenericServiceImpl<OrderNote, Long> implements OrderNoteService{
	private static final long serialVersionUID = -644103846803081016L;
	
	@Inject 
	private OrderNoteRepository repository;
	
	protected BaseRepository<OrderNote, Long> getRepository() {
		return this.repository;
	}
}
