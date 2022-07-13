package social.petting.pettingchannelservice.channel.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import social.petting.pettingchannelservice.channel.domain.Member;

public interface MemberRepositry extends JpaRepository<Member, Long> {

    Member findByUsername(String username);


}
