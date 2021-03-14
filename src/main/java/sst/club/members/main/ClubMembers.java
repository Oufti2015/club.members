package sst.club.members.main;

import lombok.extern.log4j.Log4j2;
import sst.club.members.file.JsonInterface;
import sst.club.members.model.Member;
import sst.club.members.model.PostalAddress;
import sst.club.members.model.containers.MembersContainer;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class ClubMembers {

    public static void main(String[] args) {
        log.info("Welcome in Club Members !");
        testMembers();
        try {
            JsonInterface jsonInterface = new JsonInterface();
            jsonInterface.importData("members.json");
            List<Member> list1 = new ArrayList<>();
            list1.addAll(jsonInterface.getCollection());

            //  jsonInterface.setCollection(MembersContainer.me().members());
            jsonInterface.exportData("members2.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testMembers() {
        Member member = new Member();
        member.setFirstname("Stéphane");
        member.setName("Stiennnon");
        PostalAddress address = new PostalAddress();
        address.setAddress("3 rue Reifenberg");
        address.setPostCode("6792");
        address.setCityName("Aix-sur-Cloie");
        address.setCountry("Belgique");
        member.setAddress(address);
        member.setEmail("stephane.stiennon@gmail.com");
        member.setAffiliation(LocalDate.now());
        member.setInstructor(true);
        member.setAdministrator(true);

        MembersContainer.me().addMember(member);
        log.info(String.join(" - ", member.toString(), member.getAddress().toString()));

        member = new Member();
        member.setFirstname("Marine");
        member.setName("Tonglet");
        address = new PostalAddress();
        address.setAddress("1 Perlé");
        address.setPostCode("6860");
        address.setCityName("Martelange");
        address.setCountry("Belgique");
        member.setAddress(address);
        member.setEmail("mtonglet@gmail.com");
        member.setAffiliation(LocalDate.now());
        member.setInstructor(true);
        member.setAdministrator(true);

        MembersContainer.me().addMember(member);
        log.info(String.join(" - ", member.toString(), member.getAddress().toString()));

        try {
            JsonInterface jsonInterface = new JsonInterface();
            jsonInterface.setCollection(MembersContainer.me().members());
            jsonInterface.exportData("members.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
