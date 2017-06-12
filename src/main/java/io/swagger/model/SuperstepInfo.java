package io.swagger.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * SuperstepInfo
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-05-10T09:50:51.068Z")

public class SuperstepInfo   {
  @JsonProperty("index")
  private BigDecimal superstepIndex = null;

  @JsonProperty("duration")
  private BigDecimal reportedDuration = null;

  
  @JsonProperty("computationName")
  private String computationName = null;

  @JsonProperty("superstepDetailsPerWorker")
  private List<BlockDetailsPerElement> superstepDetailsPerWorker = new ArrayList<BlockDetailsPerElement>();

  public SuperstepInfo superstepIndex(BigDecimal superstepIndex, String computationName) {
    this.superstepIndex = superstepIndex;
    this.computationName = computationName;
    return this;
  }

   /**
   * Get superstepIndex
   * @return superstepIndex
  **/
  @ApiModelProperty(required = true, value = "")
  public BigDecimal getSuperstepIndex() {
    return superstepIndex;
  }

  public void setSuperstepIndex(BigDecimal superstepIndex) {
    this.superstepIndex = superstepIndex;
  }

  public SuperstepInfo computationName(String computationName) {
    this.computationName = computationName;
    return this;
  }

   /**
   * Get computationName
   * @return computationName
  **/
  @ApiModelProperty(required = true, value = "")
  public String getComputationName() {
    return computationName;
  }

  public void setComputationName(String computationName) {
    this.computationName = computationName;
  }

  @ApiModelProperty(required = true, value = "")
  public BigDecimal getReportedDuration() {
	return reportedDuration;
}

public void setReportedDuration(BigDecimal reportedDuration) {
	this.reportedDuration = reportedDuration;
}

public SuperstepInfo superstepDetailsPerWorker(List<BlockDetailsPerElement> superstepDetailsPerWorker) {
    this.superstepDetailsPerWorker = superstepDetailsPerWorker;
    return this;
  }

  public SuperstepInfo addSuperstepDetailsPerWorkerItem(BlockDetailsPerElement superstepDetailsPerWorkerItem) {
    this.superstepDetailsPerWorker.add(superstepDetailsPerWorkerItem);
    return this;
  }

   /**
   * Get superstepDetailsPerWorker
   * @return superstepDetailsPerWorker
  **/
  @ApiModelProperty(required = true, value = "")
  public List<BlockDetailsPerElement> getSuperstepDetailsPerWorker() {
    return superstepDetailsPerWorker;
  }

  public void setSuperstepDetailsPerWorker(List<BlockDetailsPerElement> superstepDetailsPerWorker) {
    this.superstepDetailsPerWorker = superstepDetailsPerWorker;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SuperstepInfo superstepInfo = (SuperstepInfo) o;
    return Objects.equals(this.superstepIndex, superstepInfo.superstepIndex) &&
        Objects.equals(this.computationName, superstepInfo.computationName) &&
        Objects.equals(this.superstepDetailsPerWorker, superstepInfo.superstepDetailsPerWorker);
  }

  @Override
  public int hashCode() {
    return Objects.hash(superstepIndex, computationName, superstepDetailsPerWorker);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuperstepInfo {\n");
    
    sb.append("    superstepIndex: ").append(toIndentedString(superstepIndex)).append("\n");
    sb.append("    computationName: ").append(toIndentedString(computationName)).append("\n");
    sb.append("    superstepDetailsPerWorker: ").append(toIndentedString(superstepDetailsPerWorker)).append("\n");
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
