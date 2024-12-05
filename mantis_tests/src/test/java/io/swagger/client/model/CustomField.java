/*
 * MantisBT REST API
 * For the sandbox to work, MantisBT must be hosted at the root folder of the host. For example: http://mantishost/ rather http://host/mantisbt.  If that is not the case, then create a host alias to map it as such or edit swagger.json to change basePath to include the mantisbt folder name.
 *
 * OpenAPI spec version: 1.1.1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.AccessLevel;
import java.io.IOException;

/**
 * CustomField
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2024-12-02T21:54:22.796+03:00")
public class CustomField {
  @SerializedName("id")
  private Long id = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("type")
  private String type = null;

  @SerializedName("default_value")
  private String defaultValue = null;

  @SerializedName("possible_values")
  private String possibleValues = null;

  @SerializedName("valid_regexp")
  private String validRegexp = null;

  @SerializedName("length_min")
  private Integer lengthMin = null;

  @SerializedName("length_max")
  private Integer lengthMax = null;

  @SerializedName("access_level_r")
  private AccessLevel accessLevelR = null;

  @SerializedName("access_level_rw")
  private AccessLevel accessLevelRw = null;

  @SerializedName("display_report")
  private Boolean displayReport = null;

  @SerializedName("display_update")
  private Boolean displayUpdate = null;

  @SerializedName("display_resolved")
  private Boolean displayResolved = null;

  @SerializedName("display_closed")
  private Boolean displayClosed = null;

  @SerializedName("require_report")
  private Boolean requireReport = null;

  @SerializedName("require_update")
  private Boolean requireUpdate = null;

  @SerializedName("require_resolved")
  private Boolean requireResolved = null;

  @SerializedName("require_closed")
  private Boolean requireClosed = null;

  public CustomField id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(required = true, value = "")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public CustomField name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CustomField type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(required = true, value = "")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public CustomField defaultValue(String defaultValue) {
    this.defaultValue = defaultValue;
    return this;
  }

   /**
   * Get defaultValue
   * @return defaultValue
  **/
  @ApiModelProperty(value = "")
  public String getDefaultValue() {
    return defaultValue;
  }

  public void setDefaultValue(String defaultValue) {
    this.defaultValue = defaultValue;
  }

  public CustomField possibleValues(String possibleValues) {
    this.possibleValues = possibleValues;
    return this;
  }

   /**
   * Get possibleValues
   * @return possibleValues
  **/
  @ApiModelProperty(value = "")
  public String getPossibleValues() {
    return possibleValues;
  }

  public void setPossibleValues(String possibleValues) {
    this.possibleValues = possibleValues;
  }

  public CustomField validRegexp(String validRegexp) {
    this.validRegexp = validRegexp;
    return this;
  }

   /**
   * Get validRegexp
   * @return validRegexp
  **/
  @ApiModelProperty(value = "")
  public String getValidRegexp() {
    return validRegexp;
  }

  public void setValidRegexp(String validRegexp) {
    this.validRegexp = validRegexp;
  }

  public CustomField lengthMin(Integer lengthMin) {
    this.lengthMin = lengthMin;
    return this;
  }

   /**
   * Get lengthMin
   * @return lengthMin
  **/
  @ApiModelProperty(value = "")
  public Integer getLengthMin() {
    return lengthMin;
  }

  public void setLengthMin(Integer lengthMin) {
    this.lengthMin = lengthMin;
  }

  public CustomField lengthMax(Integer lengthMax) {
    this.lengthMax = lengthMax;
    return this;
  }

   /**
   * Get lengthMax
   * @return lengthMax
  **/
  @ApiModelProperty(value = "")
  public Integer getLengthMax() {
    return lengthMax;
  }

  public void setLengthMax(Integer lengthMax) {
    this.lengthMax = lengthMax;
  }

  public CustomField accessLevelR(AccessLevel accessLevelR) {
    this.accessLevelR = accessLevelR;
    return this;
  }

   /**
   * Get accessLevelR
   * @return accessLevelR
  **/
  @ApiModelProperty(value = "")
  public AccessLevel getAccessLevelR() {
    return accessLevelR;
  }

  public void setAccessLevelR(AccessLevel accessLevelR) {
    this.accessLevelR = accessLevelR;
  }

  public CustomField accessLevelRw(AccessLevel accessLevelRw) {
    this.accessLevelRw = accessLevelRw;
    return this;
  }

   /**
   * Get accessLevelRw
   * @return accessLevelRw
  **/
  @ApiModelProperty(value = "")
  public AccessLevel getAccessLevelRw() {
    return accessLevelRw;
  }

  public void setAccessLevelRw(AccessLevel accessLevelRw) {
    this.accessLevelRw = accessLevelRw;
  }

  public CustomField displayReport(Boolean displayReport) {
    this.displayReport = displayReport;
    return this;
  }

   /**
   * Get displayReport
   * @return displayReport
  **/
  @ApiModelProperty(value = "")
  public Boolean isDisplayReport() {
    return displayReport;
  }

  public void setDisplayReport(Boolean displayReport) {
    this.displayReport = displayReport;
  }

  public CustomField displayUpdate(Boolean displayUpdate) {
    this.displayUpdate = displayUpdate;
    return this;
  }

   /**
   * Get displayUpdate
   * @return displayUpdate
  **/
  @ApiModelProperty(value = "")
  public Boolean isDisplayUpdate() {
    return displayUpdate;
  }

  public void setDisplayUpdate(Boolean displayUpdate) {
    this.displayUpdate = displayUpdate;
  }

  public CustomField displayResolved(Boolean displayResolved) {
    this.displayResolved = displayResolved;
    return this;
  }

   /**
   * Get displayResolved
   * @return displayResolved
  **/
  @ApiModelProperty(value = "")
  public Boolean isDisplayResolved() {
    return displayResolved;
  }

  public void setDisplayResolved(Boolean displayResolved) {
    this.displayResolved = displayResolved;
  }

  public CustomField displayClosed(Boolean displayClosed) {
    this.displayClosed = displayClosed;
    return this;
  }

   /**
   * Get displayClosed
   * @return displayClosed
  **/
  @ApiModelProperty(value = "")
  public Boolean isDisplayClosed() {
    return displayClosed;
  }

  public void setDisplayClosed(Boolean displayClosed) {
    this.displayClosed = displayClosed;
  }

  public CustomField requireReport(Boolean requireReport) {
    this.requireReport = requireReport;
    return this;
  }

   /**
   * Get requireReport
   * @return requireReport
  **/
  @ApiModelProperty(value = "")
  public Boolean isRequireReport() {
    return requireReport;
  }

  public void setRequireReport(Boolean requireReport) {
    this.requireReport = requireReport;
  }

  public CustomField requireUpdate(Boolean requireUpdate) {
    this.requireUpdate = requireUpdate;
    return this;
  }

   /**
   * Get requireUpdate
   * @return requireUpdate
  **/
  @ApiModelProperty(value = "")
  public Boolean isRequireUpdate() {
    return requireUpdate;
  }

  public void setRequireUpdate(Boolean requireUpdate) {
    this.requireUpdate = requireUpdate;
  }

  public CustomField requireResolved(Boolean requireResolved) {
    this.requireResolved = requireResolved;
    return this;
  }

   /**
   * Get requireResolved
   * @return requireResolved
  **/
  @ApiModelProperty(value = "")
  public Boolean isRequireResolved() {
    return requireResolved;
  }

  public void setRequireResolved(Boolean requireResolved) {
    this.requireResolved = requireResolved;
  }

  public CustomField requireClosed(Boolean requireClosed) {
    this.requireClosed = requireClosed;
    return this;
  }

   /**
   * Get requireClosed
   * @return requireClosed
  **/
  @ApiModelProperty(value = "")
  public Boolean isRequireClosed() {
    return requireClosed;
  }

  public void setRequireClosed(Boolean requireClosed) {
    this.requireClosed = requireClosed;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomField customField = (CustomField) o;
    return Objects.equals(this.id, customField.id) &&
        Objects.equals(this.name, customField.name) &&
        Objects.equals(this.type, customField.type) &&
        Objects.equals(this.defaultValue, customField.defaultValue) &&
        Objects.equals(this.possibleValues, customField.possibleValues) &&
        Objects.equals(this.validRegexp, customField.validRegexp) &&
        Objects.equals(this.lengthMin, customField.lengthMin) &&
        Objects.equals(this.lengthMax, customField.lengthMax) &&
        Objects.equals(this.accessLevelR, customField.accessLevelR) &&
        Objects.equals(this.accessLevelRw, customField.accessLevelRw) &&
        Objects.equals(this.displayReport, customField.displayReport) &&
        Objects.equals(this.displayUpdate, customField.displayUpdate) &&
        Objects.equals(this.displayResolved, customField.displayResolved) &&
        Objects.equals(this.displayClosed, customField.displayClosed) &&
        Objects.equals(this.requireReport, customField.requireReport) &&
        Objects.equals(this.requireUpdate, customField.requireUpdate) &&
        Objects.equals(this.requireResolved, customField.requireResolved) &&
        Objects.equals(this.requireClosed, customField.requireClosed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, type, defaultValue, possibleValues, validRegexp, lengthMin, lengthMax, accessLevelR, accessLevelRw, displayReport, displayUpdate, displayResolved, displayClosed, requireReport, requireUpdate, requireResolved, requireClosed);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomField {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    defaultValue: ").append(toIndentedString(defaultValue)).append("\n");
    sb.append("    possibleValues: ").append(toIndentedString(possibleValues)).append("\n");
    sb.append("    validRegexp: ").append(toIndentedString(validRegexp)).append("\n");
    sb.append("    lengthMin: ").append(toIndentedString(lengthMin)).append("\n");
    sb.append("    lengthMax: ").append(toIndentedString(lengthMax)).append("\n");
    sb.append("    accessLevelR: ").append(toIndentedString(accessLevelR)).append("\n");
    sb.append("    accessLevelRw: ").append(toIndentedString(accessLevelRw)).append("\n");
    sb.append("    displayReport: ").append(toIndentedString(displayReport)).append("\n");
    sb.append("    displayUpdate: ").append(toIndentedString(displayUpdate)).append("\n");
    sb.append("    displayResolved: ").append(toIndentedString(displayResolved)).append("\n");
    sb.append("    displayClosed: ").append(toIndentedString(displayClosed)).append("\n");
    sb.append("    requireReport: ").append(toIndentedString(requireReport)).append("\n");
    sb.append("    requireUpdate: ").append(toIndentedString(requireUpdate)).append("\n");
    sb.append("    requireResolved: ").append(toIndentedString(requireResolved)).append("\n");
    sb.append("    requireClosed: ").append(toIndentedString(requireClosed)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
