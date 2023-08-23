package uz.ilmnajot.chatapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.ilmnajot.chatapp.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
