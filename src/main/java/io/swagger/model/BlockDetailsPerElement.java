package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

/**
 * SuperstepDetailsPerWorker
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-05-10T09:50:51.068Z")

public class BlockDetailsPerElement   {
  @JsonProperty("elementIndex")
  private String elementIndex = null;

  @JsonProperty("duration")
  private Double duration = null;

  @JsonProperty("computedVertices")
  private BigDecimal computedVertices = null;
  
  @JsonProperty("totalTrafficMessages")
  private int[] totalTrafficMessages = null;
  
  @JsonProperty("totalTrafficBytes")
  private int[] totalTrafficBytes = null;
  
  @JsonProperty("selfMessages")
  private BigDecimal selfMessages = null;

  @JsonProperty("selfBytes")
  private BigDecimal selfBytes = null; 
  
  public BlockDetailsPerElement elementIndex(String elementIndex) {
    this.elementIndex = elementIndex;
    return this;
  }

   /**
   * Get workerIndex
   * @return workerIndex
  **/
  @ApiModelProperty(required = true, value = "")
  public String getElementIndex() {
    return elementIndex;
  }

  public void setElementIndex(String elementIndex) {
    this.elementIndex = elementIndex;
  }

  public BlockDetailsPerElement duration(Double duration) {
    this.duration = duration;
    return this;
  }
  
  /**
  * Get selfTraffic
  * @return selfTraffic
 **/
 @ApiModelProperty(required = true, value = "")
 public BigDecimal getSelfMessages() {
   return selfMessages;
 }

 public void setSelfMessages(BigDecimal selfMessages) {
   this.selfMessages = selfMessages;
 }

 public BlockDetailsPerElement selfMessages(BigDecimal selfMessages) {
   this.selfMessages = selfMessages;
   return this;
 }
 
 /**
 * Get selfTraffic
 * @return selfTraffic
**/
@ApiModelProperty(required = true, value = "")
public BigDecimal getSelfBytes() {
  return selfBytes;
}

public void setSelfBytes(BigDecimal selfBytes) {
  this.selfBytes = selfBytes;
}

public BlockDetailsPerElement selfBytes(BigDecimal selfBytes) {
  this.selfBytes = selfBytes;
  return this;
}
  
  /**
  * Get totalTrafficMessages
  * @return totalTrafficMessages
 **/
 @ApiModelProperty(required = true, value = "")
 public int[] getTotalTrafficMessages() {
   return totalTrafficMessages;
 }

 public void setTotalTrafficMessages(int[] totalTrafficMessages) {
   this.totalTrafficMessages = totalTrafficMessages;
 }

 public BlockDetailsPerElement totalTrafficMessages(int[] totalTrafficMessages) {
   this.totalTrafficMessages = totalTrafficMessages;
   return this;
 }
 
 /**
 * Get totalTrafficBytes
 * @return totalTrafficBytes
**/
@ApiModelProperty(required = true, value = "")
public int[] getTotalTrafficBytes() {
  return totalTrafficBytes;
}

public void setTotalTrafficBytes(int[] totalTrafficBytes) {
  this.totalTrafficBytes = totalTrafficBytes;
}

public BlockDetailsPerElement totalTrafficBytes(int[] totalTrafficBytes) {
  this.totalTrafficBytes = totalTrafficBytes;
  return this;
}

   /**
   * Get duration
   * @return duration
  **/
  @ApiModelProperty(required = true, value = "")
  public Double getDuration() {
    return duration;
  }

  public void setDuration(Double duration) {
    this.duration = duration;
  }

  public BlockDetailsPerElement computedVertices(BigDecimal computedVertices) {
    this.computedVertices = computedVertices;
    return this;
  }

   /**
   * Get computedVertices
   * @return computedVertices
  **/
  @ApiModelProperty(required = true, value = "")
  public BigDecimal getComputedVertices() {
    return computedVertices;
  }

  public void setComputedVertices(BigDecimal computedVertices) {
    this.computedVertices = computedVertices;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BlockDetailsPerElement superstepDetailsPerWorker = (BlockDetailsPerElement) o;
    return Objects.equals(this.elementIndex, superstepDetailsPerWorker.elementIndex) &&
        Objects.equals(this.duration, superstepDetailsPerWorker.duration) &&
        Objects.equals(this.computedVertices, superstepDetailsPerWorker.computedVertices);
  }

  @Override
  public int hashCode() {
    return Objects.hash(elementIndex, duration, computedVertices);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuperstepDetailsPerWorker {\n");
    
    sb.append("    workerIndex: ").append(toIndentedString(elementIndex)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    computedVertices: ").append(toIndentedString(computedVertices)).append("\n");
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

