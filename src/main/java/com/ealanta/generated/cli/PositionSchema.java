
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
    "occupationCode",
    "areaOfWork",
    "secondSpeciality",
    "deaneryNumber",
    "managingOffice",
    "odsCode",
    "gradeTrust",
    "gradePayscale",
    "gradeDesc",
    "workplaceOrg"
})
public class PositionSchema {

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
    private PositionSchema.ChangeDeleteIndicator changeDeleteIndicator;
    @JsonProperty("positionNumber")
    @Size(max = 10)
    private Long positionNumber;
    @JsonProperty("positionTitle")
    @Size(max = 60)
    private String positionTitle;
    @JsonProperty("occupationCode")
    @Size(max = 5)
    private String occupationCode;
    @JsonProperty("areaOfWork")
    @Size(max = 50)
    private String areaOfWork;
    @JsonProperty("secondSpeciality")
    @Size(max = 5)
    private String secondSpeciality;
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
    @JsonProperty("gradeTrust")
    @Size(max = 3)
    private String gradeTrust;
    @JsonProperty("gradePayscale")
    @Size(max = 10)
    private String gradePayscale;
    @JsonProperty("gradeDesc")
    @Size(max = 60)
    private String gradeDesc;
    @JsonProperty("workplaceOrg")
    @Size(max = 30)
    private String workplaceOrg;

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
    public PositionSchema.ChangeDeleteIndicator getChangeDeleteIndicator() {
        return changeDeleteIndicator;
    }

    @JsonProperty("changeDeleteIndicator")
    public void setChangeDeleteIndicator(PositionSchema.ChangeDeleteIndicator changeDeleteIndicator) {
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

    @JsonProperty("occupationCode")
    public String getOccupationCode() {
        return occupationCode;
    }

    @JsonProperty("occupationCode")
    public void setOccupationCode(String occupationCode) {
        this.occupationCode = occupationCode;
    }

    @JsonProperty("areaOfWork")
    public String getAreaOfWork() {
        return areaOfWork;
    }

    @JsonProperty("areaOfWork")
    public void setAreaOfWork(String areaOfWork) {
        this.areaOfWork = areaOfWork;
    }

    @JsonProperty("secondSpeciality")
    public String getSecondSpeciality() {
        return secondSpeciality;
    }

    @JsonProperty("secondSpeciality")
    public void setSecondSpeciality(String secondSpeciality) {
        this.secondSpeciality = secondSpeciality;
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

    @JsonProperty("gradeTrust")
    public String getGradeTrust() {
        return gradeTrust;
    }

    @JsonProperty("gradeTrust")
    public void setGradeTrust(String gradeTrust) {
        this.gradeTrust = gradeTrust;
    }

    @JsonProperty("gradePayscale")
    public String getGradePayscale() {
        return gradePayscale;
    }

    @JsonProperty("gradePayscale")
    public void setGradePayscale(String gradePayscale) {
        this.gradePayscale = gradePayscale;
    }

    @JsonProperty("gradeDesc")
    public String getGradeDesc() {
        return gradeDesc;
    }

    @JsonProperty("gradeDesc")
    public void setGradeDesc(String gradeDesc) {
        this.gradeDesc = gradeDesc;
    }

    @JsonProperty("workplaceOrg")
    public String getWorkplaceOrg() {
        return workplaceOrg;
    }

    @JsonProperty("workplaceOrg")
    public void setWorkplaceOrg(String workplaceOrg) {
        this.workplaceOrg = workplaceOrg;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PositionSchema.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        sb.append("occupationCode");
        sb.append('=');
        sb.append(((this.occupationCode == null)?"<null>":this.occupationCode));
        sb.append(',');
        sb.append("areaOfWork");
        sb.append('=');
        sb.append(((this.areaOfWork == null)?"<null>":this.areaOfWork));
        sb.append(',');
        sb.append("secondSpeciality");
        sb.append('=');
        sb.append(((this.secondSpeciality == null)?"<null>":this.secondSpeciality));
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
        sb.append("gradeTrust");
        sb.append('=');
        sb.append(((this.gradeTrust == null)?"<null>":this.gradeTrust));
        sb.append(',');
        sb.append("gradePayscale");
        sb.append('=');
        sb.append(((this.gradePayscale == null)?"<null>":this.gradePayscale));
        sb.append(',');
        sb.append("gradeDesc");
        sb.append('=');
        sb.append(((this.gradeDesc == null)?"<null>":this.gradeDesc));
        sb.append(',');
        sb.append("workplaceOrg");
        sb.append('=');
        sb.append(((this.workplaceOrg == null)?"<null>":this.workplaceOrg));
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
        result = ((result* 31)+((this.areaOfWork == null)? 0 :this.areaOfWork.hashCode()));
        result = ((result* 31)+((this.positionTitle == null)? 0 :this.positionTitle.hashCode()));
        result = ((result* 31)+((this.secondSpeciality == null)? 0 :this.secondSpeciality.hashCode()));
        result = ((result* 31)+((this.odsCode == null)? 0 :this.odsCode.hashCode()));
        result = ((result* 31)+((this.positionNumber == null)? 0 :this.positionNumber.hashCode()));
        result = ((result* 31)+((this.managingOffice == null)? 0 :this.managingOffice.hashCode()));
        result = ((result* 31)+((this.positionID == null)? 0 :this.positionID.hashCode()));
        result = ((result* 31)+((this.occupationCode == null)? 0 :this.occupationCode.hashCode()));
        result = ((result* 31)+((this.gradeTrust == null)? 0 :this.gradeTrust.hashCode()));
        result = ((result* 31)+((this.deaneryNumber == null)? 0 :this.deaneryNumber.hashCode()));
        result = ((result* 31)+((this.gradeDesc == null)? 0 :this.gradeDesc.hashCode()));
        result = ((result* 31)+((this.workplaceOrg == null)? 0 :this.workplaceOrg.hashCode()));
        result = ((result* 31)+((this.gradePayscale == null)? 0 :this.gradePayscale.hashCode()));
        result = ((result* 31)+((this.changeDeleteIndicator == null)? 0 :this.changeDeleteIndicator.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PositionSchema) == false) {
            return false;
        }
        PositionSchema rhs = ((PositionSchema) other);
        return (((((((((((((((this.areaOfWork == rhs.areaOfWork)||((this.areaOfWork!= null)&&this.areaOfWork.equals(rhs.areaOfWork)))&&((this.positionTitle == rhs.positionTitle)||((this.positionTitle!= null)&&this.positionTitle.equals(rhs.positionTitle))))&&((this.secondSpeciality == rhs.secondSpeciality)||((this.secondSpeciality!= null)&&this.secondSpeciality.equals(rhs.secondSpeciality))))&&((this.odsCode == rhs.odsCode)||((this.odsCode!= null)&&this.odsCode.equals(rhs.odsCode))))&&((this.positionNumber == rhs.positionNumber)||((this.positionNumber!= null)&&this.positionNumber.equals(rhs.positionNumber))))&&((this.managingOffice == rhs.managingOffice)||((this.managingOffice!= null)&&this.managingOffice.equals(rhs.managingOffice))))&&((this.positionID == rhs.positionID)||((this.positionID!= null)&&this.positionID.equals(rhs.positionID))))&&((this.occupationCode == rhs.occupationCode)||((this.occupationCode!= null)&&this.occupationCode.equals(rhs.occupationCode))))&&((this.gradeTrust == rhs.gradeTrust)||((this.gradeTrust!= null)&&this.gradeTrust.equals(rhs.gradeTrust))))&&((this.deaneryNumber == rhs.deaneryNumber)||((this.deaneryNumber!= null)&&this.deaneryNumber.equals(rhs.deaneryNumber))))&&((this.gradeDesc == rhs.gradeDesc)||((this.gradeDesc!= null)&&this.gradeDesc.equals(rhs.gradeDesc))))&&((this.workplaceOrg == rhs.workplaceOrg)||((this.workplaceOrg!= null)&&this.workplaceOrg.equals(rhs.workplaceOrg))))&&((this.gradePayscale == rhs.gradePayscale)||((this.gradePayscale!= null)&&this.gradePayscale.equals(rhs.gradePayscale))))&&((this.changeDeleteIndicator == rhs.changeDeleteIndicator)||((this.changeDeleteIndicator!= null)&&this.changeDeleteIndicator.equals(rhs.changeDeleteIndicator))));
    }

    public enum ChangeDeleteIndicator {

        C("C"),
        D("D");
        private final String value;
        private final static Map<String, PositionSchema.ChangeDeleteIndicator> CONSTANTS = new HashMap<String, PositionSchema.ChangeDeleteIndicator>();

        static {
            for (PositionSchema.ChangeDeleteIndicator c: values()) {
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
        public static PositionSchema.ChangeDeleteIndicator fromValue(String value) {
            PositionSchema.ChangeDeleteIndicator constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
