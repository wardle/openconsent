package com.eldrix.openconsent.model;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.security.KeyPair;
import java.time.LocalDate;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.validation.ValidationResult;
import org.apache.shiro.codec.Base64;
import org.junit.Test;

import com.eldrix.openconsent.core.RsaService;

public class TestProjects extends _ModelTest {

	@Test
	public void testProjects() {
		ObjectContext context = getRuntime().newContext();
		Authority authority = context.newObject(Authority.class);
		Project p1 = authority.createProject("P1","P1");
		Project p2 = authority.createProject("P2","P2");
		SecureProject sp1 = p1.getSecureProject().get();
		SecureProject sp2 = p2.getSecureProject().get();
		sp1.setTitle("Test project");
		sp1.setDescription("Simple test project");
		String pseudonym1 = sp1.calculatePseudonym("1111111111", LocalDate.of(1975, 01, 01));
		String pseudonym2 = sp2.calculatePseudonym("1111111111", LocalDate.of(1975, 01, 01));
		assertEquals(64, pseudonym1.length());
		assertNotEquals(pseudonym1, pseudonym2); 
	}
	
	@Test
	public void testProjectMessaging() {
		ObjectContext context = getRuntime().newContext();
		Authority authority = context.newObject(Authority.class);
		authority.setName("NHS");
		authority.setLogic(AuthorityLogic.UK_NHS);
		Project p1 = authority.createProject("TEST", "Test project");
		ValidationResult validation = new ValidationResult();
		p1.validateForSave(validation);
		assertFalse(validation.hasFailures());
		p1.setMessaging(true);
		p1.validateForSave(validation);
		assertTrue(validation.hasFailures());
		validation.clear();
		
		// now create public key; we can now switch on messaging support.
		KeyPair keyPair = new RsaService().generateKeyPair(1024);
		p1.setPublicKey(Base64.encodeToString(keyPair.getPublic().getEncoded()));
		p1.validateForSave(validation);
		assertFalse(validation.hasFailures());
	}
}
