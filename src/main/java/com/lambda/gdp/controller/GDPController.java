package com.lambda.gdp.controller;

import com.lambda.gdp.GdpApplication;
import com.lambda.gdp.exceptions.ResourceNotFoundException;
import com.lambda.gdp.model.GDP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@RestController

public class GDPController
{
    private static final Logger logger = LoggerFactory.getLogger(GDPController.class);
    // localhost:8080/names
    @GetMapping(value = "/names")
    public ResponseEntity<?> getAllGDP()
    {
        logger.info("WE ARE ACCESSING NAMES");
        GdpApplication.ourgdpList.gdpList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(GdpApplication.ourgdpList.gdpList, HttpStatus.OK);
    }

    @GetMapping(value = "/economy")
    public ResponseEntity<?> getMostGDP()
    {

        GdpApplication.ourgdpList.gdpList.sort((c1,c2) -> c2.getGDP() - c1.getGDP());
        return new ResponseEntity<>(GdpApplication.ourgdpList.gdpList, HttpStatus.OK);
    }

    // localhost:8080/gdp/{name}
    @GetMapping(value = "/gdp/{name}")
    public ResponseEntity<?> getGDPName(@PathVariable String name)
    {


            return new ResponseEntity<>(GdpApplication.ourgdpList.findGDP(c -> (c.getName().toUpperCase().equals(name.toUpperCase()))), HttpStatus.OK);





    }

    @GetMapping(value = "/country/{id}")
    public ResponseEntity<?> getGDPDetail(@PathVariable long id)
    {   GDP rtnGDP;
        if (GdpApplication.ourgdpList.findGDP(c -> (c.getId()) == id) == null )
        {
            throw new ResourceNotFoundException("Country with id "+id+" not found.");
        }
        else {
            rtnGDP = GdpApplication.ourgdpList.findGDP(c -> (c.getId() == id));
        }



        return new ResponseEntity<>(rtnGDP, HttpStatus.OK);
    }

    @GetMapping(value = "/economy/greatest/{gdp}")
    public ModelAndView displayGreatgdpTable(@PathVariable double gdp)
    { ArrayList<GDP> rtnGDP = GdpApplication.ourgdpList.findGDPS(c -> c.getGDP() > gdp);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("gdptable");
        mav.addObject("gdpList", rtnGDP);
        return mav;
    }

    @GetMapping(value = "/economy/table")
    public ModelAndView displaygdpTable()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("gdptable");
        mav.addObject("gdpList", GdpApplication.ourgdpList.gdpList);
        return mav;
    }



}
