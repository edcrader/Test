#!/usr/bin/env groovy

import hudson.model.*
import hudson.EnvVars
import groovy.json.JsonSlurperClassic
import groovy.json.JsonBuilder
import groovy.json.JsonOutput
import java.net.URL

node {
    stage("Stage 1"){
        def identification = /[A-Z]{2}\-\d{3,5}/

        def matcher = 'AB-1234' =~ identification
        println("hi")

        assert matcher.matchesPartially()

        matcher = 'XY-90' =~ identification
        assert matcher.matchesPartially()

        matcher = 'HA' =~ identification
        assert matcher.matchesPartially()

        matcher = 'A-431' =~ identification
        assert !matcher.matchesPartially()

        matcher = 'YK-901201' =~ identification
        assert !matcher.matchesPartially()
    }
}