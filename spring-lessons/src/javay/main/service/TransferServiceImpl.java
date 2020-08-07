package javay.main.service;


import javay.main.model.Amount;
import javay.main.repository.AccountRepository;
import javay.main.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TransferServiceImpl implements TransferService {
    private final AccountRepository jdbcAccountRepo;
    private final TransferRepository jdbcTransferRepo;

    public TransferServiceImpl(AccountRepository jdbcAccountRepo,
                               TransferRepository jdbcTransferRepo) {
        this.jdbcAccountRepo = jdbcAccountRepo;
        this.jdbcTransferRepo = jdbcTransferRepo;
    }

    @Override
    public void transfer(String accountA, String accountB, Long amount) {
        System.out.println(amount + " Денежная сумма была переведена " +
                "с " + accountA + " на " + accountB);
    }

    @Override
    public void transferAmount(Long a, Long b, Amount amount) {
        System.out.println("transferAmount");
    }

    @Override
    public void createCache() {
        System.out.println("createCache");
    }
}
