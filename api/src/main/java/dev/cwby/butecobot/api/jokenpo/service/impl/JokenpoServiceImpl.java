
package dev.cwby.butecobot.api.jokenpo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.cwby.butecobot.api.jokenpo.domain.Jokenpo;
import dev.cwby.butecobot.api.jokenpo.repository.JokenpoRepository;
import dev.cwby.butecobot.api.jokenpo.service.IJokenpoService;

/**
 * JokenpoServiceImpl
 */
@Service
public class JokenpoServiceImpl implements IJokenpoService {

	private final JokenpoRepository repository;

	public JokenpoServiceImpl(JokenpoRepository repository) {
		this.repository = repository;
	}

	@Override
	public Jokenpo save(Jokenpo jokenpo) {
		return repository.save(jokenpo);
	}

	@Override
	public Optional<Jokenpo> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<Jokenpo> findAll() {
		return repository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
