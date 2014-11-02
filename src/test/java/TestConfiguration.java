import org.serge009.fishtrading.core.dao.ContactDao;
import org.serge009.fishtrading.core.entity.Contact;
import org.serge009.fishtrading.core.entity.ContactTelDetail;
import org.serge009.fishtrading.core.entity.Hobby;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by SERGE on 02.11.2014.
 */
public class TestConfiguration {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/spring/app-context.xml");
        ContactDao contactService = ctx.getBean(
                "jpaContactDao", ContactDao.class);
        List<Contact> contacts = contactService.findAllWithDetail();
        listContactsWithDetail(contacts);
    }

    private static void listContactsWithDetail(List<Contact> contacts) {
        System.out.println("");
        System.out.println("Listing contacts with details:");
        for (Contact contact : contacts) {
            System.out.println(contact);
            if (contact.getContactTelDetails() != null) {
                for (ContactTelDetail contactTelDetail :
                        contact.getContactTelDetails()) {
                    System.out.println(contactTelDetail);
                }
            }
            if (contact.getHobbies() != null) {
                for (Hobby hobby : contact.getHobbies()) {
                    System.out.println(hobby);
                }
            }
            System.out.println();
        }
    }

    private static void listContacts(List<Contact> contacts) {
        System.out.println("");
        System.out.println("Listing contacts without details:");
        for (Contact contact : contacts) {
            System.out.println(contact);
            System.out.println();
        }
    }
}