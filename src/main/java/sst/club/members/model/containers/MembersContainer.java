package sst.club.members.model.containers;

import lombok.Getter;
import sst.club.members.model.Member;

import java.util.*;

public class MembersContainer {
    private final static MembersContainer instance = new MembersContainer();

    private MembersContainer() {
    }

    public static MembersContainer me() {
        return instance;
    }

    @Getter
    private final Set<Member> members = new TreeSet<>();

    public void addMembers(List<Member> members) {
        this.members.addAll(members);
    }

    public void addMember(Member member) {
        this.members.add(member);
    }

    public boolean memberExists(Member member) {
        return this.members.contains(member);
    }

    public List<Member> members() {
        final ArrayList<Member> result = new ArrayList<>();
        result.addAll(getMembers());
        return result;
    }
}
