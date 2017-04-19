package com.eldrix.openconsent.model.auto;

import java.util.List;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.eldrix.openconsent.model.Authority;
import com.eldrix.openconsent.model.ConsentForm;
import com.eldrix.openconsent.model.Episode;

/**
 * Class _Project was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Project extends CayenneDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String ID_PK_COLUMN = "id";

    public static final Property<String> DESCRIPTION = Property.create("description", String.class);
    public static final Property<Boolean> MESSAGING = Property.create("messaging", Boolean.class);
    public static final Property<String> PUBLIC_KEY = Property.create("publicKey", String.class);
    public static final Property<String> TITLE = Property.create("title", String.class);
    public static final Property<String> UUID = Property.create("uuid", String.class);
    public static final Property<Authority> AUTHORITY = Property.create("authority", Authority.class);
    public static final Property<List<ConsentForm>> CONSENT_FORMS = Property.create("consentForms", List.class);
    public static final Property<List<Episode>> EPISODES = Property.create("episodes", List.class);

    public void setDescription(String description) {
        writeProperty("description", description);
    }
    public String getDescription() {
        return (String)readProperty("description");
    }

    public void setMessaging(boolean messaging) {
        writeProperty("messaging", messaging);
    }
	public boolean isMessaging() {
        Boolean value = (Boolean)readProperty("messaging");
        return (value != null) ? value.booleanValue() : false;
    }

    public void setPublicKey(String publicKey) {
        writeProperty("publicKey", publicKey);
    }
    public String getPublicKey() {
        return (String)readProperty("publicKey");
    }

    public void setTitle(String title) {
        writeProperty("title", title);
    }
    public String getTitle() {
        return (String)readProperty("title");
    }

    public void setUuid(String uuid) {
        writeProperty("uuid", uuid);
    }
    public String getUuid() {
        return (String)readProperty("uuid");
    }

    public void setAuthority(Authority authority) {
        setToOneTarget("authority", authority, true);
    }

    public Authority getAuthority() {
        return (Authority)readProperty("authority");
    }


    public void addToConsentForms(ConsentForm obj) {
        addToManyTarget("consentForms", obj, true);
    }
    public void removeFromConsentForms(ConsentForm obj) {
        removeToManyTarget("consentForms", obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<ConsentForm> getConsentForms() {
        return (List<ConsentForm>)readProperty("consentForms");
    }


    public void addToEpisodes(Episode obj) {
        addToManyTarget("episodes", obj, true);
    }
    public void removeFromEpisodes(Episode obj) {
        removeToManyTarget("episodes", obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<Episode> getEpisodes() {
        return (List<Episode>)readProperty("episodes");
    }


    protected abstract void onPostAdd();

    protected abstract void onPostLoad();

}
