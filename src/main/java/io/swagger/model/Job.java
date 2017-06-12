package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.joda.time.DateTime;

/**
 * Job
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-02-22T11:32:19.455Z")

public class Job   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("date")
  private DateTime date = null;

  @JsonProperty("nworkers")
  private Integer nworkers = null;

  public Job id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(example = "job_1484912432740_0001", required = true, value = "")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Job date(DateTime date) {
    this.date = date;
    return this;
  }

   /**
   * Get date
   * @return date
  **/
  @ApiModelProperty(example = "11/02/2017 15:41", required = true, value = "")
  public DateTime getDate() {
    return date;
  }

  public void setDate(DateTime date) {
    this.date = date;
  }

  public Job nworkers(Integer nworkers) {
    this.nworkers = nworkers;
    return this;
  }

   /**
   * Get nworkers
   * @return nworkers
  **/
  @ApiModelProperty(required = true, value = "")
  public Integer getNworkers() {
    return nworkers;
  }

  public void setNworkers(Integer nworkers) {
    this.nworkers = nworkers;
  }

//  public Job nhosts(Integer nhosts) {
//    this.nhosts = nhosts;
//    return this;
//  }
//
//   /**
//   * Get nhosts
//   * @return nhosts
//  **/
//  @ApiModelProperty(required = true, value = "")
//  public Integer getNhosts() {
//    return nhosts;
//  }
//
//  public void setNhosts(Integer nhosts) {
//    this.nhosts = nhosts;
//  }
//
//  public Job nracks(Integer nracks) {
//    this.nracks = nracks;
//    return this;
//  }

//   /**
//   * Get nracks
//   * @return nracks
//  **/
//  @ApiModelProperty(required = true, value = "")
//  public Integer getNracks() {
//    return nracks;
//  }
//
//  public void setNracks(Integer nracks) {
//    this.nracks = nracks;
//  }

//  public Job nsupersteps(Integer nsupersteps) {
//    this.nsupersteps = nsupersteps;
//    return this;
//  }

//   /**
//   * Get nsupersteps
//   * @return nsupersteps
//  **/
//  @ApiModelProperty(required = true, value = "")
//  public Integer getNsupersteps() {
//    return nsupersteps;
//  }
//
//  public void setNsupersteps(Integer nsupersteps) {
//    this.nsupersteps = nsupersteps;
//  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Job job = (Job) o;
    return Objects.equals(this.id, job.id) &&
        Objects.equals(this.date, job.date) &&
        Objects.equals(this.nworkers, job.nworkers);// &&
//        Objects.equals(this.nhosts, job.nhosts) &&
//        Objects.equals(this.nracks, job.nracks) &&
//        Objects.equals(this.nsupersteps, job.nsupersteps);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, date, nworkers);//, nhosts, nracks, nsupersteps);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Job {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    nworkers: ").append(toIndentedString(nworkers)).append("\n");
//    sb.append("    nhosts: ").append(toIndentedString(nhosts)).append("\n");
//    sb.append("    nracks: ").append(toIndentedString(nracks)).append("\n");
//    sb.append("    nsupersteps: ").append(toIndentedString(nsupersteps)).append("\n");
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

