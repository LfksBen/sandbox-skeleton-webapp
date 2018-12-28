#!/usr/bin/env groovy

@Library('cbp@feature/cloudbycbp_EA') _ // spécial pour ext conf

maven3Pipeline(
        [
                email             : "benjamin.braud@cbp-group.com, ",
                nodeName          : "linux && !gui-test",
                buildToKeep       : "10",
                jdkVersion : 'jdk-8u101',
                branchSonar : 'develop',
                continuousAWS     : true,
                gitCredential     : 'github',
                deployName        : 'disponibilite-gestionnaires-services',
                deployTarget        : 'cloudbycbp-v2-ec', // spécial pour ext conf
                environmentsListSnapshot  : ['i1'],
                environmentsListRelease  : ['r1', 'r2', 'r3'],
        ]
)