
package com.ealanta.generated.cli;

import java.util.HashMap;
import java.util.Map;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "positionID",
    "changeDeleteIndicator",
    "positionNumber",
    "positionTitle",
    "deaneryNumber",
    "managingOffice",
    "odsCode",
    "hostLeadIndicator",
    "employingOrgVPDCode",
    "esrOrganisation",
    "esrLocation"
})
public class PORSchema  {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("positionID")
    @Size(min = 1, max = 15)
    @NotNull
    private Long positionID;
    @JsonProperty("changeDeleteIndicator")
    private PORSchema.ChangeDeleteIndicator changeDeleteIndicator;
    @JsonProperty("positionNumber")
    @Size(max = 10)
    private Long positionNumber;
    @JsonProperty("positionTitle")
    @Size(max = 60)
    private String positionTitle;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("deaneryNumber")
    @Size(min = 1, max = 30)
    @NotNull
    private String deaneryNumber;
    @JsonProperty("managingOffice")
    @Size(max = 10)
    private String managingOffice;
    @JsonProperty("odsCode")
    @Size(max = 30)
    private String odsCode;
    @JsonProperty("hostLeadIndicator")
    private PORSchema.HostLeadIndicator hostLeadIndicator;
    @JsonProperty("employingOrgVPDCode")
    @Size(max = 4)
    private Long employingOrgVPDCode;
    @JsonProperty("esrOrganisation")
    @Size(max = 240)
    private String esrOrganisation;
    @JsonProperty("esrLocation")
    @Size(max = 240)
    private String esrLocation;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("positionID")
    public Long getPositionID() {
        return positionID;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("positionID")
    public void setPositionID(Long positionID) {
        this.positionID = positionID;
    }

    @JsonProperty("changeDeleteIndicator")
    public PORSchema.ChangeDeleteIndicator getChangeDeleteIndicator() {
        return changeDeleteIndicator;
    }

    @JsonProperty("changeDeleteIndicator")
    public void setChangeDeleteIndicator(PORSchema.ChangeDeleteIndicator changeDeleteIndicator) {
        this.changeDeleteIndicator = changeDeleteIndicator;
    }

    @JsonProperty("positionNumber")
    public Long getPositionNumber() {
        return positionNumber;
    }

    @JsonProperty("positionNumber")
    public void setPositionNumber(Long positionNumber) {
        this.positionNumber = positionNumber;
    }

    @JsonProperty("positionTitle")
    public String getPositionTitle() {
        return positionTitle;
    }

    @JsonProperty("positionTitle")
    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("deaneryNumber")
    public String getDeaneryNumber() {
        return deaneryNumber;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("deaneryNumber")
    public void setDeaneryNumber(String deaneryNumber) {
        this.deaneryNumber = deaneryNumber;
    }

    @JsonProperty("managingOffice")
    public String getManagingOffice() {
        return managingOffice;
    }

    @JsonProperty("managingOffice")
    public void setManagingOffice(String managingOffice) {
        this.managingOffice = managingOffice;
    }

    @JsonProperty("odsCode")
    public String getOdsCode() {
        return odsCode;
    }

    @JsonProperty("odsCode")
    public void setOdsCode(String odsCode) {
        this.odsCode = odsCode;
    }

    @JsonProperty("hostLeadIndicator")
    public PORSchema.HostLeadIndicator getHostLeadIndicator() {
        return hostLeadIndicator;
    }

    @JsonProperty("hostLeadIndicator")
    public void setHostLeadIndicator(PORSchema.HostLeadIndicator hostLeadIndicator) {
        this.hostLeadIndicator = hostLeadIndicator;
    }

    @JsonProperty("employingOrgVPDCode")
    public Long getEmployingOrgVPDCode() {
        return employingOrgVPDCode;
    }

    @JsonProperty("employingOrgVPDCode")
    public void setEmployingOrgVPDCode(Long employingOrgVPDCode) {
        this.employingOrgVPDCode = employingOrgVPDCode;
    }

    @JsonProperty("esrOrganisation")
    public String getEsrOrganisation() {
        return esrOrganisation;
    }

    @JsonProperty("esrOrganisation")
    public void setEsrOrganisation(String esrOrganisation) {
        this.esrOrganisation = esrOrganisation;
    }

    @JsonProperty("esrLocation")
    public String getEsrLocation() {
        return esrLocation;
    }

    @JsonProperty("esrLocation")
    public void setEsrLocation(String esrLocation) {
        this.esrLocation = esrLocation;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PORSchema.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("positionID");
        sb.append('=');
        sb.append(((this.positionID == null)?"<null>":this.positionID));
        sb.append(',');
        sb.append("changeDeleteIndicator");
        sb.append('=');
        sb.append(((this.changeDeleteIndicator == null)?"<null>":this.changeDeleteIndicator));
        sb.append(',');
        sb.append("positionNumber");
        sb.append('=');
        sb.append(((this.positionNumber == null)?"<null>":this.positionNumber));
        sb.append(',');
        sb.append("positionTitle");
        sb.append('=');
        sb.append(((this.positionTitle == null)?"<null>":this.positionTitle));
        sb.append(',');
        sb.append("deaneryNumber");
        sb.append('=');
        sb.append(((this.deaneryNumber == null)?"<null>":this.deaneryNumber));
        sb.append(',');
        sb.append("managingOffice");
        sb.append('=');
        sb.append(((this.managingOffice == null)?"<null>":this.managingOffice));
        sb.append(',');
        sb.append("odsCode");
        sb.append('=');
        sb.append(((this.odsCode == null)?"<null>":this.odsCode));
        sb.append(',');
        sb.append("hostLeadIndicator");
        sb.append('=');
        sb.append(((this.hostLeadIndicator == null)?"<null>":this.hostLeadIndicator));
        sb.append(',');
        sb.append("employingOrgVPDCode");
        sb.append('=');
        sb.append(((this.employingOrgVPDCode == null)?"<null>":this.employingOrgVPDCode));
        sb.append(',');
        sb.append("esrOrganisation");
        sb.append('=');
        sb.append(((this.esrOrganisation == null)?"<null>":this.esrOrganisation));
        sb.append(',');
        sb.append("esrLocation");
        sb.append('=');
        sb.append(((this.esrLocation == null)?"<null>":this.esrLocation));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.managingOffice == null)? 0 :this.managingOffice.hashCode()));
        result = ((result* 31)+((this.esrLocation == null)? 0 :this.esrLocation.hashCode()));
        result = ((result* 31)+((this.positionTitle == null)? 0 :this.positionTitle.hashCode()));
        result = ((result* 31)+((this.employingOrgVPDCode == null)? 0 :this.employingOrgVPDCode.hashCode()));
        result = ((result* 31)+((this.positionID == null)? 0 :this.positionID.hashCode()));
        result = ((result* 31)+((this.odsCode == null)? 0 :this.odsCode.hashCode()));
        result = ((result* 31)+((this.deaneryNumber == null)? 0 :this.deaneryNumber.hashCode()));
        result = ((result* 31)+((this.esrOrganisation == null)? 0 :this.esrOrganisation.hashCode()));
        result = ((result* 31)+((this.positionNumber == null)? 0 :this.positionNumber.hashCode()));
        result = ((result* 31)+((this.hostLeadIndicator == null)? 0 :this.hostLeadIndicator.hashCode()));
        result = ((result* 31)+((this.changeDeleteIndicator == null)? 0 :this.changeDeleteIndicator.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PORSchema) == false) {
            return false;
        }
        PORSchema rhs = ((PORSchema) other);
        return ((((((((((((this.managingOffice == rhs.managingOffice)||((this.managingOffice!= null)&&this.managingOffice.equals(rhs.managingOffice)))&&((this.esrLocation == rhs.esrLocation)||((this.esrLocation!= null)&&this.esrLocation.equals(rhs.esrLocation))))&&((this.positionTitle == rhs.positionTitle)||((this.positionTitle!= null)&&this.positionTitle.equals(rhs.positionTitle))))&&((this.employingOrgVPDCode == rhs.employingOrgVPDCode)||((this.employingOrgVPDCode!= null)&&this.employingOrgVPDCode.equals(rhs.employingOrgVPDCode))))&&((this.positionID == rhs.positionID)||((this.positionID!= null)&&this.positionID.equals(rhs.positionID))))&&((this.odsCode == rhs.odsCode)||((this.odsCode!= null)&&this.odsCode.equals(rhs.odsCode))))&&((this.deaneryNumber == rhs.deaneryNumber)||((this.deaneryNumber!= null)&&this.deaneryNumber.equals(rhs.deaneryNumber))))&&((this.esrOrganisation == rhs.esrOrganisation)||((this.esrOrganisation!= null)&&this.esrOrganisation.equals(rhs.esrOrganisation))))&&((this.positionNumber == rhs.positionNumber)||((this.positionNumber!= null)&&this.positionNumber.equals(rhs.positionNumber))))&&((this.hostLeadIndicator == rhs.hostLeadIndicator)||((this.hostLeadIndicator!= null)&&this.hostLeadIndicator.equals(rhs.hostLeadIndicator))))&&((this.changeDeleteIndicator == rhs.changeDeleteIndicator)||((this.changeDeleteIndicator!= null)&&this.changeDeleteIndicator.equals(rhs.changeDeleteIndicator))));
    }

    public enum ChangeDeleteIndicator {

        C("C"),
        D("D");
        private final String value;
        private final static Map<String, PORSchema.ChangeDeleteIndicator> CONSTANTS = new HashMap<String, PORSchema.ChangeDeleteIndicator>();

        static {
            for (PORSchema.ChangeDeleteIndicator c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private ChangeDeleteIndicator(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static PORSchema.ChangeDeleteIndicator fromValue(String value) {
            PORSchema.ChangeDeleteIndicator constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    public enum HostLeadIndicator {

        HOST_EMPLOYER("Host Employer"),
        LEAD_EMPLOYER("Lead Employer");
        private final String value;
        private final static Map<String, PORSchema.HostLeadIndicator> CONSTANTS = new HashMap<String, PORSchema.HostLeadIndicator>();

        static {
            for (PORSchema.HostLeadIndicator c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private HostLeadIndicator(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static PORSchema.HostLeadIndicator fromValue(String value) {
            PORSchema.HostLeadIndicator constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
