package by.berdmival.bookstore.repository.account;

import by.berdmival.bookstore.entity.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
