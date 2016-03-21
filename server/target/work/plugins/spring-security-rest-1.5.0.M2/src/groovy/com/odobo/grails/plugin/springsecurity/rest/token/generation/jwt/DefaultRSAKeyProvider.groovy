package com.odobo.grails.plugin.springsecurity.rest.token.generation.jwt

import groovy.util.logging.Slf4j

import java.security.KeyFactory
import java.security.KeyPair
import java.security.KeyPairGenerator
import java.security.interfaces.RSAPrivateKey
import java.security.interfaces.RSAPublicKey
import java.security.spec.RSAPrivateKeySpec
import java.security.spec.RSAPublicKeySpec

/**
 * Generates a key pair on the fly. Should be used only for testing purposes, but other than that, a proper
 * {@link FileRSAKeyProvider} should be used.
 */
@Slf4j
class DefaultRSAKeyProvider implements RSAKeyProvider {

    RSAPublicKey publicKey

    RSAPrivateKey privateKey

    DefaultRSAKeyProvider() {
        log.warn "*"*80
        log.warn "* WARNING: you are using the default RSA key provider, which generates a pair  *"
        log.warn "* of public/private keys every time the application runs. This means that      *"
        log.warn "* generated tokens won't be decrypted across executions.                       *"
        log.warn "*                                                                              *"
        log.warn "* Please generate your own keys using SSL and switch to a FileRSAKeyProvider.  *"
        log.warn "*"*80

        // create an instance of KeyPairGenerator suitable for generating RSA keys
        // and initialise it with the bit length of the modulus required
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA")
        keyPairGenerator.initialize(1024)

        // generate the key pair
        KeyPair keyPair = keyPairGenerator.genKeyPair()

        // create KeyFactory and RSA Keys Specs
        KeyFactory keyFactory = KeyFactory.getInstance("RSA")
        RSAPublicKeySpec publicKeySpec = keyFactory.getKeySpec(keyPair.public, RSAPublicKeySpec)
        RSAPrivateKeySpec privateKeySpec = keyFactory.getKeySpec(keyPair.private, RSAPrivateKeySpec)

        // generate (and retrieve) RSA Keys from the KeyFactory using Keys Specs
        publicKey = keyFactory.generatePublic(publicKeySpec) as RSAPublicKey
        privateKey = keyFactory.generatePrivate(privateKeySpec) as RSAPrivateKey
    }
}
