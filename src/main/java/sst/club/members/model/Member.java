package sst.club.members.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.Month;

@Data
public class Member implements Comparable<Member> {
    private String firstname;
    private String name;
    private PostalAddress address;
    private String email;

    private boolean instructor;
    private boolean administrator;

    private LocalDate affiliation;

    @Override
    public String toString() {
        return String.join(" ", firstname, name);
    }

    public boolean inOrderOfAffliation() {
        boolean result = isAdministrator() || isInstructor();
        if (!result && affiliation != null) {
            LocalDate now = LocalDate.now();
            final int nowYear = now.getYear();
            final int affiliationYear = affiliation.getYear();
            result = nowYear == affiliationYear;
            if (!result && affiliationYear == nowYear - 1) {
                result = LocalDate.of(affiliationYear, Month.OCTOBER, 1).isBefore(affiliation);
            }
        }
        return result;
    }

    @Override
    public int compareTo(Member member) {
        int result = this.name.compareTo(member.name);
        if (result == 0) {
            result = this.firstname.compareTo(member.firstname);
        }
        return result;
    }
}
