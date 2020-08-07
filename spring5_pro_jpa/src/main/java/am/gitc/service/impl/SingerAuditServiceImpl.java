package am.gitc.service.impl;

import am.gitc.entities.SingerAudit;
import am.gitc.repository.SingerAuditRepository;
import am.gitc.service.SingerAuditService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("singerAuditService")
@Transactional
public class SingerAuditServiceImpl implements SingerAuditService {

    private final SingerAuditRepository repository;

    public SingerAuditServiceImpl(SingerAuditRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<SingerAudit> findAll() {
        return repository.findAll();
    }

    @Override
    public SingerAudit findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public SingerAudit save(SingerAudit singer) {
        return repository.save(singer);
    }
}
