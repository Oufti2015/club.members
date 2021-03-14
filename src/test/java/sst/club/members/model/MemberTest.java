package sst.club.members.model;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;


public class MemberTest {

    @Test
    public void testMember() {
        Member member = new Member();
        member.setFirstname("Stéphane");
        member.setName("Stiennon");
        PostalAddress address = new PostalAddress();
        address.setAddress("3 rue Reifenberg");
        address.setPostCode("6792");
        address.setCityName("Aix-sur-Cloie");
        address.setCountry("Belgique");
        member.setAddress(address);
        member.setEmail("stephane.stiennon@gmail.com");

        member.setInstructor(false);
        member.setAdministrator(false);

        System.out.println(String.join(" - ", member.toString(), member.getAddress().toString()));

        Assert.assertEquals("Stéphane Stiennon", member.toString());
        Assert.assertFalse(member.inOrderOfAffliation());

        LocalDate affiliation = LocalDate.now();
        member.setAffiliation(affiliation);
        Assert.assertTrue(member.inOrderOfAffliation());

        affiliation = LocalDate.of(LocalDate.now().getYear(), Month.JANUARY, 1);
        member.setAffiliation(affiliation);
        Assert.assertTrue(member.inOrderOfAffliation());

        affiliation = LocalDate.of(LocalDate.now().getYear()-1, Month.DECEMBER, 1);
        member.setAffiliation(affiliation);
        Assert.assertTrue(member.inOrderOfAffliation());

        affiliation = LocalDate.of(LocalDate.now().getYear()-1, Month.MARCH, 1);
        member.setAffiliation(affiliation);
        Assert.assertFalse(member.inOrderOfAffliation());

        member.setAffiliation(null);
        member.setInstructor(true);
        member.setAdministrator(false);
        Assert.assertTrue(member.inOrderOfAffliation());
        member.setInstructor(false);
        member.setAdministrator(true);
        Assert.assertTrue(member.inOrderOfAffliation());
        member.setInstructor(true);
        member.setAdministrator(true);
        Assert.assertTrue(member.inOrderOfAffliation());
    }
}
