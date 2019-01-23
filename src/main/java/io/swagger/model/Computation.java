package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Computation
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-19T09:01:25.126Z")

public class Computation   {
  @JsonProperty("classname")
  private String classname = null;

  @JsonProperty("occurrencies")
  private int occurrencies = 0;

  public Computation classname(String classname) {
    this.classname = classname;
    return this;
  }

   /**
   * Get classname
   * @return classname
  **/
  @ApiModelProperty(example = "SimpleShortestPathsComputation", required = true, value = "")
  @NotNull


  public String getClassname() {
    return classname;
  }

  public void setClassname(String classname) {
    this.classname = classname;
  }

  public Computation occurrencies(int occurrencies) {
    this.occurrencies = occurrencies;
    return this;
  }

   /**
   * Get occurrencies
   * @return occurrencies
  **/
  @ApiModelProperty(example = "2", required = true, value = "")
  @NotNull


  public int getOccurrencies() {
    return occurrencies;
  }

  public void setOccurrencies(int occurrencies) {
    this.occurrencies = occurrencies;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Computation computation = (Computation) o;
    return Objects.equals(this.classname, computation.classname) &&
        Objects.equals(this.occurrencies, computation.occurrencies);
  }

  @Override
  public int hashCode() {
    return Objects.hash(classname, occurrencies);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Computation {\n");
    
    sb.append("    classname: ").append(toIndentedString(classname)).append("\n");
    sb.append("    occurrencies: ").append(toIndentedString(occurrencies)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

