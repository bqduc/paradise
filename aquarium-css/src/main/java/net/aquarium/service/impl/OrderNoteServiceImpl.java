package net.aquarium.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.aquarium.entity.trade.OrderNote;
import net.aquarium.framework.repository.BaseRepository;
import net.aquarium.framework.service.GenericServiceImpl;
import net.aquarium.repository.trade.OrderNoteRepository;
import net.aquarium.service.trade.OrderNoteService;

@Service
public class OrderNoteServiceImpl extends GenericServiceImpl<OrderNote, Long> implements OrderNoteService{
	private static final long serialVersionUID = -644103846803081016L;
	
	@Inject 
	private OrderNoteRepository repository;
	
	protected BaseRepository<OrderNote, Long> getRepository() {
		return this.repository;
	}
}
