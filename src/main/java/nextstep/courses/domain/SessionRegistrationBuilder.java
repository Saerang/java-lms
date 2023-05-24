package nextstep.courses.domain;

public final class SessionRegistrationBuilder {
    private SessionRecruitStatus sessionRecruitStatus;
    private int maxUserCount;

    private SessionRegistrationBuilder() {
    }

    public static SessionRegistrationBuilder aSessionRegistration() {
        return new SessionRegistrationBuilder();
    }

    public SessionRegistrationBuilder withSessionRecruitStatus(SessionRecruitStatus sessionRecruitStatus) {
        this.sessionRecruitStatus = sessionRecruitStatus;
        return this;
    }

    public SessionRegistrationBuilder withMaxUserCount(int maxUserCount) {
        this.maxUserCount = maxUserCount;
        return this;
    }

    public SessionRegistration build() {
        return new SessionRegistration(sessionRecruitStatus, maxUserCount);
    }
}
