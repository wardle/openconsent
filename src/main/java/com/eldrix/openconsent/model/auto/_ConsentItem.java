package com.eldrix.openconsent.model.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.eldrix.openconsent.model.ConsentForm;
import com.eldrix.openconsent.model.ConsentType;

/**
 * Class _ConsentItem was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _ConsentItem extends CayenneDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String ID_PK_COLUMN = "id";

    public static final Property<String> BEHAVIOUR = Property.create("behaviour", String.class);
    public static final Property<String> DESCRIPTION = Property.create("description", String.class);
    public static final Property<Integer> ORDERING = Property.create("ordering", Integer.class);
    public static final Property<String> TITLE = Property.create("title", String.class);
    public static final Property<ConsentType> TYPE = Property.create("type", ConsentType.class);
    public static final Property<ConsentForm> CONSENT_FORM = Property.create("consentForm", ConsentForm.class);

    public void setBehaviour(String behaviour) {
        writeProperty("behaviour", behaviour);
    }
    public String getBehaviour() {
        return (String)readProperty("behaviour");
    }

    public void setDescription(String description) {
        writeProperty("description", description);
    }
    public String getDescription() {
        return (String)readProperty("description");
    }

    public void setOrdering(int ordering) {
        writeProperty("ordering", ordering);
    }
    public int getOrdering() {
        Object value = readProperty("ordering");
        return (value != null) ? (Integer) value : 0;
    }

    public void setTitle(String title) {
        writeProperty("title", title);
    }
    public String getTitle() {
        return (String)readProperty("title");
    }

    public void setType(ConsentType type) {
        writeProperty("type", type);
    }
    public ConsentType getType() {
        return (ConsentType)readProperty("type");
    }

    public void setConsentForm(ConsentForm consentForm) {
        setToOneTarget("consentForm", consentForm, true);
    }

    public ConsentForm getConsentForm() {
        return (ConsentForm)readProperty("consentForm");
    }


}