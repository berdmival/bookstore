package by.berdmival.bookstore.service.account;

import by.berdmival.bookstore.entity.account.Account;
import by.berdmival.bookstore.repository.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
@Repository
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account add(Account account) {
        return accountRepository.save(account);
    }
}
