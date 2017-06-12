package io.swagger.api;

import io.swagger.model.Job;

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

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-02-22T11:32:19.455Z")

@Api(value = "Jobs", description = "the Jobs API")
public interface JobsApi {

    @ApiOperation(value = "get the available job's list", notes = "Get the list of the jobs available on the configurated HDFS  ", response = Job.class, responseContainer = "List", tags={ "developers", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "list of jobs", response = Job.class),
        @ApiResponse(code = 400, message = "bad input parameter", response = Job.class) })
    @RequestMapping(value = "/Jobs",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Job>> jobList();

}
