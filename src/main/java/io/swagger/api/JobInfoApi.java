package io.swagger.api;

import io.swagger.model.JobInfo;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-05-04T19:31:31.674Z")

@Api(value = "JobInfo", description = "the JobInfo API")
public interface JobInfoApi {

    @ApiOperation(value = "Get superstep details", notes = "Get superstep details ", response = JobInfo.class, tags={ "developers", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "job information", response = JobInfo.class),
        @ApiResponse(code = 400, message = "bad input parameter", response = JobInfo.class) })
    @RequestMapping(value = "/JobInfo",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<JobInfo> jobinfo(@ApiParam(value = "job id", required = true) @RequestParam(value = "jobid", required = true) String jobid);

}
