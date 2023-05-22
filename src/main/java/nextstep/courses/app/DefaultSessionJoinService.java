package nextstep.courses.app;

import nextstep.courses.domain.Session;
import nextstep.courses.domain.SessionRepository;
import nextstep.users.domain.NsUser;
import nextstep.users.domain.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultSessionJoinService implements SessionJoinService {
    private final SessionRepository sessionRepository;
    private final UserRepository userRepository;

    public DefaultSessionJoinService(SessionRepository sessionRepository, UserRepository userRepository) {
        this.sessionRepository = sessionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void register(long sessionId, List<String> userIds) {
        Session session = sessionRepository.findById(sessionId);
        List<NsUser> nsUsers = userRepository.findAllByUserIds(userIds);

        for (NsUser nsUser : nsUsers) {
            session.register(nsUser);
        }

        sessionRepository.saveSessionJoin(session);
    }
}
